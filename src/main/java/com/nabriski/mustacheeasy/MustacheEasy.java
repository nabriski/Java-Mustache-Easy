package com.nabriski.mustacheeasy;

import java.util.Map;
import java.util.HashMap; 
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import org.json.*;
import com.samskivert.mustache.*;

public class MustacheEasy
{

    public static String execute(String template,String data) throws JSONException{
       Map jo = jsonToMap(new JSONObject(data));
       Template tmpl = com.samskivert.mustache.Mustache.compiler().compile(template);
       return tmpl.execute(jo);
    }

    public static Map jsonToMap(JSONObject json) throws JSONException {
        Map<String, Object> retMap = new HashMap<String, Object>();

        if(json != JSONObject.NULL) {
            retMap = toMap(json);
        }
        return retMap;
    }

    public static Map toMap(JSONObject object) throws JSONException {
        Map<String, Object> map = new HashMap<String, Object>();

        Iterator<String> keysItr = object.keys();
        while(keysItr.hasNext()) {
            String key = keysItr.next();
            Object value = object.get(key);

            if(value instanceof JSONArray) {
                value = toList((JSONArray) value);
            }

            else if(value instanceof JSONObject) {
                value = toMap((JSONObject) value);
            }
            map.put(key, value);
        }
        return map;
    }

    public static List toList(JSONArray array) throws JSONException {
        List<Object> list = new ArrayList<Object>();
        for(int i = 0; i < array.length(); i++) {
            Object value = array.get(i);
            if(value instanceof JSONArray) {
                value = toList((JSONArray) value);
            }

            else if(value instanceof JSONObject) {
                value = toMap((JSONObject) value);
            }
            list.add(value);
        }
        return list;
    }
}
