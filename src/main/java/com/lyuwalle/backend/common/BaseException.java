package com.lyuwalle.backend.common;

/**
 * @author lyuxiyang
 */
public class BaseException extends RuntimeException {
    private int code = 500;

    public BaseException(String message) {
        super(message);
    }

    public BaseException(int code, String message) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static void cast(String message) {
        throw new BaseException(message);
    }

    public static void cast(int code, String message) {
        throw new BaseException(code, message);
    }
}
