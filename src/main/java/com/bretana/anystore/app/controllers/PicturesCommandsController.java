package com.bretana.anystore.app.controllers;

import com.bretana.anystore.app.dto.CreatePictureRequest;
import com.bretana.anystore.pictures.application.create.PictureCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PicturesCommandsController {
    private final PictureCreator service;

    @Autowired
    public PicturesCommandsController(PictureCreator service) {
        this.service = service;
    }

    @PostMapping("/pictures")
    @ResponseStatus(HttpStatus.CREATED)
    void create(@RequestBody CreatePictureRequest request) {
        this.service.create(request.getTitle(), request.getDescription(), request.getCreationDate());
    }
}
