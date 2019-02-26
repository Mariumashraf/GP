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
}
