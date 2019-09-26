package uk.co.lewisvince.jsontreewalk;

import com.google.common.io.Resources;
import org.json.JSONObject;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

import java.io.IOException;
import java.nio.charset.Charset;

public class JsonUtilsTest {

    @Test(expected = IllegalArgumentException.class)
    public void testNullInputObject_throwsInvalidParamException() {
        JsonUtils.remove(null, "TEST");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullInputTargetKey_throwsInvalidParamException() {
        JsonUtils.remove(new JSONObject(), null);
    }

    @Test
    public void testMultiLayeredObject_withNoTargetKeyMatches_keepsSameObjectStructure() throws IOException {
        JSONObject input = new JSONObject(Resources.toString(Resources.getResource("test_noMetadataFields.json"), Charset.defaultCharset()));
        JsonUtils.remove(input, "metadata");
        JSONObject expected = new JSONObject(Resources.toString(
                Resources.getResource("test_noMetadataFields.json"), Charset.defaultCharset()));
        JSONAssert.assertEquals(expected.toString(), input.toString(), true);
    }

    @Test
    public void testMultiLayeredObject_withTargetKeyMatches_removesAllTargetNodes() throws IOException {
        JSONObject input = new JSONObject(Resources.toString(Resources.getResource("test_withMetadataFields.json"), Charset.defaultCharset()));
        JsonUtils.remove(input, "metadata");
        JSONObject expected = new JSONObject(Resources.toString(
                Resources.getResource("test_noMetadataFields.json"), Charset.defaultCharset()));
        JSONAssert.assertEquals(expected.toString(), input.toString(), true);
    }

}
