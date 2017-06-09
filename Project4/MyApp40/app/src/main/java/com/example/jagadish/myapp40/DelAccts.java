package com.example.jagadish.myapp40;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class DelAccts extends AppCompatActivity {
    Button b14;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_del_accts);

        b14 = (Button) findViewById(R.id.button14);
        b14.setOnClickListener(b14listener);
    }

    View.OnClickListener b14listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Uri acct_uri = Uri.parse("content://edu.cs4730.prog4db/Accounts");

            ArrayList<String> colnames = new ArrayList<String>();
            ArrayList<String> colvals = new ArrayList<String>();

            TextView _id = (TextView)findViewById(R.id.editText10);
            if(!_id.getText().toString().equals(""))
            {
                colvals.add(_id.getText().toString());
                colnames.add("_id");
            }

            TextView Name = (TextView)findViewById(R.id.editText11);
            if(!Name.getText().toString().equals(""))
            {
                colvals.add(Name.getText().toString());
                colnames.add("Name");
            }

            String[] colvals1=new String[colvals.size()];
            colvals1=colvals.toArray(colvals1);

            int count=0;
            String delq="";

            for(int i=0;i<colnames.size();i++)
            {

                if(count>0)
                {
                    delq=delq+" AND " + colnames.get(i)+"=?";
                    count+=1;
                }
                else
                {
                    delq = colnames.get(i) + "=?";
                    count+=1;
                }
            }
            Cursor actcursor=getContentResolver().query(acct_uri,null,delq,colvals1,null);
            if(actcursor.getCount()==0)
            {

                Context context = getApplicationContext();
                CharSequence text = "Doesnt match any rows. Enter right information";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                _id.setText(null);
                Name.setText(null);
            }
            else
            {
                actcursor.moveToFirst();
                acct_uri=Uri.parse("content://edu.cs4730.prog4db/Accounts/"+actcursor.getString(0));
                int numdel = getContentResolver().delete(acct_uri, null, null);

                Context context = getApplicationContext();
                CharSequence text = Integer.toString(numdel) + " rows Deleted";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                _id.setText(null);
                Name.setText(null);
            }
        }
    };
}
