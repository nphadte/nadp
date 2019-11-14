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

public class Notepad {

    private static final Logger logger = LoggerFactory.getLogger(Notepad.class);
    private static final String SAMPLE_NOTEPAD = "./notepad.txt";
    private Path filePath ;
    List<PostRequest> list = new ArrayList<PostRequest>();

    /*
     *  Singleton
     */
    public Notepad() {
        try{
            this.filePath = Paths.get(SAMPLE_NOTEPAD);
        } catch(Exception  e ){
            e.printStackTrace();
        }
    }

    private synchronized void writePost(int userId, String firstname, String lastname, String text_note) {
        // append the column to the file and also push to the Concurrent ArrayList

        try (BufferedWriter writer = Files.newBufferedWriter(filePath)) {
            //writer.write(userId + ":" + firstname + ":" + lastname +  ":" +  text_note);
            writer.append(userId + ":" + firstname + ":" + lastname +  ":" +  text_note + "\n");
        } catch (IOException ie) {
            ie.printStackTrace();
        }
        refreshList();
    }

    /*public static Path getFilePath() {
        return filePath;
    }*/

    public void  refreshList() {
        if ( Files.exists(filePath)){
            try(BufferedReader reader = Files.newBufferedReader(filePath, StandardCharsets.UTF_8)) {
                String  line = null ;
                //  repeat this till eof
                while ( (line = reader.readLine() ) != null) {
                    String[] tokens = line.split("|");
                    PostRequest pst = new PostRequest(LocalDateTime.now(), Integer.parseInt(tokens[0]), tokens[1], tokens[2], tokens[3]);
                    list.add(pst);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        this.list = list;
    }

    public void setList(List<PostRequest> list) {
        if ( Files.exists(filePath)){
            try(BufferedReader reader = Files.newBufferedReader(filePath, StandardCharsets.UTF_8)) {
                String  line = null ;
                //  repeat this till eof
                while ( (line = reader.readLine() ) != null) {
                    String[] tokens = line.split("|");
                    PostRequest pst = new PostRequest(LocalDateTime.now(), Integer.parseInt(tokens[0]), tokens[1], tokens[2], tokens[3]);
                    list.add(pst);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        this.list = list;
    }
}
