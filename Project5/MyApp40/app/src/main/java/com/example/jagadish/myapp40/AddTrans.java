package com.example.jagadish.myapp40;

import android.app.Activity;
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

public class AddTrans extends Activity {
    Button b7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_trans);


        b7 = (Button) findViewById(R.id.button7);
        b7.setOnClickListener(b7listener);

    }

    View.OnClickListener b7listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if(v == b7)
            {

                String acctnum=getIntent().getStringExtra("acct");

                Uri trans_uri=Uri.parse("content://edu.cs4730.prog4db/Accounts/transactions/"+acctnum);



                Cursor mCursor = getContentResolver().query(trans_uri, null, null, null, null);

                String[] catcols1 = mCursor.getColumnNames();
                //mCursor.moveToFirst();
               /* Log.v(catcols1[0],mCursor.getString(0));
                Log.v(catcols1[1],mCursor.getString(1));
                Log.v(catcols1[2],mCursor.getString(2));
                Log.v(catcols1[3],mCursor.getString(3));
                Log.v(catcols1[4],mCursor.getString(4));
                Log.v(catcols1[5],mCursor.getString(5));
*/
                Log.v(catcols1[0],catcols1[0]);
                Log.v(catcols1[1],catcols1[1]);
                Log.v(catcols1[2],catcols1[2]);
                Log.v(catcols1[3],catcols1[3]);
                Log.v(catcols1[4],catcols1[4]);
                Log.v(catcols1[5],catcols1[5]);



                TextView date = (TextView)findViewById(R.id.Date);
                String date1=date.getText().toString();

                TextView type = (TextView)findViewById(R.id.Type);
                String type1=type.getText().toString();

                TextView name = (TextView)findViewById(R.id.Name);
                String name1=name.getText().toString();

                TextView amount = (TextView)findViewById(R.id.Amount);
                String amount1=amount.getText().toString();

                TextView category = (TextView)findViewById(R.id.Category);
                String category1=category.getText().toString();

                ContentValues vals = new ContentValues();
                vals.put("Date",date1);
                vals.put("CheckNum",type1);
                vals.put("Name",name1);
                vals.put("Amount",amount1);
                vals.put("Category",category1);
                Uri newuri;
                newuri=getContentResolver().insert(trans_uri,vals);

                if(newuri!=null)
                {
                    Context context = getApplicationContext();
                    CharSequence text = "Added Succesfully";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                    date.setText(null);
                    type.setText(null);
                    name.setText(null);
                    amount.setText(null);
                    category.setText(null);
                }

                else
                {
                    Context context = getApplicationContext();
                    CharSequence text = "Adding Failed";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                    date.setText(null);
                    type.setText(null);
                    name.setText(null);
                    amount.setText(null);
                    category.setText(null);
                }


            }

        }
    };
}
