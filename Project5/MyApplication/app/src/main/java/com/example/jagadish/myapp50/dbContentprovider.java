package com.example.jagadish.myapp50;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.jagadish.myapp50.CatDatabase;
import com.example.jagadish.myapp50.CatHelper;

import java.util.List;

/**
 * Created by jagadish on 10/20/2016.
 */

public class dbContentprovider extends ContentProvider{

    CatDatabase db;

    //provider name
    public static final String PROVIDER_NAME = "edu.cs4730.prog4db";


    private static final UriMatcher uriMatcher;

    //uri matcher id's
    private static final int cat = 1;
    private static final int cat_id = 2;
    private static final int acct = 3;
    private static final int acct_id = 4;
    private static final int trans = 5;
    private static final int trans_id = 6;

    //uri matcher
    static{
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(PROVIDER_NAME, "Category", cat);
        uriMatcher.addURI(PROVIDER_NAME, "Category/#", cat_id);
        uriMatcher.addURI(PROVIDER_NAME, "Accounts", acct);
        uriMatcher.addURI(PROVIDER_NAME, "Accounts/#", acct_id);
        uriMatcher.addURI(PROVIDER_NAME, "Accounts/transactions/#", trans);
        uriMatcher.addURI(PROVIDER_NAME, "Accounts/transactions/#/#", trans_id);
    }



    //on create open the database
    @Override
    public boolean onCreate() {
        Context ctx=getContext();
        db=new CatDatabase(ctx);
        db.open();
        return true;
    }


    //query function to retrieve a row or all the rows
    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {

        String tabname;
        String selectiont;
        Cursor tc;
        List<String> selectiontt;

        switch (uriMatcher.match(uri)) {
            case cat:
                tabname="Category";
                break;
            case cat_id:
                tabname="Category";
                if(selection==null || selection=="")
                    selection = "_id = " + uri.getLastPathSegment();
                else
                    selection = selection + "AND _id = " + uri.getLastPathSegment();
                break;


            case acct:
                tabname="Accounts";
                break;
            case acct_id:
                tabname="Accounts";
                if(selection==null || selection=="")
                    selection = "_id = " + uri.getLastPathSegment();
                else
                    selection = selection + "AND _id = " + uri.getLastPathSegment();
                break;


            case trans:
                //get tha table name for transactions from uri
                selectiont= "_id = " + uri.getLastPathSegment();
                tc = db.cpQuery("Accounts", new String[] {"Name"}, selectiont, null, null);
                tc.moveToFirst();
                tabname=tc.getString(0);
                Log.v("table name",tabname);
                break;
            case trans_id:
                //get tha table name for transactions from uri
                selectiontt= uri.getPathSegments();
                selectiont= "_id = " + selectiontt.get(0);
                tc = db.cpQuery("Accounts", new String[] {"Name"}, selectiont, null, null);
                tc.moveToFirst();
                tabname=tc.getString(0);

                if(selection==null || selection=="")
                    selection = "_id = " + uri.getLastPathSegment();
                else
                    selection = selection + "AND _id = " + uri.getLastPathSegment();
                break;

            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }

        Cursor c = db.cpQuery(tabname, projection, selection, selectionArgs, sortOrder);
        //this line is added for the loaders.  if we  changed the database, this allows a notification to be set.
        c.setNotificationUri(getContext().getContentResolver(), uri);
        return c;

    }

    //gettype function to retrieve type of the uri
    @Nullable
    @Override
    public String getType(Uri uri) {

        switch (uriMatcher.match(uri)) {
            case cat:
                return "vnd.android.cursor.dir/vnd.cs4730.Category";
            case cat_id:
                return "vnd.android.cursor.item/vnd.cs4730.Category";

            case acct:
                return "vnd.android.cursor.dir/vnd.cs4730.Accounts";
            case acct_id:
                return "vnd.android.cursor.item/vnd.cs4730.Accounts";


            case trans:
                return "vnd.android.cursor.dir/vnd.cs4730.transactions";
            case trans_id:
                return "vnd.android.cursor.item/vnd.cs4730.transactions";

            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }


        //return null;
    }

