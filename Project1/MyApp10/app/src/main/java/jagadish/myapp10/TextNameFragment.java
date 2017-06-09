package jagadish.myapp10;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class TextNameFragment extends android.app.Fragment {
    OnClickListener intmethod;
    String Tag1=TextNameFragment.class.getSimpleName(); // getting Frgament class name

    // interface implemented in main activity
    public interface OnClickListener
    {
        public void onButtonClick(Editable pername);
    }

    Button bt10;
    public TextNameFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        Log.v(Tag1,"In Create method in Fragment" );
        final View TenV= inflater.inflate(R.layout.fragment_text_name, container, false); // getting view from Frgament
        TenV.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // listener that checks if there is a click on the button
                Log.v(Tag1,"button is clicked" );
                EditText pername=(EditText) TenV.findViewById(R.id.textView); // getting the text name from the text field of the fragment
                Editable a =pername.getText();
                Log.v(Tag1,"calling interface method" );
                intmethod.onButtonClick(pername.getText()); // calling the interface method which is implemented in main activity
            }
        });
        return TenV;

    }
    @Override
    public void onAttach(Context context) { // Attaching the Main Activity to Fragment
    super.onAttach(context);
    intmethod  = (TextNameFragment.OnClickListener) getActivity();
    }

    @Override
    public void onDetach() // Mehod to detach the fragment from main activity
    {
        super.onDetach();
        intmethod = null;
    }
}
