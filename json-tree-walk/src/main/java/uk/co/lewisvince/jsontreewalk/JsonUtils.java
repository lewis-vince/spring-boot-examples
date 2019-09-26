package uk.co.lewisvince.jsontreewalk;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static void remove(JSONObject inputObj, String targetKey) {
        if (inputObj == null || targetKey == null) {
            throw new IllegalArgumentException();
        }
        List<String> keys = new ArrayList<>();
        inputObj.keys().forEachRemaining(keys::add);

        keys.forEach(key -> {
            if (key.equals(targetKey)) {
                inputObj.remove(key);
            } else {
                Object elementObj = inputObj.get(key);
                if (elementObj instanceof JSONObject) {
                    remove((JSONObject) elementObj, targetKey);
                } else if (elementObj instanceof JSONArray) {
                    remove((JSONArray) elementObj, targetKey);
                }
            }
        });
    }

    private static void remove(Object input, String targetKey) {
        if (input instanceof JSONObject) {
            remove((JSONObject) input, targetKey);
        } else if (input instanceof JSONArray) {
            remove((JSONArray) input, targetKey);
        }
    }


    private static void remove(JSONArray inputArr, String targetKey) {
        inputArr.forEach(node -> remove(node, targetKey));
    }
}
