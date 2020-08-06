package com.oocl.todolist.Enum;

public enum ResultEnum {
    DATA_NOT_FOUND("data not found");
    private final String message;

    ResultEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
