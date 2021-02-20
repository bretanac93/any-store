package com.bretana.anystore.pictures.application.find;

import com.bretana.anystore.pictures.domain.Picture;
import com.bretana.anystore.pictures.domain.PictureNotFound;
import com.bretana.anystore.pictures.domain.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PictureFinder {
    private final PictureRepository repository;

    @Autowired
    public PictureFinder(PictureRepository repository) {
        this.repository = repository;
    }

    public List<Picture> findAll() {
        return this.repository.findAll();
    }

    public Picture findOneById(String id) {
        var result = this.repository.findById(UUID.fromString(id));

        if (result.isEmpty()) {
            throw new PictureNotFound(id);
        }

        return result.get();
    }
}
