package jagadish.myapp20;


import android.os.Bundle;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class MainActivity20 extends Activity {
    static int nums=1;
    static float bill;
    static int tippercent;
    static float totalbillnoro;
    static int totalbillro;
    static float totaltipnoro;
    static int totaltipro;
    static float billpernoro;
    static int billperro;
    static float totalbiltipro;
    static float billtiproper;
    //static float tippernoro;
    //static int tippernro;


    int rounding(float a)
    {

        return Math.round(a);
    }

    void calculate(float bil,int ti )
    {
        bill=bil;
        tippercent=ti;
        totalbillnoro=(float)bill+((float)bill*(float)((float)ti/100));
        totalbillro=new Integer(Math.round(totalbillnoro));
        totaltipnoro=(float)((float)bill*(float)((float)ti/(float)100));
        totaltipro=Math.round(totaltipnoro);
        totalbiltipro=(float)bill+(float)totaltipro;
    }

    void calculate1()
    {
        billpernoro=(float)((float)totalbillnoro/(float)nums);
        billperro=(int)Math.ceil(billpernoro);
        billtiproper=(float)totalbiltipro/(float)nums;
    }

    void splitfun()
    {
        Button b6=(Button)findViewById(R.id.button6);
        b6.setOnClickListener(b6listener);
        Button b7=(Button)findViewById(R.id.button7);
        b7.setOnClickListener(b7listener);
        Button b8=(Button)findViewById(R.id.button8);
        b8.setOnClickListener(b8listener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main20);
        Button b1=(Button)findViewById(R.id.button);
        b1.setOnClickListener(b1listener);
        Button b2=(Button)findViewById(R.id.button2);
        b2.setOnClickListener(b2listener);


    }

    View.OnClickListener b1listener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            EditText tv10 = (EditText)findViewById(R.id.editText);
            EditText tv20 = (EditText)findViewById(R.id.editText2);
            //String tv10s=tv10.toString();
            //String tv20s=tv20.toString();
            calculate(Float.parseFloat(tv10.getText().toString()),Integer.parseInt(tv20.getText().toString()));
           // tv20.setText(Long.toString(rounding(Float.parseFloat(tv20s))));
            //tv20.(Float.parseFloat(tv20s));
           // tv20.setText("hi");
           setContentView(R.layout.numsplits);
            splitfun();
           //Button b6=(Button)findViewById(R.id.button6);
           //b6.setOnClickListener(b6listener);
        }

    };


    View.OnClickListener b2listener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {


            EditText tv10 = (EditText)findViewById(R.id.editText);
            EditText tv20 = (EditText)findViewById(R.id.editText2);
            //String tv10s=tv10.toString();
            //String tv20s=tv20.toString();
            calculate(Float.parseFloat(tv10.getText().toString()),Integer.parseInt(tv20.getText().toString()));

            setContentView(R.layout.numsplits);
            EditText tv70 = (EditText)findViewById(R.id.editText7);
           tv70.setText("1");



            splitfun();
        }
    };


    View.OnClickListener b6listener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            EditText tv70 = (EditText)findViewById(R.id.editText7);
            nums=Integer.parseInt(tv70.getText().toString());
            //Log.v("nums",Integer.toString(nums));
            calculate1();
            setContentView(R.layout.totalbilltip);
            TextView edittext8=(TextView)findViewById(R.id.editText8);
            edittext8.setText(Integer.toString(billperro));
            TextView edittext10=(TextView)findViewById(R.id.editText10);
            edittext10.setText(Float.toString(totaltipnoro));
            TextView edittext4=(TextView)findViewById(R.id.editText4);
            edittext4.setText(Integer.toString(totalbillro));

        }
    };


    View.OnClickListener b7listener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            EditText tv70 = (EditText)findViewById(R.id.editText7);
            nums=Integer.parseInt(tv70.getText().toString());
            calculate1();
            setContentView(R.layout.totalbilltip);
            TextView edittext8=(TextView)findViewById(R.id.editText8);
            edittext8.setText(Float.toString(billtiproper));
            TextView edittext10=(TextView)findViewById(R.id.editText10);
            edittext10.setText(Integer.toString(totaltipro));
            TextView edittext4=(TextView)findViewById(R.id.editText4);
            edittext4.setText(Float.toString(totalbiltipro));
        }
    };


    View.OnClickListener b8listener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            EditText tv70 = (EditText)findViewById(R.id.editText7);
            nums=Integer.parseInt(tv70.getText().toString());
            calculate1();
            setContentView(R.layout.totalbilltip);
            TextView edittext8=(TextView)findViewById(R.id.editText8);
            edittext8.setText(Float.toString(billpernoro));
            TextView edittext10=(TextView)findViewById(R.id.editText10);
            edittext10.setText(Float.toString(totaltipnoro));
            TextView edittext4=(TextView)findViewById(R.id.editText4);
            edittext4.setText(Float.toString(totalbillnoro));
        }
    };
    /*View.OnClickListener b6listener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            setContentView(R.layout.totalbilltip);
            //Button b6=(Button)findViewById(R.id.button6);
           // b4.setOnClickListener(b4listener);
        }

    };

*/
}
