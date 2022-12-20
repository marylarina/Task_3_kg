package com.cgvsu.math;

public class ObjWriterException extends RuntimeException{
    public ObjWriterException(String errorMessage) {
        super("Error: " + errorMessage);
    }
}
