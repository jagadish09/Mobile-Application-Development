package com.example.jagadish.myapp60;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

/**
 * Created by jagadish on 10/31/2016.
 */

public class Drawing60 extends View {
    Context draw;
    static int count=0;
    float scw,sch;
    int posx,posy;
    final Rect rect = new Rect();
    static String rectvals[][]=new String[3][3];
    static boolean ai,pla1,pla2;
    static String pl1,pl2;
    int aix,aiy;
    MotionEvent ev = MotionEvent.obtain(1, 1, MotionEvent.ACTION_DOWN, -10, -10, 1);
    static boolean sizec=false;


    //Constructor to initialize all variables
    public Drawing60(Context context,boolean a,String b) {


        super(context);

        draw=context;
        ai=a;
        pl1=b;


        if(count==0) {
           // System.out.println("count="+count);
            if (ai)
            {

                if (pl1.equals("X"))
                {
                    pla1 = false;
                    pla2 = true;
                    pl2 = "O";
                }
                else
                {
                    pla1 = true;
                    pla2 = false;
                    pl2 = "X";
                }
            }
            else
            {
                pla1 = false;
                pla2 = true;
                pl2 = "O";
            }


            rectvals[0][0] = "";
            rectvals[0][1] = "";
            rectvals[0][2] = "";
            rectvals[1][0] = "";
            rectvals[1][1] = "";
            rectvals[1][2] = "";
            rectvals[2][0] = "";
            rectvals[2][1] = "";
            rectvals[2][2] = "";

        }

        setFocusable(true);
        setFocusableInTouchMode(true);

    }


    //setting width and height when orientation is changed
    @Override
    protected void onSizeChanged(int width, int height, int width1, int height1) {
        scw = width / 3f;
        sch = height / 3f;
        getRect(posx, posy, rect);
        super.onSizeChanged(width, height, width1, height1);
        count++;
        if(count>1)
        sizec=true;

    }


