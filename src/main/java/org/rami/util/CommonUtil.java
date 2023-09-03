package org.rami.util;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Repository;

@Repository
public class CommonUtil {
    public JSONObject makeResponse(int code, String message, String info) {
        JSONObject response = new JSONObject();
        response.put("code", code);
        response.put("message", message);
        response.put("info", info);
        return response;
    }

}
