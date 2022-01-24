package com.cursrespring.curser.services.exceptions;

public class DatabaseExepetion extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public DatabaseExepetion(String msg) {
        super(msg);
    }

}
