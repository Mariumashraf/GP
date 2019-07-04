package com.rehabilitationtoolgp.rehabilitationtool;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.support.annotation.Nullable;
import android.util.Log;

import com.rehabilitationtoolgp.rehabilitationtool.Card;

import java.util.ArrayList;

public class SQLite extends SQLiteOpenHelper {
    private static final String DB_NAME = "myphone_db";
    private static final int DB_VESION = 2;

    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_IMG = "image";
    private static final String KEY_RECORD = "record";


    private static final String TABLE_CONTACT = "contacts";
    public SQLite(  Context context) {
        super(context, DB_NAME, null, DB_VESION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String create_table = "create table " + TABLE_CONTACT + "(" + KEY_ID + " integer primary key autoincrement,"
                + KEY_NAME + " varchar(255) DEFAULT'',"
                + KEY_IMG + " blob ,"
                + KEY_RECORD +" blob)";

        Log.d("create", create_table);
        db.execSQL(create_table);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String delete_query = "DROP table if exists " + TABLE_CONTACT;
        db.execSQL(delete_query);

        onCreate(db);

    }
    public ArrayList<Card> getAllContacts() {
        ArrayList<Card> contacts = new ArrayList<>();

        String select_query = "select * from " + TABLE_CONTACT;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(select_query, null);

        if (cursor.moveToFirst()) {

            do {

                int id = cursor.getInt(cursor.getColumnIndex(KEY_ID));
                String name = cursor.getString(cursor.getColumnIndex(KEY_NAME));
                byte[] image = cursor.getBlob(cursor.getColumnIndex(KEY_IMG));

                Card contact = new Card(id, name,image);

                contacts.add(contact);

            } while (cursor.moveToNext());

        }

        return contacts;
    }

    public ArrayList<byte[]>getaudio(){
        ArrayList<byte[]> audios = new ArrayList<>();
        String select_query = "select * from " + TABLE_CONTACT;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(select_query, null);
        if (cursor.moveToFirst()) {

            do {


                byte[] record = cursor.getBlob(cursor.getColumnIndex(KEY_RECORD));


                audios.add(record);

            } while (cursor.moveToNext());

        }

        return audios;


    }


    // الطريقه الثانية لجلب المعلومات لقاعده البيانات
    public Card getContactById2(int id) {

        Card contact = null;

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_CONTACT, new String[]{"id", "name", "image"}, "id=?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor.moveToFirst()) {

            int id_contact = cursor.getInt(cursor.getColumnIndex(KEY_ID));
            String name = cursor.getString(cursor.getColumnIndex(KEY_NAME));
            byte[] image = cursor.getBlob(cursor.getColumnIndex(KEY_IMG));

            contact = new Card(id, name, image);

        }

        return contact;

    }
    public void updateContact(Card contact) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, contact.Name);
        values.put(KEY_IMG, contact.Image);
       // values.put(KEY_RECORD,record);


        db.update(TABLE_CONTACT, values, "id=?", new String[]{String.valueOf(contact.Id)});

    }
    public void deletContact(int id) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_CONTACT, "id=?", new String[]{String.valueOf(id)});

    }


    /*public void QueryData(String sql){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sql);



    }*/
    //insert image to check the last check valve

   /* public void INSERT_GHICHU(String name, byte[] image, byte[] record){
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "INSERT INTO GhiChu VALUES(null,?,?,?)";
        SQLiteStatement statement = db.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1,name);
        statement.bindBlob(2,image);
        statement.bindBlob(3,record);

        //execute the command INSERT
        statement.executeInsert();

    }*/

    public void addContact(Card card, byte[]record) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, card.Name);
        values.put(KEY_IMG, card.Image);
        values.put(KEY_RECORD,record);

        db.insert(TABLE_CONTACT, null, values);

    }
    //query has results

}
