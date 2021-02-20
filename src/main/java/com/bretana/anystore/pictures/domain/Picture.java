package com.bretana.anystore.pictures.domain;

import lombok.Getter;

import java.util.Date;
import java.util.UUID;

@Getter
public class Picture {
    private final UUID id;
    private final String title;
    private final String description;
    private final Date creationDate;

    public Picture(UUID id, String title, String description, Date creationDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.creationDate = creationDate;
    }

    public Picture(String title, String description, Date creationDate) {
        this(UUID.randomUUID(), title, description, creationDate);
    }
}
