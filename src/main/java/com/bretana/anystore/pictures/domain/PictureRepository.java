package com.bretana.anystore.pictures.domain;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PictureRepository {
    List<Picture> findAll();
    Optional<Picture> findById(UUID id);
    void create(Picture picture);
}
