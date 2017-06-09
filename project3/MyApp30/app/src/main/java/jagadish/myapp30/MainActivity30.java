package jagadish.myapp30;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity30 extends Activity {
    //TextView tv10;
    static double M;
    static double fnumber=0;
    static double snumber=0;
    static boolean point=false,nchanged=false,MSET=false;
    static boolean eqto = false;
    //static String lbutton;
    static String lop,lopn;
    Button b,b2,b3,b4,b5,b6,b7,b8,b9,b0,b11,b12,b13,b14,b15,b16,b17,b18,b19,b20,b21,b22;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main30);

        b=(Button)findViewById(R.id.button);
        b.setOnClickListener(blistener);

        b2=(Button)findViewById(R.id.button2);
        b2.setOnClickListener(blistener);

        b3=(Button)findViewById(R.id.button3);
        b3.setOnClickListener(blistener);

        b4=(Button)findViewById(R.id.button4);
        b4.setOnClickListener(blistener);

        b5=(Button)findViewById(R.id.button5);
        b5.setOnClickListener(blistener);

        b6=(Button)findViewById(R.id.button6);
        b6.setOnClickListener(blistener);

        b7=(Button)findViewById(R.id.button7);
        b7.setOnClickListener(blistener);

        b8=(Button)findViewById(R.id.button8);
        b8.setOnClickListener(blistener);

        b9=(Button)findViewById(R.id.button9);
        b9.setOnClickListener(blistener);

        b0=(Button)findViewById(R.id.button10);
        b0.setOnClickListener(blistener);

        b11=(Button)findViewById(R.id.button11);
        b11.setOnClickListener(blistener);

        b12=(Button)findViewById(R.id.button12);
        b12.setOnClickListener(blistener);

        b13=(Button)findViewById(R.id.button13);
        b13.setOnClickListener(blistener);

        b14=(Button)findViewById(R.id.button14);
        b14.setOnClickListener(blistener);

        b15=(Button)findViewById(R.id.button15);
        b15.setOnClickListener(blistener);

        b16=(Button)findViewById(R.id.button16);
        b16.setOnClickListener(blistener);

        b17=(Button)findViewById(R.id.button17);
        b17.setOnClickListener(blistener);

        b22=(Button)findViewById(R.id.button22);
        b22.setOnClickListener(blistener);


        b18=(Button)findViewById(R.id.button18);
        b18.setOnClickListener(blistener);

        b19=(Button)findViewById(R.id.button19);
        b19.setOnClickListener(blistener);

        b20=(Button)findViewById(R.id.button20);
        b20.setOnClickListener(blistener);

        b21=(Button)findViewById(R.id.button21);
        b21.setOnClickListener(blistener);




        //tv10 = (TextView) findViewById(R.id.editText2);
        //tv10.setText("000000");
    }


    View.OnClickListener blistener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(v == b)
            {
                if(eqto)
                {
                    TextView edittext=(TextView)findViewById(R.id.editText);
                    edittext.setText("0");
                    eqto = false;
                }

                TextView edittext2=(TextView)findViewById(R.id.editText2);
                String edtext2=edittext2.getText().toString();
              //  Log.v("string",edtext2);

                if(edtext2.equals("0"))
                {
                    edittext2.setText("1");
                    nchanged=true;
                }

                else if(edtext2.equals("-0"))
                {
                    edittext2.setText("-1");
                    nchanged=true;
                }

                else
                {
                        edittext2.setText(edtext2+"1");
                }
            }

            else if(v == b2)
            {
                if(eqto)
                {
                    TextView edittext=(TextView)findViewById(R.id.editText);
                    edittext.setText("0");
                    eqto = false;
                }

                TextView edittext2=(TextView)findViewById(R.id.editText2);
                String edtext2=edittext2.getText().toString();
               // Log.v("string",edtext2);
                if(edtext2.equals("0"))
                {
                    edittext2.setText("2");
                    nchanged=true;
                }

                else if(edtext2.equals("-0"))
                {
                    edittext2.setText("-2");
                    nchanged=true;
                }

                else
                {
                        edittext2.setText(edtext2+"2");

                }
            }

           else if(v == b3)
            {
                if(eqto)
                {
                    TextView edittext=(TextView)findViewById(R.id.editText);
                    edittext.setText("0");
                    eqto = false;
                }

                TextView edittext2=(TextView)findViewById(R.id.editText2);
                String edtext2=edittext2.getText().toString();
                //Log.v("string",edtext2);
                if(edtext2.equals("0"))
                {
                    edittext2.setText("3");
                    nchanged=true;
                }


                else if(edtext2.equals("-0"))
                {
                    edittext2.setText("-3");
                    nchanged=true;
                }

                else
                {
                        edittext2.setText(edtext2+"3");
                }
            }

            else if(v == b4)
            {

                if(eqto)
                {
                    TextView edittext=(TextView)findViewById(R.id.editText);
                    edittext.setText("0");
                    eqto = false;
                }

                TextView edittext2=(TextView)findViewById(R.id.editText2);
                String edtext2=edittext2.getText().toString();
               // Log.v("string",edtext2);
                if(edtext2.equals("0"))
                {
                    edittext2.setText("4");
                    nchanged=true;
                }

                else if(edtext2.equals("-0"))
                {
                    edittext2.setText("-4");
                    nchanged=true;
                }

                else
                {
                        edittext2.setText(edtext2+"4");
                }
            }

            else if(v == b5)
            {
                if(eqto)
                {
                    TextView edittext=(TextView)findViewById(R.id.editText);
                    edittext.setText("0");
                    eqto = false;
                }

                TextView edittext2=(TextView)findViewById(R.id.editText2);
                String edtext2=edittext2.getText().toString();
                //Log.v("string",edtext2);
                if(edtext2.equals("0"))
                {
                    edittext2.setText("5");
                    nchanged=true;
                }

                else if(edtext2.equals("-0"))
                {
                    edittext2.setText("-5");
                    nchanged=true;
                }

                else
                {
                        edittext2.setText(edtext2+"5");
                }
            }


            else if(v == b6)
            {

                if(eqto)
                {
                    TextView edittext=(TextView)findViewById(R.id.editText);
                    edittext.setText("0");
                    eqto = false;
                }

                TextView edittext2=(TextView)findViewById(R.id.editText2);
                String edtext2=edittext2.getText().toString();
                //Log.v("string",edtext2);
                if(edtext2.equals("0"))
                {
                    edittext2.setText("6");
                    nchanged=true;
                }

                else if(edtext2.equals("-0"))
                {
                    edittext2.setText("-6");
                    nchanged=true;
                }

                else
                {
                        edittext2.setText(edtext2+"6");
                }
            }

            else if(v == b7)
            {

                if(eqto)
                {
                    TextView edittext=(TextView)findViewById(R.id.editText);
                    edittext.setText("0");
                    eqto = false;
                }

                TextView edittext2=(TextView)findViewById(R.id.editText2);
                String edtext2=edittext2.getText().toString();
                //Log.v("string",edtext2);
                if(edtext2.equals("0"))
                {
                    edittext2.setText("7");
                    nchanged=true;
                }

                else if(edtext2.equals("-0"))
                {
                    edittext2.setText("-7");
                    nchanged=true;
                }

                else
                {
                        edittext2.setText(edtext2+"7");
                }
            }

            else if(v == b8)
            {

                if(eqto)
                {
                    TextView edittext=(TextView)findViewById(R.id.editText);
                    edittext.setText("0");
                    eqto = false;
                }

                TextView edittext2=(TextView)findViewById(R.id.editText2);
                String edtext2=edittext2.getText().toString();
                //Log.v("string",edtext2);
                if(edtext2.equals("0"))
                {
                    edittext2.setText("8");
                    nchanged=true;
                }

                else if(edtext2.equals("-0"))
                {
                    edittext2.setText("-8");
                    nchanged=true;
                }

                else
                {
                        edittext2.setText(edtext2+"8");
                }
            }


            else if(v == b9)
            {

                if(eqto)
                {
                    TextView edittext=(TextView)findViewById(R.id.editText);
                    edittext.setText("0");
                    eqto = false;
                }

                TextView edittext2=(TextView)findViewById(R.id.editText2);
                String edtext2=edittext2.getText().toString();
                //Log.v("string",edtext2);
                if(edtext2.equals("0"))
                {
                    edittext2.setText("9");
                    nchanged=true;
                }

                else if(edtext2.equals("-0"))
                {
                    edittext2.setText("-9");
                    nchanged=true;
                }

                else
                {
                        edittext2.setText(edtext2+"9");
                }
            }

            else if(v == b0)
            {

                if(eqto)
                {
                    TextView edittext=(TextView)findViewById(R.id.editText);
                    edittext.setText("0");
                    eqto = false;
                }

                TextView edittext2=(TextView)findViewById(R.id.editText2);
                String edtext2=edittext2.getText().toString();
                //Log.v("string",edtext2);
                if(edtext2.equals("0"))
                {
                    edittext2.setText("0");
                    nchanged=true;
                }

                else if(edtext2.equals("-0"))
                {
                    edittext2.setText("-0");
                    nchanged=true;
                }

                else
                {
                        edittext2.setText(edtext2+"0");
                }
            }

            else if(v==b13 || v==b14 || v==b15 || v== b16 || v==b22)
            {
                if(v == b13)
                {
                    lopn="+";
                }
                else if(v== b14)
                {
                    lopn="-";
                }
                else if(v == b15)
                {
                    lopn="*";
                }
                else if(v== b16)
                {
                    lopn="/";
                }
                else
                lopn="^";
                if(lop == null)
                {
                    lop=lopn;
                    TextView edittext=(TextView)findViewById(R.id.editText);
                    TextView edittext2=(TextView)findViewById(R.id.editText2);
                    if(edittext.getText().toString().equals("0"))
                    {
                        edittext.setText(edittext2.getText().toString());


                    }
                    else
                        eqto=false;
                    edittext2.setText("0");
                    point=false;
                    nchanged=false;
                }
                else
                {
                        if(nchanged)
                        {
                            TextView edittext=(TextView)findViewById(R.id.editText);
                            fnumber = Double.parseDouble(edittext.getText().toString());
                            TextView edittext2=(TextView)findViewById(R.id.editText2);
                            snumber = Double.parseDouble(edittext2.getText().toString());
                           if(lop.equals("+"))
                           {
                               fnumber=fnumber+snumber;
                               edittext.setText(Double.toString(fnumber));
                               edittext2.setText("0");
                               point=false;
                               nchanged=false;
                               lop=lopn;
                           }
                            else if(lop.equals("-"))
                            {
                                fnumber=fnumber-snumber;
                                edittext.setText(Double.toString(fnumber));
                                edittext2.setText("0");
                                point=false;
                                nchanged=false;
                                lop=lopn;
                            }

                           else if(lop.equals("*"))
                           {
                               fnumber=fnumber*snumber;
                               edittext.setText(Double.toString(fnumber));
                               edittext2.setText("0");
                               point=false;
                               nchanged=false;
                               lop=lopn;
                           }

                           else if(lop.equals("/"))
                           {
                               fnumber=fnumber/snumber;
                               edittext.setText(Double.toString(fnumber));
                               edittext2.setText("0");
                               point=false;
                               nchanged=false;
                               lop=lopn;
                           }

                           else if(lop.equals("^"))
                           {
                               fnumber=Math.pow(fnumber,snumber);
                               edittext.setText(Double.toString(fnumber));
                               edittext2.setText("0");
                               point=false;
                               nchanged=false;
                               lop=lopn;
                           }
                        }
                    else
                        {
                            lop=lopn;
                        }

                }
            }

            else if( v == b11)
            {
                TextView edittext2=(TextView)findViewById(R.id.editText2);
                String edtext2=edittext2.getText().toString();
                if(edtext2.charAt(0)=='-')
                {
                    StringBuilder sb = new StringBuilder(edtext2);
                    edtext2=sb.deleteCharAt(0).toString();
                    edittext2.setText(edtext2);
                }
                else
                {
                    StringBuilder sb = new StringBuilder(edtext2);
                    sb.insert(0,"-");
                    edittext2.setText(sb.toString());
                }
            }

            else if(v == b12)
            {

                if(eqto)
                {
                    TextView edittext=(TextView)findViewById(R.id.editText);
                    edittext.setText("0");
                    eqto = false;
                }

                if( !point )
                {
                    TextView edittext2=(TextView)findViewById(R.id.editText2);
                    String edtext2=edittext2.getText().toString();
                    edtext2=edtext2+".";
                    edittext2.setText(edtext2);
                    point=true;
                    nchanged=true;
                }
            }

            else if(v == b17)
            {
                eqto=true;
                if(nchanged)
                {
                    if (lop == null) {
                        TextView edittext2 = (TextView) findViewById(R.id.editText2);
                        String edtext2 = edittext2.getText().toString();
                        TextView edittext = (TextView) findViewById(R.id.editText);
                        edittext.setText(edtext2);
                        edittext2.setText("0");
                    }
                    else
                    {
                        TextView edittext = (TextView) findViewById(R.id.editText);
                        fnumber = Double.parseDouble(edittext.getText().toString());
                        Log.v("string",Double.toString(fnumber));
                        TextView edittext2 = (TextView) findViewById(R.id.editText2);
                        snumber = Double.parseDouble(edittext2.getText().toString());
                        Log.v("string",Double.toString(snumber));

                        if (lop.equals("+")) {
                            fnumber = fnumber + snumber;
                            edittext.setText(Double.toString(fnumber));
                            edittext2.setText("0");
                            point = false;
                            nchanged = false;
                            lop = null;
                            lopn = null;
                        } else if (lop.equals("-")) {
                            fnumber = fnumber - snumber;
                            edittext.setText(Double.toString(fnumber));
                            edittext2.setText("0");
                            point = false;
                            nchanged = false;
                            lop = null;
                            lopn = null;
                        } else if (lop.equals("*")) {
                            fnumber = fnumber * snumber;
                            Log.v("string",Double.toString(fnumber));
                            edittext.setText(Double.toString(fnumber));
                            edittext2.setText("0");
                            point = false;
                            nchanged = false;
                            lop = null;
                            lopn = null;
                        } else if (lop.equals("/")) {
                            fnumber = fnumber / snumber;
                            edittext.setText(Double.toString(fnumber));
                            edittext2.setText("0");
                            point = false;
                            nchanged = false;
                            lop = null;
                            lopn = null;
                        } else if (lop.equals("^")) {
                            fnumber = Math.pow(fnumber, snumber);
                            edittext.setText(Double.toString(fnumber));
                            edittext2.setText("0");
                            point = false;
                            nchanged = false;
                            lop = null;
                            lopn = null;
                        }
                    }
                }
                else
                {
                    if(lop!=null)
                    {
                        TextView edittext = (TextView) findViewById(R.id.editText);
                        fnumber = Double.parseDouble(edittext.getText().toString());
                        Log.v("string1",Double.toString(fnumber));
                        TextView edittext2 = (TextView) findViewById(R.id.editText2);
                        snumber = Double.parseDouble(edittext2.getText().toString());
                        Log.v("string1",Double.toString(snumber));
                        if (lop.equals("+")) {
                            fnumber = fnumber + snumber;
                            edittext.setText(Double.toString(fnumber));
                            edittext2.setText("0");
                            point = false;
                            nchanged = false;
                            lop = null;
                            lopn = null;
                        } else if (lop.equals("-")) {
                            fnumber = fnumber - snumber;
                            edittext.setText(Double.toString(fnumber));
                            edittext2.setText("0");
                            point = false;
                            nchanged = false;
                            lop = null;
                            lopn = null;
                        } else if (lop.equals("*")) {
                            fnumber = fnumber * snumber;
                            Log.v("string1",Double.toString(fnumber));
                            edittext.setText(Double.toString(fnumber));
                            edittext2.setText("0");
                            point = false;
                            nchanged = false;
                            lop = null;
                            lopn = null;
                        } else if (lop.equals("/")) {
                            fnumber = fnumber / snumber;
                            edittext.setText(Double.toString(fnumber));
                            edittext2.setText("0");
                            point = false;
                            nchanged = false;
                            lop = null;
                            lopn = null;
                        } else if (lop.equals("^")) {
                            fnumber = Math.pow(fnumber, snumber);
                            edittext.setText(Double.toString(fnumber));
                            edittext2.setText("0");
                            point = false;
                            nchanged = false;
                            lop = null;
                            lopn = null;
                        }

                    }
                }
            }

            else if(v == b18)
            {
                M=0;
                fnumber=0;
                snumber=0;
                point=false;
                nchanged=false;
                MSET=false;
                eqto = false;
                lop=null;
                lopn=null;

                TextView edittext = (TextView) findViewById(R.id.editText);
                edittext.setText("0");

                TextView edittext2 = (TextView) findViewById(R.id.editText2);
                edittext2.setText("0");

            }

            else if(v == b19)
            {

                //nchanged=false;

                TextView edittext2 = (TextView) findViewById(R.id.editText2);
                edittext2.setText("0");

            }

            else if(v == b21)
            {
                TextView edittext2 = (TextView) findViewById(R.id.editText2);
                M=Double.parseDouble(edittext2.getText().toString());
                MSET=true;
            }

            else if(v == b20)
            {
                if(MSET)
                {
                    TextView edittext2 = (TextView) findViewById(R.id.editText2);
                    edittext2.setText(Double.toString(M));
                    nchanged=true;
                }

                if(eqto)
                {
                    TextView edittext=(TextView)findViewById(R.id.editText);
                    edittext.setText("0");
                    eqto = false;
                }
            }
        }

    };

}
