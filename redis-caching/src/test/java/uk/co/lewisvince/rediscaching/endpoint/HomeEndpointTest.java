package uk.co.lewisvince.rediscaching.endpoint;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class HomeEndpointTest {

    HomeEndpoint homeEndpoint = new HomeEndpoint(null);

    @Test
    public void testValidSingleDimensionArray_parsesCorrectly() {
        String input = "[34.5, 84.2]";
        List<Object> output = homeEndpoint.parse(input);

        assertNotNull(output);
        assertEquals(2, output.size());
        assertEquals(34.5, output.get(0));
        assertEquals(84.2, output.get(1));
    }

    @Test
    public void testValidTwoDimensionalArray_parsesCorrectly() {
        String input = "[[23.2, 88.2],[94.8,857.9]]";
        List<Object> output = homeEndpoint.parse(input);

        assertNotNull(output);
        assertEquals(2, output.size());
        assertTrue(output.get(0) instanceof List);
        List<Object> list1 = (List<Object>) output.get(0);
        assertEquals(23.2, list1.get(0));
        assertEquals(88.2, list1.get(1));

        assertTrue(output.get(1) instanceof List);
        List<Object> list2 = (List<Object>) output.get(1);
        assertEquals(94.8, list2.get(0));
        assertEquals(857.9, list2.get(1));
    }
}
