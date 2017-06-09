package com.example.jagadish.myapp40;

import android.app.Activity;
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

public class DelTrans extends Activity {
    Button b9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_del_trans);

        String acctnum=getIntent().getStringExtra("acct");

        Uri trans_uri=Uri.parse("content://edu.cs4730.prog4db/Accounts/transactions/"+acctnum);

        Cursor mCursor = getContentResolver().query(trans_uri, null, null, null, null);

        if(mCursor.getCount()==0)
        {
            Context context = getApplicationContext();
            CharSequence text = "This Account doesnt have any transactions to Delete. Add Transactions";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }
        else
        {
            b9 = (Button) findViewById(R.id.button9);
            b9.setOnClickListener(b9listener);
        }
    }

    View.OnClickListener b9listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            String acctnum=getIntent().getStringExtra("acct");

            Uri trans_uri=Uri.parse("content://edu.cs4730.prog4db/Accounts/transactions/"+acctnum);

            ArrayList<String> colnames = new ArrayList<String>();
            ArrayList<String> colvals = new ArrayList<String>();

            TextView _id = (TextView)findViewById(R.id.editText2);
            if(!_id.getText().toString().equals(""))
            {
                colvals.add(_id.getText().toString());
                colnames.add("_id");
            }

            TextView CheckNum = (TextView)findViewById(R.id.editText3);
            if(!CheckNum.getText().toString().equals(""))
            {
                colvals.add(CheckNum.getText().toString());
                colnames.add("CheckNum");
            }

            TextView Date = (TextView)findViewById(R.id.editText4);
            if(!Date.getText().toString().equals(""))
            {
                colvals.add(Date.getText().toString());
                colnames.add("Date");
            }

            TextView Name = (TextView)findViewById(R.id.editText5);
            if(!Name.getText().toString().equals(""))
            {
                colvals.add(Name.getText().toString());
                colnames.add("Name");
            }

            TextView Amount = (TextView)findViewById(R.id.editText6);
            if(!Amount.getText().toString().equals(""))
            {
                colvals.add(Amount.getText().toString());
                colnames.add("Amount");
            }

            TextView Category = (TextView)findViewById(R.id.editText7);
            if(!Category.getText().toString().equals(""))
            {
                colvals.add(Category.getText().toString());
                colnames.add("Category");
            }

            String[] colvals1=new String[colvals.size()];
            colvals1=colvals.toArray(colvals1);

            int count=0;
            String delq="";
            Log.v("cols size",Integer.toString(colnames.size()));
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


        int numdel= getContentResolver().delete(trans_uri,delq,colvals1);

            Log.v("del",Integer.toString(numdel));
                Context context = getApplicationContext();
                CharSequence text = Integer.toString(numdel)+" rows Deleted";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            _id.setText(null);
            CheckNum.setText(null);


        }
    };
}
