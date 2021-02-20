package com.bretana.anystore.pictures.application.create;

import com.bretana.anystore.pictures.domain.Picture;
import com.bretana.anystore.pictures.domain.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PictureCreator {
    private final PictureRepository repository;

    @Autowired
    public PictureCreator(PictureRepository repository) {
        this.repository = repository;
    }

    public void create(String title, String description, Date creationDate) {
        var picture = new Picture(
                title,
                description,
                creationDate
        );
        this.repository.create(picture);
    }
}
