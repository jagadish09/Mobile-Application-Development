package com.example.jagadish.myapp60;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity60 extends Activity {

    Button b,b2,b3,b4,b6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main60);
        //setContentView(new Drawing60(this));

        b = (Button) findViewById(R.id.button);
        b.setOnClickListener(blistener);

        b2 = (Button) findViewById(R.id.button2);
        b2.setOnClickListener(blistener);

     //   b3 = (Button) findViewById(R.id.button3);
      //  b3.setOnClickListener(blistener);


       // b4 = (Button) findViewById(R.id.button4);
       // b4.setOnClickListener(blistener);
    }

    View.OnClickListener blistener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v == b)
            {
                Intent intent = new Intent(MainActivity60.this, DrawActivity60.class);
                intent.putExtra("AI", 0);
                intent.putExtra("xo", "X");
                startActivity(intent);

            }
            else if (v == b2)
            {
                setContentView(R.layout.choosexo);
                b3 = (Button) findViewById(R.id.button3);
                b3.setOnClickListener(blistener);
                b4 = (Button) findViewById(R.id.button4);
                b4.setOnClickListener(blistener);
                b6 = (Button) findViewById(R.id.button6);
                b6.setOnClickListener(blistener);
            }

            else if (v == b3)
            {
                Intent intent = new Intent(MainActivity60.this, DrawActivity60.class);
                intent.putExtra("AI", 1);
                intent.putExtra("xo", "X");
                startActivity(intent);

            }

            else if (v == b4)
            {
                Intent intent = new Intent(MainActivity60.this, DrawActivity60.class);
                intent.putExtra("AI", 1);
                intent.putExtra("xo", "O");
                startActivity(intent);
            }

            else if (v == b6)
            {
                setContentView(R.layout.activity_main60);
                b = (Button) findViewById(R.id.button);
                b.setOnClickListener(blistener);

                b2 = (Button) findViewById(R.id.button2);
                b2.setOnClickListener(blistener);
            }

        }
    };

    /*
    @Override
    public void onBackPressed() {
        setContentView(R.layout.activity_main60);
        b = (Button) findViewById(R.id.button);
        b.setOnClickListener(blistener);

        b2 = (Button) findViewById(R.id.button2);
        b2.setOnClickListener(blistener);
    }
    */


}
