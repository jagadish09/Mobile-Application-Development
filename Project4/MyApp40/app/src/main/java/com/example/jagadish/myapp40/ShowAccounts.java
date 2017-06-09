package com.example.jagadish.myapp40;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class ShowAccounts extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_accounts);

        ListView listview1 = (ListView) findViewById(R.id.listview1);
        Uri accts_uri = Uri.parse("content://edu.cs4730.prog4db/Accounts");
        Cursor acursor = getContentResolver().query(accts_uri, null, null, null, null);

        String[] from = new String[] {"Name"};
        int[]  to = new int[] {R.id.acctname1};

        //AcctsAdapter adapter=new AcctsAdapter(getApplicationContext(),R.layout.accts,acursor, from, to);
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(getApplicationContext(),R.layout.accts,acursor,from,to,0);
        listview1.setAdapter(adapter);
        listview1.setOnItemClickListener(itemlistener);

    }


    AdapterView.OnItemClickListener itemlistener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> arg0, View arg1,
                                int position, long id) {
            Log.v("clicked","clecked");

            String actname= ((TextView)arg1.findViewById(R.id.acctname1)).getText().toString();
            Log.v(actname,actname);
            Uri accts_uri = Uri.parse("content://edu.cs4730.prog4db/Accounts");
            String from ="Name=?";
            String[]  to = new String[] {actname};
            Cursor acursor = getContentResolver().query(accts_uri, null, from, to, null);
            acursor.moveToFirst();

            String cname=getIntent().getStringExtra("class");

            if(cname.equals("dis")) {
                Intent newintent = new Intent(ShowAccounts.this, DisTransactions.class);
                newintent.putExtra("acct", acursor.getString(0));
                startActivity(newintent);
            }

            else if(cname.equals("update")) {
                Intent newintent = new Intent(ShowAccounts.this, UpdateTrans.class);
                newintent.putExtra("acct", acursor.getString(0));
                startActivity(newintent);
            }

            else if(cname.equals("add"))
            {
                Intent newintent = new Intent(ShowAccounts.this, AddTrans.class);
                newintent.putExtra("acct", acursor.getString(0));
                Log.v("acctnumber",acursor.getString(0));
                startActivity(newintent);
            }

            else if(cname.equals("del"))
            {
                Intent newintent = new Intent(ShowAccounts.this, DelTrans.class);
                newintent.putExtra("acct", acursor.getString(0));
                Log.v("acctnumber",acursor.getString(0));
                startActivity(newintent);
            }
        }
        };
}
