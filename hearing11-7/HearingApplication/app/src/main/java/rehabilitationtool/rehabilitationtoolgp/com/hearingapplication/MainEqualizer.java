package rehabilitationtool.rehabilitationtoolgp.com.hearingapplication;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.media.AudioDeviceInfo;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioTrack;
import android.media.MediaRecorder;
import android.media.audiofx.AcousticEchoCanceler;
import android.media.audiofx.BassBoost;
import android.media.audiofx.Equalizer;
import android.media.audiofx.LoudnessEnhancer;
import android.media.audiofx.NoiseSuppressor;
import android.media.audiofx.Visualizer;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.Manifest.permission.RECORD_AUDIO;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class MainEqualizer extends AppCompatActivity {

    private static final float VISUALIZER_HEIGHT_DIP = 50f;

    private Visualizer mVisualizer;
    private Equalizer mEqualizer;
    private LinearLayout mLinearLayout;
    private VisualizerView mVisualizerView;
////////////////////// live part //////////////////////////////////

    AudioManager am = null;
    AudioRecord record =null;
    AudioTrack track =null;
    SeekBar seekbar;
    TextView textview;
    AudioManager audioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_equalizer);

        setVolumeControlStream(AudioManager.MODE_IN_COMMUNICATION);
        init();
        (new Thread() {
            @Override
            public void run() {
                recordAndPlay();
            }
        }).start();
////////////////////////////////////////////////////////////////////////////////
        setVolumeControlStream(AudioManager.STREAM_MUSIC);
//        create the equalizer with default priority of 0 & attach to our media player
        mEqualizer = new Equalizer(2, track.getAudioSessionId());
        mEqualizer.setEnabled(true);

