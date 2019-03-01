package com.rehabilitationtoolgp.rehabilitationtool;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.support.annotation.Nullable;

public class SQLite extends SQLiteOpenHelper {
    public SQLite( Context context,  String name,  SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public void QueryData(String sql){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sql);



    }
    //insert image to check the last check valve

    public void INSERT_GP(String name, byte[] image, byte[] record){
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "INSERT INTO GP VALUES(null,?,?,?)";
        SQLiteStatement statement = db.compileStatement(sql);
        statement.clearBindings();

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
