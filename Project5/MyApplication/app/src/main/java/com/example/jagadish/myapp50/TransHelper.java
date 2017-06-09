package com.example.jagadish.myapp50;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static com.example.jagadish.myapp50.CatHelper.KEY_NAME;

/**
 * Created by jagadish on 10/18/2016.
 */

public class TransHelper  extends SQLiteOpenHelper {

    private static final String TAG = "TransHelper";

    public static final String KEY_ROWID="_id";
    public static final String KEY_DATE="Date";
    public static final String KEY_TYPE="CheckNum";
    public static final String KEY_NAME="Name";
    public static final String KEY_AMOUNT="Amount";
    public static final String KEY_CATEGORY="Category";



    private static final String DATABASE_NAME = "Trans.db";
    public static String TABLE_NAME;
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_CREATE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    KEY_DATE + " TEXT," +
                    KEY_TYPE + " TEXT,"+
                    KEY_NAME + " TEXT,"+
                    KEY_AMOUNT+ " REAL,"+
                    KEY_CATEGORY+ " INTEGER";

    public TransHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //NOTE only called when the database is initial created!
        //db.execSQL(DATABASE_CREATE);
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