//        set up visualizer and equalizer bars
        setupVisualizerFxAndUI();
        setupEqualizerFxAndUI();

        // enable the visualizer
        mVisualizer.setEnabled(true);


        //volume control

        seekbar = (SeekBar)findViewById(R.id.seekbar);
        textview = (TextView)findViewById(R.id.message_id);

        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        seekbar.setMax(audioManager.getStreamMaxVolume(AudioManager.MODE_IN_COMMUNICATION));

        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                textview.setText("Media Volume : " + i);

                audioManager.setStreamVolume(AudioManager.MODE_IN_COMMUNICATION, i, 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
    ///////////////////////////////// live part //////////////////////////////////////////////////////


    @TargetApi(Build.VERSION_CODES.KITKAT)
    private void init() {
        if(CheckPermissions()) {
            int min = AudioRecord.getMinBufferSize(4000, AudioFormat.CHANNEL_IN_MONO, AudioFormat.ENCODING_PCM_16BIT);
            record = new AudioRecord(MediaRecorder.AudioSource.VOICE_COMMUNICATION, 4000, AudioFormat.CHANNEL_IN_MONO,
                    AudioFormat.ENCODING_PCM_16BIT, min);

            int maxJitter = AudioTrack.getMinBufferSize(4000, AudioFormat.CHANNEL_OUT_MONO, AudioFormat.ENCODING_PCM_16BIT);
            track = new AudioTrack(AudioManager.MODE_IN_COMMUNICATION, 4000, AudioFormat.CHANNEL_OUT_MONO,
                    AudioFormat.ENCODING_PCM_16BIT, maxJitter, AudioTrack.MODE_STREAM);

           LoudnessEnhancer enhancer = new LoudnessEnhancer(track.getAudioSessionId());
            NoiseSuppressor.create(track.getAudioSessionId());
            AcousticEchoCanceler.create(track.getAudioSessionId());

            enhancer.setTargetGain(1000);
            enhancer.setEnabled(true);
            BassBoost mBassBoost = new BassBoost(Integer.MAX_VALUE, track.getAudioSessionId());

            /*synchronized (SETTINGS_LOCK) {
                mBassBoost.setStrength((short) mBassBoostSettings.strength);
            }*/
           mBassBoost.setEnabled(true);

        }
        else
        {
            RequestPermissions();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {

        return true;
    }

    private void recordAndPlay() {
        short[] lin = new short[1024];
        int num = 0;
        am = (AudioManager) this.getSystemService(Context.AUDIO_SERVICE);
        am.setMode(AudioManager.MODE_IN_COMMUNICATION);
        record.startRecording();
        track.play();
        while (true) {
            num = record.read(lin, 0, 1024);
            track.write(lin, 0, num);
        }
    }


    boolean isPlaying=true;
    public void play(View view){

        Button playBtn=(Button) findViewById(R.id.playBtn);

        if (isHeadphonesPlugged()) {

        if(isPlaying){
            record.stop();
            track.pause();
            isPlaying=false;
            playBtn.setText("Play");
        }else{

            record.startRecording();
            track.play();
            isPlaying=true;
            playBtn.setText("Pause");
        }
      } else {
        record.stop();
        track.pause();
        isPlaying = false;
        playBtn.setText("Play");
        Toast.makeText(getApplicationContext(), "Please put your headphone", Toast.LENGTH_SHORT).show();

    }

}

    @TargetApi(Build.VERSION_CODES.M)
    private boolean isHeadphonesPlugged(){
        AudioManager audioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
        AudioDeviceInfo[] audioDevices = audioManager.getDevices(AudioManager.GET_DEVICES_ALL);
        for(AudioDeviceInfo deviceInfo : audioDevices){
            if(deviceInfo.getType()==AudioDeviceInfo.TYPE_WIRED_HEADPHONES
                    || deviceInfo.getType()==AudioDeviceInfo.TYPE_WIRED_HEADSET){
                return true;
            }
        }
        return false;
    }

    ///////////////////////////////////////////////////////////////////////////
    private void equalizeSound() {
//        set up the spinner
        ArrayList<String> equalizerPresetNames = new ArrayList<String>();
        ArrayAdapter<String> equalizerPresetSpinnerAdapter
                = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item,
                equalizerPresetNames);
        equalizerPresetSpinnerAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner equalizerPresetSpinner = (Spinner) findViewById(R.id.spinner);

//        get list of the device's equalizer presets
        for (short i = 0; i < mEqualizer.getNumberOfPresets(); i++) {
            equalizerPresetNames.add(mEqualizer.getPresetName(i));
        }

        equalizerPresetSpinner.setAdapter(equalizerPresetSpinnerAdapter);

//        handle the spinner item selections
        equalizerPresetSpinner.setOnItemSelectedListener(new AdapterView
                .OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent,
                                       View view, int position, long id) {
                //first list item selected by default and sets the preset accordingly
                mEqualizer.usePreset((short) position);
//                get the number of frequency bands for this equalizer engine
                short numberFrequencyBands = mEqualizer.getNumberOfBands();
//                get the lower gain setting for this equalizer band
                final short lowerEqualizerBandLevel = mEqualizer.getBandLevelRange()[0];

//                set seekBar indicators according to selected preset
                for (short i = 0; i < numberFrequencyBands; i++) {
                    short equalizerBandIndex = i;
                    SeekBar seekBar = (SeekBar) findViewById(equalizerBandIndex);
//                    get current gain setting for this equalizer band
//                    set the progress indicator of this seekBar to indicate the current gain value
                    seekBar.setProgress(mEqualizer
                            .getBandLevel(equalizerBandIndex) - lowerEqualizerBandLevel);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
//                not used
            }
        });
    }

    /* displays the SeekBar sliders for the supported equalizer frequency bands
     user can move sliders to change the frequency of the bands*/
    private void setupEqualizerFxAndUI() {

//        get reference to linear layout for the seekBars
        mLinearLayout = (LinearLayout) findViewById(R.id.linearLayoutEqual);

//        equalizer heading
        TextView equalizerHeading = new TextView(this);
        equalizerHeading.setText("Equalizer");
        equalizerHeading.setTextSize(20);
        equalizerHeading.setGravity(Gravity.CENTER_HORIZONTAL);
        mLinearLayout.addView(equalizerHeading);

//        get number frequency bands supported by the equalizer engine
        short numberFrequencyBands = mEqualizer.getNumberOfBands();

//        get the level ranges to be used in setting the band level
//        get lower limit of the range in milliBels
        final short lowerEqualizerBandLevel = mEqualizer.getBandLevelRange()[0];
//        get the upper limit of the range in millibels
        final short upperEqualizerBandLevel = mEqualizer.getBandLevelRange()[1];

//        loop through all the equalizer bands to display the band headings, lower
//        & upper levels and the seek bars
        for (short i = 0; i < numberFrequencyBands; i++) {
            final short equalizerBandIndex = i;

//            frequency header for each seekBar
            TextView frequencyHeaderTextview = new TextView(this);
            frequencyHeaderTextview.setLayoutParams(new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));
            frequencyHeaderTextview.setGravity(Gravity.CENTER_HORIZONTAL);
            frequencyHeaderTextview
                    .setText((mEqualizer.getCenterFreq(equalizerBandIndex) / 1000) + " Hz");
            mLinearLayout.addView(frequencyHeaderTextview);

//            set up linear layout to contain each seekBar
            LinearLayout seekBarRowLayout = new LinearLayout(this);
            seekBarRowLayout.setOrientation(LinearLayout.HORIZONTAL);

//            set up lower level textview for this seekBar
            TextView lowerEqualizerBandLevelTextview = new TextView(this);
            lowerEqualizerBandLevelTextview.setLayoutParams(new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));
            lowerEqualizerBandLevelTextview.setText((lowerEqualizerBandLevel / 100) + " dB");
//            set up upper level textview for this seekBar
            TextView upperEqualizerBandLevelTextview = new TextView(this);
            upperEqualizerBandLevelTextview.setLayoutParams(new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));
            upperEqualizerBandLevelTextview.setText((upperEqualizerBandLevel / 100) + " dB");

            //            **********  the seekBar  **************
