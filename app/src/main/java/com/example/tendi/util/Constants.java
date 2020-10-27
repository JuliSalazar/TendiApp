package com.example.tendi.util;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Constants {
    public static String BASEURL = "https://tendidb-d6999.firebaseio.com/";
    public static FirebaseDatabase database;
    public static DatabaseReference refDB = database.getInstance().getReference();
}
