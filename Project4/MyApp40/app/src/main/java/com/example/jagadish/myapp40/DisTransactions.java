package com.example.jagadish.myapp40;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class DisTransactions extends Activity {
    private ArrayList<HashMap<String, String>> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dis_transactions);

        String acctnum=getIntent().getStringExtra("acct");
        // Log.v("acctnum",acctnum);

        String URL = "content://edu.cs4730.prog4db/Accounts/transactions/"+acctnum;

        Uri trans_uri = Uri.parse(URL);
        Cursor mCursor = getContentResolver().query(trans_uri, null, null, null, null);

        if(mCursor.getCount()>0) {


            ListView listView = (ListView) findViewById(R.id.listview);


            String[] catcols1 = mCursor.getColumnNames();
            mCursor.moveToFirst();
            Log.v(catcols1[0], mCursor.getString(0));
            Log.v(catcols1[1], mCursor.getString(1));
            Log.v(catcols1[2], mCursor.getString(2));
            Log.v(catcols1[3], mCursor.getString(3));
            Log.v(catcols1[4], mCursor.getString(4));
            Log.v(catcols1[5], mCursor.getString(5));

            String[] from = new String[]{"_id", "Date", "CheckNum", "Name", "Amount", "Category"};
            int[] to = new int[]{R.id._id, R.id.Date, R.id.Type, R.id.Name, R.id.Amount, R.id.Category};

            //String[] from = new String[] {"CheckNum","Name","Amount","Category"};
            //int[]  to = new int[] {R.id.Type,R.id.Name,R.id.Amount,R.id.Category};

            ListViewAdapter adapter = new ListViewAdapter(getApplicationContext(), R.layout.column_row, mCursor, from, to);
            listView.setAdapter(adapter);
        }
        else
        {
            Context context = getApplicationContext();
            CharSequence text = "No Transactions to display";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }



    }
}