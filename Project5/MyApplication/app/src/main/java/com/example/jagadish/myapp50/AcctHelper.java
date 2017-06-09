package com.example.jagadish.myapp50;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by jagadish on 10/18/2016.
 */

public class AcctHelper extends SQLiteOpenHelper {

    private static Context  instance;

    private static final String TAG = "AcctHelper";

    public static final String KEY_ROWID="_id";
    public static final String KEY_NAME="Name";


    private static final String DATABASE_NAME = "Acct.db";
    public static final String TABLE_NAME = "Accounts";
    private static final int DATABASE_VERSION = 1;


    private static final String DATABASE_CREATE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                    KEY_NAME + " TEXT UNIQUE";

    private static final String DATABASE_INSERT =
            "INSERT INTO " + TABLE_NAME + " (" + KEY_NAME+ ") VALUES ('checking')";


    public AcctHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
       instance=context;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //NOTE only called when the database is initial created!
        db.execSQL(DATABASE_CREATE);
        db.execSQL(DATABASE_INSERT);
        TransDatabase db1=new TransDatabase(instance);
        db1.create("checking");
        //insert a row checking in accounts
        //create a table checking
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Called when the database version changes, Remember the constant from above.
        Log.w(TAG, "Upgrading database from version " + oldVersion
                + " to "
                + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
