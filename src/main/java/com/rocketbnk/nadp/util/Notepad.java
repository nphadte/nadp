package com.rocketbnk.nadp.util;

import com.rocketbnk.nadp.payload.Post;

import java.util.ArrayList;
import java.util.List;

public class Notepad {

    private static final String SAMPLE_NOTEPAD  = "./notepad.csv";

    List<Post> list = new ArrayList<Post>();
    /*
     *  Singleton
     */
    private Notepad() {

    }

    private synchronized  void writeNotepad( int userId, String firstname , String lastname, String text_note ){
        // append the column to the file and also push to the Concurrent ArrayList

    }

}
