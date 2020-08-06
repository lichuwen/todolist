package com.oocl.todolist.exception;

public class GlobalException extends Throwable {
    String message;

    public GlobalException(String message) {
        super(message);
        this.message = message;
    }

    public String getMsg() {
        return message;
    }

    public void setMsg(String message) {
        this.message = message;
    }
}
