package com.rocketbnk.nadp.service;

import com.rocketbnk.nadp.payload.PostRequest;

import com.rocketbnk.nadp.util.NotePad;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Vector;

@Service
public class NotePadService {

    Path filePath = NotePad.getFile();

    public synchronized Boolean  writePost(int userId, String firstname, String lastname, String text_note) {
        // append the column to the file and also push to the Concurrent ArrayList

        try (BufferedWriter writer = Files.newBufferedWriter(filePath)) {
            writer.append(LocalDateTime.now() + "|" + userId + "|" + firstname + "|" + lastname +  "|" +  text_note + "\n");
            refreshList();
            return  true;
        } catch (IOException ie) {
            ie.printStackTrace();
            return false;
        }
    }


    public Vector  refreshList() {
        Vector vec = new Vector<PostRequest>();
        if ( Files.exists(filePath)){
            try(BufferedReader reader = Files.newBufferedReader(filePath, StandardCharsets.UTF_8)) {
                String  line = null ;
                //  repeat this till eof
                while ( (line = reader.readLine() ) != null) {
                    String[] tokens = line.split("|");
                    PostRequest pst = new PostRequest(LocalDateTime.now(), Integer.parseInt(tokens[0]), tokens[1], tokens[2], tokens[3]);
                    vec.add(pst);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return vec;
    }

    public Vector  initializeList() {
        Vector vec = new Vector<PostRequest>();
        if ( Files.exists(filePath)){
            try(BufferedReader reader = Files.newBufferedReader(filePath, StandardCharsets.UTF_8)) {
                String  line = null ;
                //  repeat this till eof
                while ( (line = reader.readLine() ) != null) {
                    String[] tokens = line.split("|");
                    PostRequest pst = new PostRequest(LocalDateTime.now(), Integer.parseInt(tokens[0]), tokens[1], tokens[2], tokens[3]);
                    vec.add(pst);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return vec;
    }

    public Vector<PostRequest> findPostsByUser(String username){
        Vector vec = new Vector<PostRequest>();
        if ( Files.exists(filePath)){
            try(BufferedReader reader = Files.newBufferedReader(filePath, StandardCharsets.UTF_8)) {
                String  line = null ;
                //  repeat this till eof
                while ( (line = reader.readLine() ) != null) {
                    String[] tokens = line.split("|");
                    if ( username.equals(tokens[0])){
                        PostRequest pst = new PostRequest(LocalDateTime.now(), Integer.parseInt(tokens[0]), tokens[1], tokens[2], tokens[3]);
                        vec.add(pst);
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return vec;
    }

    public Vector<PostRequest> findPosts(){
        Vector vec = new Vector<PostRequest>();
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        if ( Files.exists(filePath)){
            try(BufferedReader reader = Files.newBufferedReader(filePath, StandardCharsets.UTF_8)) {
                String  line = null ;
                //  repeat this till eof
                while ( (line = reader.readLine() ) != null) {
                    String[] tokens = line.split("|");
                    try{
                        ldt = LocalDateTime.parse( tokens[0].trim());
                    }catch( DateTimeParseException dte ){
                        ldt = LocalDateTime.now();
                    }

                        PostRequest pst = new PostRequest(  ldt, Integer.parseInt(tokens[1]), tokens[2], tokens[3], tokens[4]);
                        vec.add(pst);

                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return vec;

    }

    public Vector findLatestPosts(){
        Vector vec = new Vector<PostRequest>();
        if ( Files.exists(filePath)){
            try(BufferedReader reader = Files.newBufferedReader(filePath, StandardCharsets.UTF_8)) {
                String  line = null ;
                //  repeat this till eof
                while ( (line = reader.readLine() ) != null) {
                    String[] tokens = line.split("|");
                        PostRequest pst = new PostRequest(LocalDateTime.now(), Integer.parseInt(tokens[0]), tokens[1], tokens[2], tokens[3]);
                        vec.add(pst);
                    }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return vec;
    }

}
