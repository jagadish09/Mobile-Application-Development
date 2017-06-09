package com.example.jagadish.myapp50;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.util.Log;

/**
 * Created by jagadish on 10/17/2016.
 */

public class CatDatabase {

    private CatHelper dbhelper;
    private SQLiteDatabase db;


    public CatDatabase(Context ctx) {
        dbhelper = new CatHelper(ctx);
    }

    //---opens the database---
    public void open() throws SQLException {


        db = dbhelper.getWritableDatabase();

        if (!db.isReadOnly()) {
            // Enable foreign key constraints
            db.execSQL("PRAGMA foreign_keys=ON;");
        }
        db.execSQL("PRAGMA foreign_keys=ON;");
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

    //insert function for database
    public long insertname1(String TableName, ContentValues values) {




        Long a= db.insert(TableName, null, values);

        //if insert is into Accounts, create a transaction table
        if(TableName=="Accounts" && a>0) {


            String KEY_ROWID = "_id";
            String KEY_CATNAME = "CatName";
            String KEY_NAME = "Name";
            String KEY_DATE = "Date";
            String KEY_TYPE = "CheckNum";
            String KEY_AMOUNT = "Amount";
            String KEY_CATEGORY = "Category";
            String TABLE_CAT = "Category";

            String TRANS_CREATE =
                    "CREATE TABLE " + values.getAsString("Name") + " (" +
                            KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                            KEY_DATE + " TEXT," +
                            KEY_TYPE + " TEXT," +
                            KEY_NAME + " TEXT," +
                            KEY_AMOUNT + " REAL," +
                            KEY_CATEGORY + " INTEGER REFERENCES " + TABLE_CAT + "(" + KEY_ROWID + ") NOT NULL ON CONFLICT FAIL,CHECK (length(" + KEY_CATEGORY + ") > 0));";
            db.execSQL(TRANS_CREATE);

        }

        return a;
    }

    //query function to retrieve a row or rows
    public Cursor cpQuery(String TableName, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        qb.setTables(TableName);
        //using the query builder to manage the actual query at this point.
        return qb.query(db, projection, selection, selectionArgs, null, null, sortOrder);
    }

    //updating a row or rows
    public int updaterow(String TableName, ContentValues values, String selection, String[] selectionArgs) {
        return db.update(TableName, values, selection, selectionArgs);
    }

    //daleting a row or rows
    public int cpDelete(String TableName, String selection, String[] selectionArgs,Uri uri1) {

        //if delete is for table Accounts then drop the associated transaction table
        if(TableName=="Accounts")
        {
            int idval;
            String selectiont;
            String[] selectionargst;
            Cursor tc;

            try
            {
                idval = Integer.parseInt(uri1.getLastPathSegment());
                selectiont = "_id = " + uri1.getLastPathSegment();
                tc = cpQuery("Accounts", new String[]{"Name"}, selectiont, null, null);
                Log.v("success","success");
            }catch (NumberFormatException e) {
                //selectionargst = selectionArgs;
                //selectiont = selection;
                Log.v(selection, selectionArgs[0]);

                tc = cpQuery("Accounts", new String[]{"Name"}, selection, selectionArgs, null);
            }

            if(tc.getCount()>0) {

                try {
                    idval = Integer.parseInt(uri1.getLastPathSegment());
                    selectiont = "_id = " + uri1.getLastPathSegment();
                    tc = cpQuery("Accounts", new String[]{"Name"}, selectiont, null, null);
                    tc.moveToFirst();
                    db.execSQL("DROP TABLE IF EXISTS " + tc.getString(0));
                    Log.v("success","success");
                    //selectionargst=selectionArgs;
                } catch (NumberFormatException e) {
                    //selectionargst = selectionArgs;
                    //selectiont = selection;
                    Log.v(selection, selectionArgs[0]);

                    tc = cpQuery("Accounts", new String[]{"Name"}, selection, selectionArgs, null);
                    tc.moveToFirst();
                    db.execSQL("DROP TABLE IF EXISTS " + tc.getString(0));
                }
            }

            //Cursor tc = cpQuery("Accounts", new String[] {"Name"}, selectiont, selectionargst, null);
            //tc.moveToFirst();
            //db.execSQL("DROP TABLE IF EXISTS " + tc.getString(0));

            //Log.v(TableName,selectionArgs[0]);
            return db.delete(TableName, selection, selectionArgs);
        }
        else {
            Log.v(TableName, selection);
            return db.delete(TableName, selection, selectionArgs);
        }
    }

    public void emptyName(String tabname) {
        db.delete(tabname, null, null);
    }


}
