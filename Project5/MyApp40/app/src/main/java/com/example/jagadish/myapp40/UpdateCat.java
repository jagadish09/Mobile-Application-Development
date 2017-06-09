package com.example.jagadish.myapp40;

import android.content.ContentValues;
import android.content.Context;
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

public class UpdateCat extends AppCompatActivity {
    Button b10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_cat);


        b10 = (Button) findViewById(R.id.button10);
        b10.setOnClickListener(b10listener);
    }

    View.OnClickListener b10listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Uri cat_uri=Uri.parse("content://edu.cs4730.prog4db/Category");


            TextView edittext8 = (TextView)findViewById(R.id.editText8);
            String cat=edittext8.getText().toString();


            TextView edittext16 = (TextView)findViewById(R.id.editText16);
            String id=edittext16.getText().toString();

            TextView edittext15 = (TextView)findViewById(R.id.editText15);
            String catname=edittext15.getText().toString();

            Log.v("catname",catname);

            if(cat.equals(""))
            {

                Context context = getApplicationContext();
                CharSequence text = "Enter the new Category to be set";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                edittext16.setText(null);
                edittext15.setText(null);

            }
            else
            {
                int rowsup;
                String[] cols={"CatName"};
                ContentValues cv=new ContentValues();
                cv.put("CatName",cat);

                ArrayList<String> colnames = new ArrayList<String>();
                ArrayList<String> colvals = new ArrayList<String>();

                if(!edittext16.getText().toString().equals(""))
                {
                    colnames.add("_id");
                    colvals.add(id);
                    Log.v("id123",Integer.toString(edittext16.getText().toString().length()));
                    Log.v("id123","1234");
                }

                if(!edittext15.getText().toString().equals(""))
                {
                    colnames.add("CatName");
                    colvals.add(catname);
                    Log.v("cat","cat");
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
                Log.v("catname",delq);
                rowsup = getContentResolver().update(cat_uri,cv,delq,colvals1);

                Context context = getApplicationContext();
                CharSequence text = Integer.toString(rowsup)+"updated";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                edittext8.setText(null);
                edittext16.setText(null);
                edittext15.setText(null);


            }

        }
    };

}
