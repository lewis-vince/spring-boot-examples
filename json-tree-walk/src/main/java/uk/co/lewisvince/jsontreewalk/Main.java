package uk.co.lewisvince.jsontreewalk;

import com.google.common.io.Resources;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.Charset;

public class Main {

    public static void main(String[] args) throws IOException {
        String inputStr = Resources.toString(Resources.getResource("test.json"), Charset.defaultCharset());
        JSONObject object = new JSONObject(inputStr);
        JsonUtils.remove(object, "metadata");
        System.out.println(object);
    }
}
