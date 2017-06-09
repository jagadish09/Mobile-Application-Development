package com.example.jagadish.myapp40;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
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

public class AddCategories extends Activity {
    Button b8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_categories);

        b8 = (Button) findViewById(R.id.button8);
        b8.setOnClickListener(b8listener);

    }

    View.OnClickListener b8listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if (v == b8) {

                String URL = "content://edu.cs4730.prog4db/Category";

                Uri cat_uri = Uri.parse(URL);
                //Cursor mCursor = getContentResolver().query(cat_uri, null, null, null, null);

                TextView edittext = (TextView)findViewById(R.id.editText);
                String edtext=edittext.getText().toString();

                ContentValues vals = new ContentValues();
                vals.put("CatName",edtext);
                Uri newuri;
                newuri=getContentResolver().insert(cat_uri,vals);

                if(newuri!=null)
                {
                    Context context = getApplicationContext();
                    CharSequence text = "Added Succesfully";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                    edittext.setText(null);
                }

                else
                {
                    Context context = getApplicationContext();
                    CharSequence text = "Adding Failed";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                    edittext.setText(null);
                }


            }
        }
    };


}
