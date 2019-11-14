package com.rocketbnk.nadp.controller;

import com.rocketbnk.nadp.payload.PostRequest;
import com.rocketbnk.nadp.service.NotePadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    /*@PostMapping
    @PreAuthorize("hasRole('ROLE_CREATE_NOTES')")
    public ResponseEntity<?>  createPost(@Valid  @RequestBody  PostRequest  postRequest){
            logger.info( postRequest.toString());

        return
    }*/


}
