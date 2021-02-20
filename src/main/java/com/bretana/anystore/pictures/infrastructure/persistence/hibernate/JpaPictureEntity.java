package com.bretana.anystore.pictures.infrastructure.persistence.hibernate;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity(name = "picture")
@Getter
@Setter
public class JpaPictureEntity {
    private @Id String id;
    private String title;
    private Date creationDate;
    private String description;
}
