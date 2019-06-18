package com.example.springbootjpa.po;

import lombok.Data;
import lombok.ToString;

/**
 * @Author: weidl
 * @Description:
 * @Date: Created in 13:37 2019/5/16
 */
@Data
@ToString
public class BaseResponse {
    private int errCode=0;
    private String message;

    public BaseResponse() {
    }
    public BaseResponse( String message) {
        this.message = message;
    }


    public BaseResponse(int errCode, String message) {
        this.errCode = errCode;
        this.message = message;
    }
}