package com.team1.hackathon;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseACL;

/**
 * Created by songmho on 15. 8. 22.
 */
public class Moa_admin extends Application {
    String APPLICATION_ID="QhNYKsnuxfRGUBqPE3wc8rzawO7c7ZcooEYmOlul";
    String CLIENT_KEY="cZEeKJw9XfZBlfrsHnAUg2tT9IYTGCRGVUNfsT9U";

    @Override
    public void onCreate() {
        super.onCreate();


        //Parse.enableLocalDatastore(this);
        Parse.initialize(this, APPLICATION_ID, CLIENT_KEY);
        ParseACL defaultACL=new ParseACL();
        defaultACL.setPublicReadAccess(true);
        defaultACL.setPublicWriteAccess(true);
        ParseACL.setDefaultACL(defaultACL, true);
    }
}
