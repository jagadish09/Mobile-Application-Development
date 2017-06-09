package jagadish.myapp10;


import android.os.Bundle;
import android.app.Activity;
import android.text.Editable;
import android.util.Log;
import android.widget.*;


public class MyAct10 extends Activity implements TextNameFragment.OnClickListener{

        EditText tv10;
        String Tag=MyAct10.class.getSimpleName(); // getting the main activity class name
        @Override
        protected void onCreate(Bundle savedInstanceState)
        {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_my_act10); // calling main layout
            Log.v(Tag,"Main Activity created" );
        }
        public void onButtonClick(Editable pername)
        {
            Log.v(Tag,"In The interface implementation" );
            setContentView(R.layout.newact); // calling layout to display person name
            Log.v(Tag,"new Layout created" );
            tv10 = (EditText) findViewById(R.id.textView3);
            tv10.setText(pername); // updating the text field to person name
            Log.v(Tag,pername.toString() );
        }
    }

