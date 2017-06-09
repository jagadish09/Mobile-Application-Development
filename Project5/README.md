# Program # X
Name:  
Cosc 5730

Description:  (how to run the program, phone/emulator screen size, android version ie 7.0)

How to run:

install MyApplication which is program#5, Test it by istalling MyApp40.
Phone-Nexus 5x-1080*1920,420dpi, Android 7.0



* Query working: YES.
* Create working: YES
* Update working: YES.
* Delete working: YES.
* Cursor loaders: Working.


# Your grade:  47/50

# Problem 1 (affects update and delete):

You have this code which can cause an exception:

    selection = selection + "_id = " + uri.getLastPathSegment();

It should be:

    selection = selection + " AND _id = " + uri.getLastPathSegment();

The reason is that a selection clause like "AGE=19" will be translated into something like "AGE=19_id=34" instead of "AGE=19 AND _id=34"

I saw you had it right in the accounts and transactions, the problem is in categories.




# Minor problem: -3

* *Coding style (-0):* Classes should start with uppercase and be in CamelCase as per Java coding conventions. So "dbContentprovider" should be "DbContentProvider".
* *Coding correctness (-3):* This will not work always: `selection==""`. Compare Strings with equals unless you know you are referring to the same object (which you cannot guarantee in this case).

