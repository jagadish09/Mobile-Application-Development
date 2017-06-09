package com.example.jagadish.myapp60;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class DrawActivity60 extends Activity {
    //Drawing60 draw=new Drawing60(this);

    Drawing60 drawclass;

    boolean ai;
    String pl1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getIntent().getIntExtra("AI",0)==1)
        {
            ai=true;
            pl1=getIntent().getStringExtra("xo");
        }
        else
        {
            ai = false;
            pl1=getIntent().getStringExtra("xo");
        }

        Drawing60 draw=new Drawing60(this,ai,pl1);
        setContentView(draw);
    }

    @Override
    public void onBackPressed() {
        drawclass.count=0;
        drawclass.sizec=false;
        startActivity(new Intent(DrawActivity60.this,MainActivity60.class));
    }
}
