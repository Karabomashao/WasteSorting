package com.enviro.assessment.grad001.KaraboMashao.exceptions;

import java.time.LocalDateTime;

public class ErrorResponse {

    private LocalDateTime timeStamp;
    private String errorCode;
    private String message;
    private String path;

    public ErrorResponse(String errorCode, String message, LocalDateTime timeStamp, String path) {
        this.timeStamp = timeStamp;
        this.errorCode = errorCode;
        this.message = message;
        this.path = path;

    }

    public LocalDateTime getLocalDateTime() {
        return timeStamp;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return message;
    }
    public String getPath(){
        return path;
    }
}