    //insert function to insert values into transactions or Accounts or Category tables
    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {

        Uri CONTENT_URI;
        String provider="content://"+ PROVIDER_NAME;

        //can't insert by id number
        if (uriMatcher.match(uri) == cat_id || uriMatcher.match(uri) == acct_id || uriMatcher.match(uri) == trans_id) {
            throw new IllegalArgumentException("Unknown URI " + uri);
        }


        String tabname;
        String selectiont;
        Cursor tc;
        List<String> selectiontt;

        switch (uriMatcher.match(uri)) {
            case cat:
                tabname="Category";
                CONTENT_URI=uri.parse(provider+"/Category");
                break;

            case acct:
                tabname="Accounts";
                CONTENT_URI=uri.parse(provider+"/Accounts");
                break;


            case trans:

                //get tha table name for transactions from uri
                selectiont= "_id = " + uri.getLastPathSegment();
                tc = db.cpQuery("Accounts", new String[] {"Name"}, selectiont, null, null);
                tc.moveToFirst();
                tabname=tc.getString(0);
                CONTENT_URI=uri.parse(provider+"/transactions/"+uri.getLastPathSegment());

                break;

            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }






        if (values == null) {   //basic error checking.  values is null, provider an empty one
            values = new ContentValues();  //or we could through an SQLExecption as well.
        }

        long rowid = db.insertname1(tabname, values);

        if (rowid > 0) {   //add the row id to the uri and return it to the user.
            Uri noteUri = ContentUris.withAppendedId(CONTENT_URI, rowid);
            //this line is added for the loaders.  We changed the database, so notify everyone.
            getContext().getContentResolver().notifyChange(noteUri, null);
            return noteUri;
        }


        throw new SQLException("Failed to insert row into " + uri);
    }

    //delete function to delete a row or all the rows
    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {

        String tabname;
        String selectiont;
        Cursor tc;
        List<String> selectiontt;

        switch (uriMatcher.match(uri)) {
            case cat:
                tabname="Category";
                break;
            case cat_id:
                tabname="Category";
                if(selection==null)
                    selection = "_id = " + uri.getLastPathSegment();
                else
                    selection = selection + "_id = " + uri.getLastPathSegment();
                break;


            case acct:
                tabname="Accounts";
                break;
            case acct_id:
                tabname="Accounts";
                if(selection==null || selection=="")
                    selection = "_id = " + uri.getLastPathSegment();
                else
                    selection = selection + "AND _id = " + uri.getLastPathSegment();
                break;


            case trans:
                //get tha table name for transactions from uri
                selectiont= "_id = " + uri.getLastPathSegment();
                tc = db.cpQuery("Accounts", new String[] {"Name"}, selectiont, null, null);
                tc.moveToFirst();
                tabname=tc.getString(0);

                break;
            case trans_id:
                //get tha table name for transactions from uri
                selectiontt= uri.getPathSegments();
                selectiont= "_id = " + selectiontt.get(0);
                tc = db.cpQuery("Accounts", new String[] {"Name"}, selectiont, null, null);
                tc.moveToFirst();
                tabname=tc.getString(0);

                if(selection==null || selection=="")
                    selection = "_id = " + uri.getLastPathSegment();
                else
                    selection = selection + "AND _id = " + uri.getLastPathSegment();
                break;

            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }

        int count = db.cpDelete(tabname, selection, selectionArgs,uri);
        getContext().getContentResolver().notifyChange(uri, null);
        return count;

    }

    //update function to update a row or some of the rows
    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {


        String tabname;
        String selectiont;
        Cursor tc;
        List<String> selectiontt;

        switch (uriMatcher.match(uri)) {
            case cat:
                tabname="Category";
                break;
            case cat_id:
                tabname="Category";
                if(selection==null)
                    selection = "_id = " + uri.getLastPathSegment();
                else
                    selection = selection + "_id = " + uri.getLastPathSegment();
                break;


            case acct:
                tabname="Accounts";
                throw new IllegalArgumentException("Accounts table cannot be updated" + uri);
                //break;
            case acct_id:
                tabname="Accounts";
                if(selection==null || selection=="")
                    selection = "_id = " + uri.getLastPathSegment();
                else
                    selection = selection + "AND _id = " + uri.getLastPathSegment();

                throw new IllegalArgumentException("Accounts table cannot be updated" + uri);

                //break;


            case trans:
                //get tha table name for transactions from uri
                selectiont= "_id = " + uri.getLastPathSegment();
                tc = db.cpQuery("Accounts", new String[] {"Name"}, selectiont, null, null);
                tc.moveToFirst();
                tabname=tc.getString(0);

                break;
            case trans_id:
                //get tha table name for transactions from uri
                selectiontt= uri.getPathSegments();
                selectiont= "_id = " + selectiontt.get(0);
                tc = db.cpQuery("Accounts", new String[] {"Name"}, selectiont, null, null);
                tc.moveToFirst();
                tabname=tc.getString(0);

                if(selection==null || selection=="")
                    selection = "_id = " + uri.getLastPathSegment();
                else
                    selection = selection + "AND _id = " + uri.getLastPathSegment();
                break;

            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }
        int count;
        count = db.updaterow(tabname, values, selection, selectionArgs);
        //this line is added for the loaders.  We changed the database, so notify everyone.
        getContext().getContentResolver().notifyChange(uri, null);
        return count;
    }
}
