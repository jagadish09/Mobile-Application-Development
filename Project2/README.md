# Project # 2
Description:

This is a useful program for most people when they are at a restaurant and need to
figure some information quickly with the bill. 

Program will allow the following:
Enter the amount, percent of the tip to be left, whether they want a rounding method and split the check.

There are two rounding methods:
1. Round TOTAL bill to near dollar
2. Round the TIP to nearest dollar (then add to bill amount).

The user can select one of the two or no rounding. The default is no rounding.

Lastly, the split function:
The bill will be split equally among the party. When the bill is to be split, it shows extra information. It shows the tip and total bill, and it also shows the split per person, Rounding will have similar results, round per tip per each person or rounding the total bill per person. The default value for the split is 1.

Name:  Jagadish Bapanapally
Cosc 5730

Description:  (how to run the program, phone/emulator screen size, android version ie 7.0)
Run the app in android studio.
phone-nexus 5x
screensize-1080*1920;420dpi,
android version-6.0

in case there are no files uploaded- check the below link-
https://drive.google.com/file/d/0B-iR1-c9XsriWDBUMVNZR3VtTUk/view?usp=sharing

I have uploaded files to github.

Anything that doesn't work:



Grade
===
**Your grade:** 45/50

* All the calculations were good.
* The app crashes because it's missing a validation on the input
* The interface can be improved (though no points are discounted for this): after the first calculation, there is no way of going back to change the bill amount or tip percent. One needs to relaunch the app and input the vaues again.

##Program crash: missing validation -5

If I don't input anything in the numeric fields, the program crashes with this exception:

    Process: jagadish.myapp20, PID: 6078
    java.lang.NumberFormatException: Invalid float: ""
        at java.lang.StringToReal.invalidReal(StringToReal.java:63)
        at java.lang.StringToReal.parseFloat(StringToReal.java:308)
        at java.lang.Float.parseFloat(Float.java:306)
        at jagadish.myapp20.MainActivity20$2.onClick(MainActivity20.java:108)
        at android.view.View.performClick(View.java:5198)
        at android.view.View$PerformClick.run(View.java:21147)
        at android.os.Handler.handleCallback(Handler.java:739)
        at android.os.Handler.dispatchMessage(Handler.java:95)
        at android.os.Looper.loop(Looper.java:148)
        at android.app.ActivityThread.main(ActivityThread.java:5417)
        at java.lang.reflect.Method.invoke(Native Method)
        at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:726)
        at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:616)

##Recommendations:

There is no need of doing 4 castings in this line:

    totalbillnoro=(float)bill+((float)bill*(float)((float)ti/100));

You can check how implicit castings work in Java and you will see that this code is equivalent (also, no need of all those parentheses):

    totalbillnoro = bill + bill * (float)ti/100;

Furthermore, you can avoid castings altogether in that line by making your constant a float:

    totalbillnoro = bill + bill * ti / 100.0f;

This is the relevant page of the docs (lenghty but goody): https://docs.oracle.com/javase/specs/jls/se7/html/jls-5.html

##  Other recomendation:

This is solved with a casting, instead of creating an intermediary object and boxing/unboxing:

    totalbillro=new Integer(Math.round(totalbillnoro));

the fixed way is:

    totalbillro = (int) Math.round(totalbillnoro);
