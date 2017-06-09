package com.example.jagadish.myapp50;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by jagadish on 10/19/2016.
 */

public class TransDatabase {

    private TransHelper dbhelper;
    private SQLiteDatabase db;


    public TransDatabase(Context ctx) {
        dbhelper = new TransHelper(ctx);
    }

    //---opens the database---
    public void open() throws SQLException {
        db = dbhelper.getWritableDatabase();
    }

    //returns true if db is open.  Helper method.
    public boolean isOpen() throws SQLException {
        return db.isOpen();
    }

    //---closes the database---
    public void close() {
        dbhelper.close();
        db.close();
    }

    public long insertname(String date,String type,String name,float amt,int cat)
    {
        ContentValues initialValues = new ContentValues();
        initialValues.put(TransHelper.KEY_DATE, name);
        initialValues.put(TransHelper.KEY_TYPE, name);
        initialValues.put(TransHelper.KEY_NAME, name);
        initialValues.put(TransHelper.KEY_AMOUNT, name);
        initialValues.put(TransHelper.KEY_CATEGORY, name);
        return db.insert("checking", null, initialValues);
    }

    public void create(String tabname)
    {

        String TABLE_NAME=tabname;


        String KEY_ROWID="_id";
        String KEY_DATE="Date";
        String KEY_TYPE="Type";
        String KEY_NAME="Name";
        String KEY_AMOUNT="Amount";
        String KEY_CATEGORY="Category";

        String DATABASE_CREATE =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        KEY_DATE + " TEXT," +
                        KEY_TYPE + " TEXT,"+
                        KEY_NAME + " TEXT,"+
                        KEY_AMOUNT+ " REAL,"+
                        KEY_CATEGORY+ " INTEGER";

        db.execSQL(DATABASE_CREATE);

    }

}
