package com.example.jagadish.myapp40;

import android.content.Context;
import android.content.Intent;
import android.icu.util.ULocale;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.net.Uri;
import android.content.ContentValues;
import android.content.CursorLoader;
import android.database.Cursor;
import android.widget.Toast;


public class MainActivity40 extends Activity {

    Button b,b2,b3,b4,b5,b6,b11,b12,b16,b18,b20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main40);

        b = (Button) findViewById(R.id.button);
        b.setOnClickListener(blistener);

        b2 = (Button) findViewById(R.id.button2);
        b2.setOnClickListener(blistener);


        b3 = (Button) findViewById(R.id.button3);
        b3.setOnClickListener(blistener);

        b4 = (Button) findViewById(R.id.button4);
        b4.setOnClickListener(blistener);

        b5 = (Button) findViewById(R.id.button5);
        b5.setOnClickListener(blistener);

        b6 = (Button) findViewById(R.id.button6);
        b6.setOnClickListener(blistener);

        b11 = (Button) findViewById(R.id.button11);
        b11.setOnClickListener(blistener);

        b12 = (Button) findViewById(R.id.button12);
        b12.setOnClickListener(blistener);

        b16 = (Button) findViewById(R.id.button16);
        b16.setOnClickListener(blistener);

        b18 = (Button) findViewById(R.id.button18);
        b18.setOnClickListener(blistener);

        b20 = (Button) findViewById(R.id.button20);
        b20.setOnClickListener(blistener);
    }

    View.OnClickListener blistener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if (v == b) {

                //startActivity(new Intent(MainActivity40.this,DisTransactions.class));


                Uri acct_uri = Uri.parse("content://edu.cs4730.prog4db/Accounts");

                Cursor acursor = getContentResolver().query(acct_uri, null, null, null, null);

                if(acursor.getCount()==0)
                {
                    Context context = getApplicationContext();
                    CharSequence text = "No Accounts setup. ADD ACCOUNT";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }

                else if(acursor.getCount()==1)
                {


                    Intent intent = new Intent(MainActivity40.this, DisTransactions.class);


                    if(acursor.moveToFirst()) {


                        Log.v(acursor.getString(0),acursor.getString(1));
                        intent.putExtra("acct", acursor.getString(0));
                        startActivity(intent);
                    }
                }
                else
                {
                    Intent intent = new Intent(MainActivity40.this, ShowAccounts.class);
                    intent.putExtra("class","dis");
                    startActivity(intent);
                }


            }


            else if(v == b2)
            {



                Uri acct_uri = Uri.parse("content://edu.cs4730.prog4db/Accounts");

                Cursor acursor = getContentResolver().query(acct_uri, null, null, null, null);

                if(acursor.getCount()==0)
                {
                    Context context = getApplicationContext();
                    CharSequence text = "No Accounts setup. ADD ACCOUNT";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }

                else if(acursor.getCount()==1)
                {
                    Intent intent = new Intent(MainActivity40.this, UpdateTrans.class);

                    if(acursor.moveToFirst()) {
                        Log.v(acursor.getString(0),acursor.getString(1));
                        intent.putExtra("acct", acursor.getString(0));
                        startActivity(intent);
                    }
                }
                else
                {
                    Intent intent = new Intent(MainActivity40.this, ShowAccounts.class);
                    intent.putExtra("class","update");
                    startActivity(intent);
                }


            }

            else if(v == b3)
            {
                //startActivity(new Intent(MainActivity40.this,AddTrans.class));


                Uri acct_uri = Uri.parse("content://edu.cs4730.prog4db/Accounts");

                Cursor acursor = getContentResolver().query(acct_uri, null, null, null, null);

                if(acursor.getCount()==0)
                {
                    Context context = getApplicationContext();
                    CharSequence text = "No Accounts setup. ADD ACCOUNT";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }

                else if(acursor.getCount()==1)
                {
                    Intent intent = new Intent(MainActivity40.this, AddTrans.class);

                    if(acursor.moveToFirst()) {


                        Log.v(acursor.getString(0),acursor.getString(1));
                        intent.putExtra("acct", acursor.getString(0));
                        startActivity(intent);
                    }
                }
                else
                {
                    Intent intent = new Intent(MainActivity40.this, ShowAccounts.class);
                    intent.putExtra("class","add");
                    startActivity(intent);
                }

            }

            else if(v == b4)
            {
               // startActivity(new Intent(MainActivity40.this,DelTrans.class));


                Uri acct_uri = Uri.parse("content://edu.cs4730.prog4db/Accounts");

                Cursor acursor = getContentResolver().query(acct_uri, null, null, null, null);

                if(acursor.getCount()==0)
                {
                    Context context = getApplicationContext();
                    CharSequence text = "No Accounts setup. ADD ACCOUNT";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }

                else if(acursor.getCount()==1)
                {
                    Intent intent = new Intent(MainActivity40.this, DelTrans.class);

                    if(acursor.moveToFirst()) {


                        Log.v(acursor.getString(0),acursor.getString(1));
                        intent.putExtra("acct", acursor.getString(0));
                        startActivity(intent);
                    }
                }
                else
                {
                    Intent intent = new Intent(MainActivity40.this, ShowAccounts.class);
                    intent.putExtra("class","del");
                    startActivity(intent);
                }

            }

            else if(v == b5)
            {
                startActivity(new Intent(MainActivity40.this,AddCategories.class));
            }

            else if(v == b6)
            {
                startActivity(new Intent(MainActivity40.this,UpdateCat.class));
            }

            else if(v == b11)
            {
                startActivity(new Intent(MainActivity40.this,AddAccts.class));
            }

            else if(v == b12)
            {
                startActivity(new Intent(MainActivity40.this,DelAccts.class));
            }

            else if(v == b16)
            {
                startActivity(new Intent(MainActivity40.this,DelCategories.class));
            }

            else if(v == b18)
            {
                Uri act_uri=Uri.parse("content://edu.cs4730.prog4db/Accounts");

                Cursor acursor = getContentResolver().query(act_uri, null, null, null, null);

                if(acursor.getCount()<=1)
                {
                    Context context = getApplicationContext();
                    CharSequence text = "Number of Accounts are less than or equal to one account. Add Accounts to move money to different Account";
                    int duration = Toast.LENGTH_LONG;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }
                else
                {
                    startActivity(new Intent(MainActivity40.this, MoveMoney.class));
                }
            }

            else if(v == b20)
            {
                Uri cat_uri = Uri.parse("content://edu.cs4730.prog4db/Category");

                Cursor ccursor = getContentResolver().query(cat_uri, null, null, null, null);

                if(ccursor.getCount()==0)
                {
                    Context context = getApplicationContext();
                    CharSequence text = "No Categories";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }

                else
                {
                    Intent intent = new Intent(MainActivity40.this, ShowCats.class);
                    intent.putExtra("class","cat");
                    startActivity(intent);
                }
            }

        }
    };

}
