package org.zhd.ngaclient.exception;

public class NgaException extends Exception{
    private final int code;

    public NgaException(String message, int code) {
        super(message);
        this.code = code;
    }
}
