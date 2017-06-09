
//Program#7 cosc 5730 by Jagadish Bapanapally

package com.example.jagadish.myapp70_1;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;


//Globals class to acces variables in asynctask and also activity
class Globals
{
    public static boolean con=false,comm=true;
    public static String action="",status="";
    public static PrintWriter out=null;
    public static BufferedReader in=null;

}

//Main Activity
public class MainActivity70 extends AppCompatActivity {
    //Arrow buttons and NOOP and SCAN
    Button b,b2,b3,b4,b5,b6,b7,b8,b9,b10;
    //View of rectangle to fire
    View v11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main70);

        Connection connect = new Connection();
        connect.execute();


        v11=findViewById(R.id.rect);
        v11.setOnTouchListener(blistener1);

        b = (Button) findViewById(R.id.button);
        b.setOnTouchListener(blistener1);

        b2 = (Button) findViewById(R.id.button2);
        b2.setOnTouchListener(blistener1);

        b3 = (Button) findViewById(R.id.button3);
        b3.setOnTouchListener(blistener1);

        b4 = (Button) findViewById(R.id.button4);
        b4.setOnTouchListener(blistener1);

        b5 = (Button) findViewById(R.id.button5);
        b5.setOnTouchListener(blistener1);

        b6 = (Button) findViewById(R.id.button6);
        b6.setOnTouchListener(blistener1);

        b7 = (Button) findViewById(R.id.button7);
        b7.setOnTouchListener(blistener1);

        b8 = (Button) findViewById(R.id.button8);
        b8.setOnTouchListener(blistener1);

        b9 = (Button) findViewById(R.id.button9);
        b9.setOnTouchListener(blistener1);

        b10 = (Button) findViewById(R.id.button10);
        b10.setOnTouchListener(blistener1);

    }


    //On touch listener for buttons and fire
    View.OnTouchListener blistener1=new View.OnTouchListener(){
        @Override
        public boolean onTouch(View v, MotionEvent event)
        {

            if(v==b)
            {
                if (Globals.con && !Globals.comm) {
                    Globals.action = "move -1 -1";
                    Globals.comm = true;
                }
            }

            if(v==b2)
            {
                if (Globals.con && !Globals.comm) {
                    Globals.action = "move 0 -1";
                    Globals.comm = true;
                }
            }

            if(v==b3)
            {
                if (Globals.con && !Globals.comm) {
                    Globals.action = "move 0 1";
                    Globals.comm = true;
                }
            }

            if(v==b4)
            {
                if (Globals.con && !Globals.comm) {
                    Globals.action = "move 1 0";
                    Globals.comm = true;
                }
            }

            if(v==b5)
            {
                if (Globals.con && !Globals.comm) {
                    Globals.action = "move -1 0";
                    Globals.comm = true;
                }
            }

            if(v==b6)
            {
                if (Globals.con && !Globals.comm) {
                    Globals.action = "move 1 -1";
                    Globals.comm = true;
                }
            }

            if(v==b7)
            {
                if (Globals.con && !Globals.comm) {
                    Globals.action = "move -1 1";
                    Globals.comm = true;
                }
            }

            if(v==b8)
            {
                if (Globals.con && !Globals.comm) {
                    Globals.action = "move 1 1";
                    Globals.comm = true;
                }
            }

            if(v==b9)
            {
                if (Globals.con && !Globals.comm) {
                    Globals.action = "noop";
                    Globals.comm = true;
                }
            }

            if(v==b10)
            {
                if (Globals.con && !Globals.comm) {
                    Globals.action = "scan";
                    Globals.comm = true;
                }
            }

            if(v==v11)
            {
                float hi=v11.getHeight();
                float wi=v11.getWidth();
                float cx=((float)wi/2);
                float cy=((float)hi/2);
                //calculate angle
                double theta = Math.atan2((cy-event.getY()), (event.getX()-cx));
                theta += Math.PI/2.0;
                double angle = Math.toDegrees(theta);
                if (angle < 0) {
                    angle += 360;
                }

                int ang=(int)angle;
                Globals.action = "fire "+Integer.toString(ang);

                Globals.comm = true;
            }

            return true;

        }
    };

}



//code for connecting and communicating with server
class Connection extends AsyncTask<String, Void, String> {


    protected String doInBackground(String[] params) {

        String hostname="10.121.193.32";
        //String hostname = "192.168.2.2";

        try {
            InetAddress serverAddr = InetAddress.getByName(hostname);
            Socket socket = new Socket(serverAddr, 3012);
            String message = "Hello from Client android emulator";
            try {

                Globals.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                Globals.status = Globals.in.readLine();
                Globals.out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
                Globals.out.println("Jag 0 0 0");
                Globals.status = Globals.in.readLine();
                Globals.status = Globals.in.readLine();
                Globals.con = true;
                Globals.status="";

                String[] statmsg=null;
                Globals.comm=false;
                boolean gamo=false;
                do
                {
                    if(Globals.comm)
                    {
                        String act=getAction();
                        Globals.comm=false;
                        Globals.out.println(act);


                        //receving msgs for scan
                        if(act.equals("scan"))
                        {
                            do
                            {
                                Globals.status = Globals.in.readLine();
                                statmsg=Globals.status.split(" +");
                                if(statmsg[1].equals("Dead") || statmsg[1].equals("GameOver"))
                                    gamo=true;
                            }while(!Globals.status.equals("scan done")  && !statmsg[1].equals("Dead") && !statmsg[1].equals("GameOver"));
                        }
                        //receving msgs for arrows and NOOP
                        else
                        {
                            do {
                                Globals.status = Globals.in.readLine();
                                statmsg=Globals.status.split(" +");
                                System.out.println(Globals.status);
                                if(statmsg[1].equals("Dead") || statmsg[1].equals("GameOver"))
                                    gamo=true;
                            }while(!statmsg[0].equals("Status") && !statmsg[1].equals("Dead") && !statmsg[1].equals("GameOver"));
                        }


                        //if the game is over break the loop

                        if(gamo) {
                            break;
                        }



                        //send noop if movecount or shootcount is less than 0 to make those variables 0
                        if(!act.equals("scan"))
                        {
                            if ((Integer.parseInt(statmsg[3]) < 0) || (Integer.parseInt(statmsg[4]) < 0)) {
                                do {
                                    Globals.out.println("noop");
                                    Globals.status = Globals.in.readLine();
                                    statmsg = Globals.status.split(" +");

                                }
                                while ((Integer.parseInt(statmsg[3]) < 0) || (Integer.parseInt(statmsg[4]) < 0));
                            }
                        }

                    }

                }while(1==1);


            }
            catch (Exception e) {
                System.out.println(e + "Connection");

            }
            finally{
                socket.close();
                Globals.in.close();
                Globals.out.close();
            }
        } catch (Exception e) {
            System.out.println(e + "unable to connect");
        }

        return "msg";

    }

    String getAction()
    {
        return Globals.action;
    }

    protected void onPostExecute(String msg) {
        // TODO: check this.exception
        // TODO: do something with the feed
    }
}
