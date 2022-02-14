package com.b2wdigital.selecao.peopleregistration.service.exception;

public class BadRequestException extends RuntimeException{

    private static final long serialVersionUID = 2L;

    public BadRequestException(String msg){
        super(msg);
    }

    public BadRequestException(String msg, Throwable cause){
        super(msg, cause);
    }
}
