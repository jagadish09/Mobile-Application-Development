package com.example.jagadish.myapp40;

import android.app.Activity;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

/**
 * Created by jagadish on 10/22/2016.
 */

public class ShowCats extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_accounts);

        ListView listview1 = (ListView) findViewById(R.id.listview1);
        Uri accts_uri = Uri.parse("content://edu.cs4730.prog4db/Category");
        Cursor acursor = getContentResolver().query(accts_uri, null, null, null, null);

        String[] from = new String[] {"_id","CatName"};
        int[]  to = new int[] {R.id.textView52,R.id.acctname1};

        //AcctsAdapter adapter=new AcctsAdapter(getApplicationContext(),R.layout.accts,acursor, from, to);
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(getApplicationContext(),R.layout.accts,acursor,from,to,0);
        listview1.setAdapter(adapter);
        //listview1.setOnItemClickListener(itemlistener);

    }
}
