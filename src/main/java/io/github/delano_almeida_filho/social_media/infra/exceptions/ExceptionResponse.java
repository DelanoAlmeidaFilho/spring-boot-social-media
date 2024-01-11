package io.github.delano_almeida_filho.social_media.infra.exceptions;

public class ExceptionResponse {
    private int status;
    private String message;
    private String code;

    public ExceptionResponse(int status, String message, String code) {
        this.status = status;
        this.message = message;
        this.code = code;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }

}
