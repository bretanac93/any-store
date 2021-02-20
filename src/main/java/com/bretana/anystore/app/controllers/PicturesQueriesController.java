package com.bretana.anystore.app.controllers;

import com.bretana.anystore.pictures.application.find.PictureFinder;
import com.bretana.anystore.pictures.domain.Picture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PicturesQueriesController {

    private final PictureFinder service;

    @Autowired
    public PicturesQueriesController(PictureFinder service) {
        this.service = service;
    }

    @GetMapping("/pictures")
    List<Picture> findAll() {
        return this.service.findAll();
    }

    @GetMapping("/pictures/{id}")
    Picture findOneById(@PathVariable String id) {
        return this.service.findOneById(id);
    }
}
