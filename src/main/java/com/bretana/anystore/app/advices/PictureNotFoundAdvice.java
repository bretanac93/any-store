package com.bretana.anystore.app.advices;

import com.bretana.anystore.pictures.domain.PictureNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
public class PictureNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(PictureNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ErrorResponse pictureNotFoundHandler(PictureNotFound exception) {
        return new ErrorResponse(HttpStatus.NOT_FOUND.value(), exception.getMessage());
    }
}
