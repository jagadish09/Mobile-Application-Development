package com.example.jagadish.myapp40;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AddAccts extends AppCompatActivity {
    Button b13;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_accts);

        b13 = (Button) findViewById(R.id.button13);
        b13.setOnClickListener(b13listener);
    }

    View.OnClickListener b13listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String URL = "content://edu.cs4730.prog4db/Accounts";
            Uri acct_uri = Uri.parse(URL);

            TextView edittext9 = (TextView)findViewById(R.id.editText9);
            String acctname=edittext9.getText().toString();

            Cursor acursor = getContentResolver().query(acct_uri, null, null, null, null);
            Log.v("numacts",Integer.toString(acursor.getCount()));
            //acursor.moveToFirst();
            //Log.v(acursor.getString(0),acursor.getString(1));
           while(acursor.moveToNext())
            {
                Log.v(acursor.getString(0),acursor.getString(1));
            }


            if(acctname.equals(""))
            {
                Context context = getApplicationContext();
                CharSequence text = "Enter Account Name";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            }

            else
            {
                ContentValues acctval = new ContentValues();
                acctval.put("Name",acctname);
                Uri newuri;
                try {
                    newuri = getContentResolver().insert(acct_uri, acctval);

                    if (newuri != null) {
                        Context context = getApplicationContext();
                        CharSequence text = "Added Succesfully";
                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.show();
                        edittext9.setText(null);
                    } else {
                        Context context = getApplicationContext();
                        CharSequence text = "Adding Failed";
                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.show();
                        edittext9.setText(null);
                    }
                }catch(Exception e)
                {
                    Context context = getApplicationContext();
                    CharSequence text = "Adding Failed";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                    edittext9.setText(null);
                }
            }

        }
    };
}
