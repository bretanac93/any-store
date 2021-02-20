package com.bretana.anystore.app.advices;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class ErrorResponse {
    int code;
    String message;
}
