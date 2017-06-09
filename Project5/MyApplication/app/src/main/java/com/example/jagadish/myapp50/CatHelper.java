package com.example.jagadish.myapp50;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by jagadish on 10/17/2016.
 */

public class CatHelper extends SQLiteOpenHelper {

    private static final String TAG = "CatHelper";
    private static final String DATABASE_NAME = "trans.db";

    //Column names
    public static final String KEY_ROWID="_id";
    public static final String KEY_CATNAME="CatName";
    public static final String KEY_NAME="Name";
    public static final String KEY_DATE="Date";
    public static final String KEY_TYPE="CheckNum";
    public static final String KEY_AMOUNT="Amount";
    public static final String KEY_CATEGORY="Category";

    //table names which will be created on create
    public static final String TABLE_CAT = "Category";
    public static String TABLE_TRANS="checking";
    public static final String TABLE_ACCT = "Accounts";
    private static final int DATABASE_VERSION = 1;

    //Creation string for Category Table
    private static final String CAT_CREATE =
            "CREATE TABLE " + TABLE_CAT + " (" +
                    KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    KEY_CATNAME + " TEXT NOT NULL ON CONFLICT FAIL,CHECK (length("+KEY_CATNAME+") > 0), UNIQUE("+KEY_CATNAME+") ON CONFLICT FAIL);";

    //Creation string for Acounts Table
    private static final String ACCT_CREATE =
            "CREATE TABLE " + TABLE_ACCT + " (" +
                    KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                    KEY_NAME + " TEXT NOT NULL ON CONFLICT FAIL,CHECK (length("+KEY_NAME+") > 0), UNIQUE("+KEY_NAME+") ON CONFLICT FAIL);";
    //creation string for checking table
    private static final String TRANS_CREATE =
            "CREATE TABLE " + TABLE_TRANS + " (" +
                    KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    KEY_DATE + " TEXT," +
                    KEY_TYPE + " TEXT,"+
                    KEY_NAME + " TEXT,"+
                    KEY_AMOUNT+ " REAL,"+
                    KEY_CATEGORY+ " INTEGER REFERENCES "+TABLE_CAT+"("+KEY_ROWID+") NOT NULL ON CONFLICT FAIL,CHECK (length("+KEY_CATEGORY+") > 0));";
                    //"FOREIGN KEY("+KEY_CATEGORY+") REFERENCES "+TABLE_CAT+"("+KEY_ROWID+"));";

    //inserting checking on create into Accounts table
    private static final String ACCT_INSERT =
            "INSERT INTO " + TABLE_ACCT + " (" + KEY_NAME+ ") VALUES ('checking')";


    public CatHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //NOTE only called when the database is initial created!

        if (!db.isReadOnly()) {
            // Enable foreign key constraints
            db.execSQL("PRAGMA foreign_keys=ON;");
        }

        db.execSQL("PRAGMA foreign_keys = ON;");
        db.execSQL(CAT_CREATE);
        db.execSQL(ACCT_CREATE);
        db.execSQL(ACCT_INSERT);
        db.execSQL("PRAGMA foreign_keys = ON;");
        db.execSQL(TRANS_CREATE);
        db.execSQL("PRAGMA foreign_keys = ON;");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Called when the database version changes, Remember the constant from above.
        Log.w(TAG, "Upgrading database from version " + oldVersion
                + " to "
                + newVersion + ", which will destroy all old data");
        //db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


}