    //Drawing when size changed or ontouchevent
    protected void onDraw(Canvas canvas) {
        //System.out.println("cccccccccccccccccccccccccccccccccccccccccccccccccccccccc"+count);
        Log.v("height" + Integer.toString(getHeight()) + Float.toString(sch), "  width" + Integer.toString(getWidth()) + Float.toString(scw));

        float height1 = getHeight();
        float width1 = getWidth();


        Paint board = new Paint();
        board.setColor(getResources().getColor(R.color.color1));
        canvas.drawRect(0, 0, width1, height1, board);


        // Drawing the boxes

        Paint color2 = new Paint();
        color2.setStrokeWidth(8);
        color2.setColor(getResources().getColor(R.color.color2));

        Paint color3 = new Paint();
        color3.setColor(getResources().getColor(R.color.color3));

        for (int i = 0; i < 3; i++)
        {
            canvas.drawLine(0, i * sch + 1, width1, i * sch + 1,
                    color2);
            canvas.drawLine(i * scw + 1, 0, i * scw + 1, height1,
                    color2);
            canvas.drawLine(i * scw, 0, i * scw, height1, color3);
        }


        // Drawing the values for each box in tic-tac toe

        Paint setvals = new Paint(Paint.ANTI_ALIAS_FLAG);
        setvals.setColor(getResources().getColor(R.color.color4));
        setvals.setStyle(Paint.Style.FILL);
        setvals.setTextAlign(Paint.Align.CENTER);
        setvals.setTextSize(sch * 0.80f);
        setvals.setTextScaleX(scw / sch);
        Paint.FontMetrics pfm = setvals.getFontMetrics();
        float a = sch / 2 - (pfm.ascent + pfm.descent) / 2;
        float b = scw / 2;

        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                canvas.drawText(rectvals[i][j], i * scw + b, j * sch + a, setvals);
            }
        }


        if(!sizec)
        if (isGameOver()) {//checking if game is over
            count=0;
            sizec=false;
            if (ai) {
                if (pla1) {
                    //System.out.println("YOU WON!!");

                    Intent intent = new Intent(getContext(), Status.class);
                    intent.putExtra("status", "YOU WON!!");
                    if (ai)
                        intent.putExtra("AI", 1);
                    else
                        intent.putExtra("AI", 0);
                    intent.putExtra("xo", pl1);
                    draw.startActivity(intent);

                } else {
                    //System.out.println("YOU LOST");

                    Intent intent = new Intent(getContext(), Status.class);
                    intent.putExtra("status", "YOU LOST");
                    if (ai)
                        intent.putExtra("AI", 1);
                    else
                        intent.putExtra("AI", 0);
                    intent.putExtra("xo", pl1);
                    draw.startActivity(intent);
                }
            } else {
                if (pla1) {
                    //System.out.println("PlAYER 1 WON!!");
                    Intent intent = new Intent(getContext(), Status.class);
                    intent.putExtra("status", "PlAYER 1 WON!!");
                    if (ai)
                        intent.putExtra("AI", 1);
                    else
                        intent.putExtra("AI", 0);
                    intent.putExtra("xo", pl1);
                    draw.startActivity(intent);



                } else {
                    //System.out.println("PlAYER 2 WON!!");
                    Intent intent = new Intent(getContext(), Status.class);
                    intent.putExtra("status", "PlAYER 2 WON!!");
                    if (ai)
                        intent.putExtra("AI", 1);
                    else
                        intent.putExtra("AI", 0);
                    intent.putExtra("xo", pl1);
                    draw.startActivity(intent);
                }

            }
        } else {
            if (isBoardFilled()) {//checking if all boxes are filled
                count=0;
                sizec=false;
                //System.out.println("GAME IS DRAW");

                Intent intent = new Intent(getContext(), Status.class);
                intent.putExtra("status", "GAME IS DRAW!!");
                if (ai)
                    intent.putExtra("AI", 1);
                else
                    intent.putExtra("AI", 0);
                intent.putExtra("xo", pl1);
                draw.startActivity(intent);
            } else {
                if (ai) {

                    pla1 = !pla1;
                    pla2 = !pla2;

                    if (pla1) {
                        Context context = draw;
                        CharSequence text = "Player 1 play";
                        int duration = Toast.LENGTH_SHORT;

                        final Toast toast = Toast.makeText(context, text, duration);
                        toast.show();

                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                toast.cancel();
                            }
                        }, 150);



                        //System.out.println("Player 1 play");
                    } else {
                        getWinningMove();
                        //System.out.println(aix + "  " + aiy);
                        ev.setLocation(aix, aiy);
                        onTouchEvent(ev);

                    }


                }
                else {
                    pla1 = !pla1;
                    pla2 = !pla2;
                    if (pla1) {


                        Context context = draw;
                        CharSequence text = "Player 1 play";
                        int duration = Toast.LENGTH_SHORT;

                        final Toast toast = Toast.makeText(context, text, duration);
                        toast.show();

                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                toast.cancel();
                            }
                        }, 100);

                        //System.out.println("Player 1 play");
                    } else {

                        Context context = draw;
                        CharSequence text = "Player 2 play";
                        int duration = Toast.LENGTH_SHORT;

                        final Toast toast = Toast.makeText(context, text, duration);
                        toast.show();

                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                toast.cancel();
                            }
                        }, 100);

                        //System.out.println("Player 2 play");
                    }


                }
            }
        }

        sizec=false;


    }


    void getRect(int posx1, int posy1, Rect rect)
    {
        rect.set((int) (posx1 * scw), (int) (posy1 * sch),
                (int) (posx1 * scw + scw), (int) (posy1 * sch + sch));
    }

    //setting the rectangle
    void setrect(int x, int y)
    {
        invalidate(rect);

        posy = Math.min(Math.max(y, 0), 2);

        posx = Math.min(Math.max(x, 0), 2);

        getRect(posx, posy, rect);
        invalidate(rect);
    }

    //getting the poistion of the box when there is ontouch event
    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        if ( event.getAction() != MotionEvent.ACTION_DOWN)
            return super.onTouchEvent(event);
        if(!ai)
        setrect((int) (event.getX() / scw), (int) (event.getY() /sch));
        else
        {
            if(pla1)
            {
                setrect((int) (event.getX() / scw), (int) (event.getY() /sch));
            }
            else
            {
                setrect((int) (event.getX()), (int) (event.getY()));
            }

        }

        if(rectvals[posx][posy].equals(""))
        {
            if(pla1)
                rectvals[posx][posy] = pl1;
            else
                rectvals[posx][posy] = pl2;
        }
        return true;
    }


    //method to check if game is over
    boolean isGameOver()
    {

        String a;
        if(pla1)
        a=pl1;
        else
        a=pl2;


        //checking the column
        for(int i = 0; i < 3; i++){
            if(!rectvals[posx][i].equals(a))
                break;
            if(i == 2){
                return true;
            }
        }

        //checking the row
                for(int i = 0; i < 3; i++){
            if(!rectvals[i][posy].equals(a))
                break;
            if(i == 2){
                return true;
            }
        }

        //checking the diagonal
        if(posx == posy){
            for(int i = 0; i < 3; i++){
                if(!rectvals[i][i].equals(a))
                    break;
                if(i == 2){
                    return true;
                }
            }
        }

        //checking reverse diagonal
        if(posx + posy == 2){
            for(int i = 0;i<3;i++){
                if(!rectvals[i][2-i].equals(a))
                    break;
                if(i == 2){
                    return true;
                }
            }
        }


        return false;
    }

    //method to check if all boxes are filled
    boolean isBoardFilled()
    {
        boolean a=true;
        for(int i=0;i<3;i++) {
            if(!a)
                break;
            for (int j = 0; j < 3; j++) {
                if (rectvals[i][j].equals("")) {
                    a = false;
                    break;
                }
            }
        }
        return a;
    }




    boolean isGameOver1(String plval,int posx,int posy)
    {

        String a=plval;


        //checking the column
        for(int i = 0; i < 3; i++){
            if(!rectvals[posx][i].equals(a))
                break;
            if(i == 2){
                return true;
            }
        }

        //checking the row
        for(int i = 0; i < 3; i++){
            if(!rectvals[i][posy].equals(a))
                break;
            if(i == 2){
                return true;
            }
        }

        //checking the diagonal
        if(posx == posy){
            //we're on a diagonal
            for(int i = 0; i < 3; i++){
                if(!rectvals[i][i].equals(a))
                    break;
                if(i == 2){
                    return true;
                }
            }
        }

        //checking reverse diagonal
        if(posx + posy == 2){
            for(int i = 0;i<3;i++){
                if(!rectvals[i][2-i].equals(a))
                    break;
                if(i == 2){
                    return true;
                }
            }
        }


        return false;
    }



    //getting ai move
    void getWinningMove()
    {

        boolean w=false;
        //get winning move
        for(int i=0;i<3;i++)
        {
            for (int j = 0; j < 3; j++) {
                if (rectvals[i][j].equals("")) {
                    rectvals[i][j] = pl2;

                    w = isGameOver1(pl2,i,j);
                    rectvals[i][j] = "";
                    if (w) {
                        this.aix = i;
                        this.aiy = j;
                        return;
                    }
                }
            }
        }
        System.out.println("fail11111111111111111111111111111111111");

        //get blocking move
        for(int i=0;i<3;i++)
        {
            for (int j = 0; j < 3; j++) {
                if (rectvals[i][j].equals("")) {
                    rectvals[i][j] = pl1;
                    w = isGameOver1(pl1,i,j);
                    rectvals[i][j] = "";
                    if (w) {
                        this.aix = i;
                        this.aiy = j;
                        return;
                    }
                }
            }
        }
        System.out.println("fail222222222222222222222222222222222222222222");

        //get center move
        if (rectvals[1][1].equals(""))
        {
            this.aix = 1;
            this.aiy = 1;
            return;
        }

        System.out.println("fail33333333333333333333333333333333333333333");
        int found=0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(rectvals[i][j].equals(""))
                {
                    this.aix=i;
                    this.aiy=j;
                    found=1;
                    break;
                }
            }
            if(found==1)
                break;
        }

        System.out.println("fail44444444444444444444444444444444444");

    }

}

