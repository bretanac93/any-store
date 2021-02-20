package com.bretana.anystore.app.dto;

import lombok.Value;

import java.util.Date;

@Value
public class CreatePictureRequest {
    String title;
    String description;
    Date creationDate;
}
