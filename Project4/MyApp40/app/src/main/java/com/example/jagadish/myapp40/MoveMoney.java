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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class MoveMoney extends AppCompatActivity {
    Button b19;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_money);

        ArrayList<String> list = new ArrayList<String>();

        Uri act_uri=Uri.parse("content://edu.cs4730.prog4db/Accounts");

        Cursor acursor = getContentResolver().query(act_uri, null, null, null, null);

        while(acursor.moveToNext())
        {
            list.add(acursor.getString(1));
        }

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adp = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, list);
        adp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adp);

        Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<String> adp1 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, list);
        adp1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adp1);

        b19 = (Button) findViewById(R.id.button19);
        b19.setOnClickListener(b19listener);

    }

    View.OnClickListener b19listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            TextView type = (TextView)findViewById(R.id.editText17);
            String type1=type.getText().toString();
            TextView name = (TextView)findViewById(R.id.editText18);
            String name1=name.getText().toString();
            TextView amount = (TextView)findViewById(R.id.editText30);
            String amount2=amount.getText().toString();
            String amount1="-"+amount2;

            TextView category = (TextView)findViewById(R.id.editText31);
            String category1=category.getText().toString();

            Calendar c = Calendar.getInstance();
            System.out.println("Current time => " + c.getTime());

            SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
            String todate = df.format(c.getTime());

            if(type1.equals("") || name1.equals("") || amount1.equals("") || category1.equals(""))
            {
                Context context = getApplicationContext();
                CharSequence text = "Enter all the values";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            }

            else
            {
                Uri act_uri=Uri.parse("content://edu.cs4730.prog4db/Accounts");

                Spinner spinner1=(Spinner) findViewById(R.id.spinner);
                String fact = spinner1.getSelectedItem().toString();

                Spinner spinner2=(Spinner) findViewById(R.id.spinner2);
                String tact = spinner2.getSelectedItem().toString();
                Cursor acursor;

                acursor = getContentResolver().query(
                        act_uri,null,"Name=?",new String[]{fact},null);
                acursor.moveToFirst();

                String actd1=acursor.getString(0);
                Log.v("actd1",actd1);

                acursor = getContentResolver().query(
                        act_uri,null,"Name=?",new String[]{tact},null);
                acursor.moveToFirst();

                String actd2=acursor.getString(0);
                Log.v("actd2",actd2);

                ContentValues vals = new ContentValues();
                vals.put("Date",todate);
                vals.put("CheckNum",type1);
                vals.put("Name",name1);
                vals.put("Amount",amount1);
                vals.put("Category",category1);
                Uri trans_uri1=Uri.parse("content://edu.cs4730.prog4db/Accounts/transactions/"+actd1);
                Uri trans_uri2=Uri.parse("content://edu.cs4730.prog4db/Accounts/transactions/"+actd2);

                Uri newuri;

                newuri=getContentResolver().insert(trans_uri1,vals);

                vals.put("Date",todate);
                vals.put("CheckNum",type1);
                vals.put("Name",name1);
                vals.put("Amount",amount2);
                vals.put("Category",category1);
                newuri=getContentResolver().insert(trans_uri2,vals);

                Context context = getApplicationContext();
                CharSequence text = "Moved Succesfully";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                //date1.setText(null);
                type.setText(null);
                name.setText(null);
                amount.setText(null);
                category.setText(null);

            }

        }
    };
}
