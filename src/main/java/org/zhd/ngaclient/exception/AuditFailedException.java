package org.zhd.ngaclient.exception;

public class AuditFailedException extends NgaException {
    public AuditFailedException(String message, int code) {
        super(message, code);
    }
}
