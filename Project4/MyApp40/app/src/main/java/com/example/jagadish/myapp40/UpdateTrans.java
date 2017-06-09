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

import java.util.ArrayList;

public class UpdateTrans extends AppCompatActivity {
    Button b17;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_trans);

        String acctnum=getIntent().getStringExtra("acct");

        Uri trans_uri=Uri.parse("content://edu.cs4730.prog4db/Accounts/transactions/"+acctnum);

        Cursor mCursor = getContentResolver().query(trans_uri, null, null, null, null);

        if(mCursor.getCount()==0)
        {
            Context context = getApplicationContext();
            CharSequence text = "This Account doesnt have any transactions to update. Add Transactions";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }
        else
        {

            b17 = (Button) findViewById(R.id.button17);
            b17.setOnClickListener(b17listener);
        }

    }

    View.OnClickListener b17listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            String acctnum=getIntent().getStringExtra("acct");

            Uri trans_uri=Uri.parse("content://edu.cs4730.prog4db/Accounts/transactions/"+acctnum);

            TextView edittext19 = (TextView)findViewById(R.id.editText19);
            String dates=edittext19.getText().toString();

            TextView edittext20 = (TextView)findViewById(R.id.editText20);
            String checknums=edittext20.getText().toString();

            TextView edittext21 = (TextView)findViewById(R.id.editText21);
            String names=edittext21.getText().toString();

            TextView edittext22 = (TextView)findViewById(R.id.editText22);
            String amounts=edittext22.getText().toString();

            TextView edittext23 = (TextView)findViewById(R.id.editText23);
            String cats=edittext23.getText().toString();

            TextView edittext24 = (TextView)findViewById(R.id.editText24);
            String idc=edittext24.getText().toString();

            TextView edittext25 = (TextView)findViewById(R.id.editText25);
            String datec=edittext25.getText().toString();

            TextView edittext26 = (TextView)findViewById(R.id.editText26);
            String checknumc=edittext26.getText().toString();

            TextView edittext27 = (TextView)findViewById(R.id.editText27);
            String namec=edittext27.getText().toString();

            TextView edittext28 = (TextView)findViewById(R.id.editText28);
            String amountc=edittext28.getText().toString();

            TextView edittext29 = (TextView)findViewById(R.id.editText29);
            String catc=edittext29.getText().toString();

            if(dates.equals("") && checknums.equals("") && names.equals("") && amounts.equals("") && cats.equals(""))
            {

                Context context = getApplicationContext();
                CharSequence text = "Enter value of the column to be updated";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                edittext24.setText(null);
                edittext25.setText(null);
                edittext26.setText(null);
                edittext27.setText(null);
                edittext28.setText(null);
                edittext29.setText(null);

            }
            else
            {
                int rowsup;

                ContentValues cv=new ContentValues();

                if(!dates.equals(""))
                {
                    cv.put("Date",dates);
                }

                if(!checknums.equals(""))
                {
                    cv.put("CheckNum",checknums);
                }

                if(!names.equals(""))
                {
                    cv.put("Name",names);
                }

                if(!amounts.equals(""))
                {
                    cv.put("Amount",amounts);
                }

                if(!cats.equals(""))
                {
                    cv.put("Category",cats);
                }


                ArrayList<String> colnames = new ArrayList<String>();
                ArrayList<String> colvals = new ArrayList<String>();

                if(!idc.equals(""))
                {
                    colnames.add("_id");
                    colvals.add(idc);
                }


                if(!datec.equals(""))
                {
                    colnames.add("Date");
                    colvals.add(datec);
                }


                if(!checknumc.equals(""))
                {
                    colnames.add("CheckNum");
                    colvals.add(checknumc);
                }


                if(!namec.equals(""))
                {
                    colnames.add("Name");
                    colvals.add(namec);
                }


                if(!amountc.equals(""))
                {
                    colnames.add("Amount");
                    colvals.add(amountc);
                }


                if(!catc.equals(""))
                {
                    colnames.add("Category");
                    colvals.add(catc);
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

                rowsup = getContentResolver().update(trans_uri,cv,delq,colvals1);

                Context context = getApplicationContext();
                CharSequence text = Integer.toString(rowsup)+"updated";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                edittext19.setText(null);
                edittext20.setText(null);
                edittext21.setText(null);
                edittext22.setText(null);
                edittext23.setText(null);
                edittext24.setText(null);
                edittext25.setText(null);
                edittext26.setText(null);
                edittext27.setText(null);
                edittext28.setText(null);
                edittext29.setText(null);

            }

        }
    };
}
