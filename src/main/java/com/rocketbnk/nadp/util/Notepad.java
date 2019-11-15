package com.rocketbnk.nadp.util;

import com.rocketbnk.nadp.controller.NotePadController;
import com.rocketbnk.nadp.payload.PostRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class NotePad {

    //private static Notepad single_instance = null;
    private  final static  String  SAMPLE_NOTEPAD = "notepad.txt";
    private  static Path   filePath ;

    //private Vector<PostRequest> Vec = new Vector<PostRequest>();
    private NotePad(){
    }

    public  synchronized static Path getFile() {
        if (filePath == null) {
            filePath  = Paths.get(SAMPLE_NOTEPAD);
        }
        return  filePath ;
    }
}
