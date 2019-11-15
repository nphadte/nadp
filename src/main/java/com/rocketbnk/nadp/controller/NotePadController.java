package com.rocketbnk.nadp.controller;

import com.rocketbnk.nadp.payload.ApiResponse;
import com.rocketbnk.nadp.payload.PostRequest;
import com.rocketbnk.nadp.service.NotePadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/notepad")
public class NotePadController {

    private static final Logger logger = LoggerFactory.getLogger(NotePadController.class);

    @Autowired
    NotePadService  notePadService;

    @PostMapping
    @PreAuthorize("hasRole('ROLE_CREATE_NOTES')")
    public ResponseEntity<?>  createPost(@Valid  @RequestBody  PostRequest  postRequest){
        logger.info( postRequest.toString());

        //int userId, String firstname, String lastname, String text_note
        Integer userId = postRequest.getUserid();
        String firstname = postRequest.getFirstname();
        String lastname = postRequest.getLastname();
        String text_note = postRequest.getText_note();
        if(!notePadService.writePost(userId,firstname,lastname,text_note)){
            return new ResponseEntity(new ApiResponse(false, " This text_note was rejected "),
                    HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(new ApiResponse(false, "This text_note was succesfully persisted!"),
                HttpStatus.OK);
    }



}
