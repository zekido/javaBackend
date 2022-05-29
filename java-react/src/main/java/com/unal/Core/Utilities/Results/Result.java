package com.unal.Core.Utilities.Results;


import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Result {
    private boolean success;
    private String message;

    public Result(boolean success) {
        this.success = success;
    }

    // all args constructor ile hepsini almış oldum
//    public Result(boolean success,String message) {
//        this.success = success;
//        this.message = message;
//    }

    public boolean isSuccess() {
        return this.success;
    }

    public String getMessage() {
        return this.message;
    }


}
