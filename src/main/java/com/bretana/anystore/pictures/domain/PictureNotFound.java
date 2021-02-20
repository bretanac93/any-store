package com.bretana.anystore.pictures.domain;

public class PictureNotFound extends RuntimeException {
    public PictureNotFound(String id) {
        super(String.format("Picture with id <%s> not found", id));
    }
}
