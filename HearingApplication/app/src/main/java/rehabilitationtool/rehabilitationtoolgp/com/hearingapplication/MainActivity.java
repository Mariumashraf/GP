package rehabilitationtool.rehabilitationtoolgp.com.hearingapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView StartTest = (ImageView) findViewById(R.id.startTest);
        Button live = (Button) findViewById(R.id.live);

        StartTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this,StartTest.class);
                startActivity(intent1);

            }
        });

        live.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this,MainEqualizer.class);
                startActivity(intent1);

            }
        });
    }
}
