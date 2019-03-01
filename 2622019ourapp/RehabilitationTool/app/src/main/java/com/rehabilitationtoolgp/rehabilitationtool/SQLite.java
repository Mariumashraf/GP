package com.rehabilitationtoolgp.rehabilitationtool;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.support.annotation.Nullable;
import android.util.Log;

public class SQLite extends SQLiteOpenHelper {

    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_RECORD = "record";
    private static final String KEY_IMG = "image";

    private static final String TABLE_CARDS= "GP";
    public SQLite( Context context,  String name,  SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_table = "create table " + TABLE_CARDS + "(" + KEY_ID + " integer primary key autoincrement,"
                + KEY_NAME + " varchar(255) DEFAULT'',"
                + KEY_RECORD + " blob ,"
                + KEY_IMG + " blob)";

        Log.d("create", create_table);
        db.execSQL(create_table);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String delete_query = "DROP table if exists " + TABLE_CARDS;
        db.execSQL(delete_query);

        onCreate(db);


    }


   /* public void QueryData(String sql){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sql);



    }*/
    //insert image to check the last check valve

    public void INSERT_GP(int id,String name, byte[] image, byte[] record){
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "INSERT INTO GP VALUES(null,?,?,?,?)";
        SQLiteStatement statement = db.compileStatement(sql);
        statement.clearBindings();
        statement.bindString(1, String.valueOf(id));

        statement.bindString(1,name);
        statement.bindBlob(2,image);
        statement.bindBlob(3,record);

        //execute the command INSERT
        statement.executeInsert();

    }
    //query has results
    public Cursor GetData(String sql){
        SQLiteDatabase db = getWritableDatabase();
        return db.rawQuery(sql,null);



    }
    public Card getCardById(int id) {

        Card card = null;

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_CARDS, new String[]{"id", "name", "record", "image"}, "id=?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor.moveToFirst()) {

            int id_contact = cursor.getInt(cursor.getColumnIndex(KEY_ID));
            String name = cursor.getString(cursor.getColumnIndex(KEY_NAME));
            int record= cursor.getInt(cursor.getColumnIndex(KEY_RECORD));
            byte[] image = cursor.getBlob(cursor.getColumnIndex(KEY_IMG));

            card = new Card(id, name,image);

        }

        return card;

    }


    public void updateCard(Card card) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, card.Name);
        values.put(KEY_IMG, card.Image);

        db.update(TABLE_CARDS, values, "id=?", new String[]{String.valueOf(card.id)});

    }


    public void deletContact(int id) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_CARDS, "id=?", new String[]{String.valueOf(id)});

    }

    /*public void deletContact(int id) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(GP, "id=?", new String[]{String.valueOf(id)});

    }*/

   /* public void deleteItem(String getID) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE from GP  WHERE billID= '" +getID+ "'");
    }*/
    /*public int deleteSelectedItem(String number){
        SQLiteDatabase db = this.getWritableDatabase();
        int result = db.delete(GP,"number = ?" , new String[] {number} );
        // Update your list here
        // Remove the deleted item from the list that you have passed to the adapter. Then call notifyDataSetChanged
        updateYourListCart();
        CardAdapter.notifyDataSetChanged();
    }*/
   /*public void deletContact(int id) {
       SQLiteDatabase db = this.getWritableDatabase();

       db.delete(GP, "id=?", new String[]{String.valueOf(id)});

   }*/
}
