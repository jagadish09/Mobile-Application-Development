package com.example.jagadish.myapp60;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//Activity to display if the game is draw or if anyone has won
public class Status extends Activity {
    Button b5;

    int ai;
    String pl1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameover);

        if(getIntent().getIntExtra("AI",0)==1)
        {
            ai=1;
            pl1=getIntent().getStringExtra("xo");
        }
        else
        {
            ai = 0;
            pl1=getIntent().getStringExtra("xo");
        }

        TextView txtView = (TextView) findViewById(R.id.textView2);
        txtView.setText(getIntent().getStringExtra("status"));

        b5 = (Button) findViewById(R.id.button5);
        b5.setOnClickListener(b5listener);
    }

    View.OnClickListener b5listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(Status.this, DrawActivity60.class);
            intent.putExtra("AI", ai);
            intent.putExtra("xo", pl1);
            startActivity(intent);
        }
    };

    public void onBackPressed() {

        startActivity(new Intent(Status.this,MainActivity60.class));
    }
}
