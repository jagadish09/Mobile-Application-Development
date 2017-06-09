package com.example.jagadish.myapp50;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by jagadish on 10/19/2016.
 */

public class AcctDatabase {


    private AcctHelper dbhelper;
    private SQLiteDatabase db;
    Context ctx1;

    public AcctDatabase(Context ctx) {
        ctx1=ctx;
        dbhelper = new AcctHelper(ctx);
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

    public long insertname(String name)
    {
        ContentValues initialValues = new ContentValues();
        initialValues.put(AcctHelper.KEY_NAME, name);

        TransDatabase db1=new TransDatabase(ctx1);
        db1.create(name);

        return db.insert(AcctHelper.TABLE_NAME, null, initialValues);
    }
}