//            set the layout parameters for the seekbar
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.weight = 1;

//            create a new seekBar
            SeekBar seekBar = new SeekBar(this);
//            give the seekBar an ID
            seekBar.setId(i);

            seekBar.setLayoutParams(layoutParams);
            seekBar.setMax(upperEqualizerBandLevel - lowerEqualizerBandLevel);
//            set the progress for this seekBar
            seekBar.setProgress(mEqualizer.getBandLevel(equalizerBandIndex));

//            change progress as its changed by moving the sliders
            seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                public void onProgressChanged(SeekBar seekBar, int progress,
                                              boolean fromUser) {
                    mEqualizer.setBandLevel(equalizerBandIndex,
                            (short) (progress + lowerEqualizerBandLevel));
                }

                public void onStartTrackingTouch(SeekBar seekBar) {
                    //not used
                }

                public void onStopTrackingTouch(SeekBar seekBar) {
                    //not used
                }
            });

//            add the lower and upper band level textviews and the seekBar to the row layout
            seekBarRowLayout.addView(lowerEqualizerBandLevelTextview);
            seekBarRowLayout.addView(seekBar);
            seekBarRowLayout.addView(upperEqualizerBandLevelTextview);

            mLinearLayout.addView(seekBarRowLayout);

            //        show the spinner
            equalizeSound();
        }
    }

    /*displays the audio waveform*/
    private void setupVisualizerFxAndUI() {

        mLinearLayout = (LinearLayout) findViewById(R.id.linearLayoutVisual);
        // Create a VisualizerView to display the audio waveform for the current settings
        mVisualizerView = new VisualizerView(this);
        mVisualizerView.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                (int) (VISUALIZER_HEIGHT_DIP * getResources().getDisplayMetrics().density)));
        mLinearLayout.addView(mVisualizerView);

        // Create the Visualizer object and attach it to our media player.
        mVisualizer = new Visualizer(track.getAudioSessionId());
        mVisualizer.setCaptureSize(Visualizer.getCaptureSizeRange()[1]);

        mVisualizer.setDataCaptureListener(new Visualizer.OnDataCaptureListener() {
            public void onWaveFormDataCapture(Visualizer visualizer, byte[] bytes,
                                              int samplingRate) {
                mVisualizerView.updateVisualizer(bytes);
            }

            public void onFftDataCapture(Visualizer visualizer, byte[] bytes, int samplingRate) {
            }
        }, Visualizer.getMaxCaptureRate() / 2, true, false);
    }

    @Override
    protected void onPause() {
        super.onPause();

        if (isFinishing() && track != null) {
            mVisualizer.release();
            mEqualizer.release();

        }
    }
    public void onRequestPermissionsResult (int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults.length> 0) {
                    boolean permissionToRecord = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    boolean permissionToStore = grantResults[1] ==  PackageManager.PERMISSION_GRANTED;
                    if (permissionToRecord && permissionToStore) {
                        Toast.makeText(getApplicationContext(), "Permission Granted", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(),"Permission Denied",Toast.LENGTH_LONG).show();
                    }
                }
                break;
        }
    }
    public boolean CheckPermissions() {
        int result = ContextCompat.checkSelfPermission(getApplicationContext(), WRITE_EXTERNAL_STORAGE);
        int result1 = ContextCompat.checkSelfPermission(getApplicationContext(), RECORD_AUDIO);
        return result == PackageManager.PERMISSION_GRANTED && result1 == PackageManager.PERMISSION_GRANTED;
    }
    private void RequestPermissions() {
        ActivityCompat.requestPermissions(MainEqualizer.this, new String[]{RECORD_AUDIO, WRITE_EXTERNAL_STORAGE}, 1);
    }
}




