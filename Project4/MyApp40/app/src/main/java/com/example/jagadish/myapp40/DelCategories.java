package com.example.jagadish.myapp40;

import android.content.Context;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class DelCategories extends AppCompatActivity {
    Button b15;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_del_categories);

        b15 = (Button) findViewById(R.id.button15);
        b15.setOnClickListener(b15listener);
    }

    View.OnClickListener b15listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Uri cat_uri = Uri.parse("content://edu.cs4730.prog4db/Category");


            ArrayList<String> colnames = new ArrayList<String>();
            ArrayList<String> colvals = new ArrayList<String>();

            TextView _id = (TextView)findViewById(R.id.editText12);
            if(!_id.getText().toString().equals(""))
            {
                colvals.add(_id.getText().toString());
                colnames.add("_id");
            }

            TextView CatName = (TextView)findViewById(R.id.editText13);
            if(!CatName.getText().toString().equals(""))
            {
                colvals.add(CatName.getText().toString());
                colnames.add("CatName");
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

            int numdel= getContentResolver().delete(cat_uri,delq,colvals1);

            Context context = getApplicationContext();
            CharSequence text = Integer.toString(numdel)+" rows Deleted";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
            _id.setText(null);
            CatName.setText(null);


        }
    };
}
