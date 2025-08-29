package com.jimmy.springsec.modal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SuccessResponse {

    public static Map<String, Object> listResponse(List<Object> list, int status) {
        Map<String, Object> map = new HashMap<>();
        map.put("list", list);
        map.put("status", status);
        return map;
    }

    public static Map<String, Object> msgResponse(String msg, int status) {
        Map<String, Object> map = new HashMap<>();
        map.put("msg", msg);
        map.put("status", status);
        return map;
    }

    public static Map<String, Object> normalResponse(Object resp, int status) {
        Map<String, Object> map = new HashMap<>();
        map.put("resp", resp);
        map.put("status", status);
        return map;
    }

}
