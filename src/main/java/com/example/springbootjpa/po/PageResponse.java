package com.example.springbootjpa.po;

import org.springframework.data.domain.Page;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: weidl
 * @Description:
 * @Date: Created in 13:37 2019/5/16
 */
public class PageResponse  extends  BaseResponse{
    private Map<String,Object> data;

    public Map<String, Object> getData() {
        return data;
    }
    public PageResponse(String message){
        super(message);
    }
    public  PageResponse(){

    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public PageResponse result(String key, Page page){
        Map<String,Object> result=new HashMap<String,Object>();
        result.put(key,page.getContent());
        result.put("totalCount",page.getTotalElements());
        this.data=result;
        return this;
    }
    public PageResponse success(){
        this.setErrCode(0);
        this.setMessage("");
        return this;
    }
}