package caoa.dog;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class XulTest {

    @Test
    public void regroup() throws Exception {
        List<String> values = Arrays.asList("B", "B", "B", "A", "B", "B", "B", "B", "A", "B", "B", "B", "A", "A");

        List<Map.Entry<String, List<String>>> expected = Arrays.asList( //
            new AbstractMap.SimpleImmutableEntry("A", Arrays.asList("B", "B", "B", "B")), //
            new AbstractMap.SimpleImmutableEntry("A", Arrays.asList("B", "B", "B")), //
            new AbstractMap.SimpleImmutableEntry("A", Collections.emptyList()), //
            new AbstractMap.SimpleImmutableEntry("A", Collections.emptyList()));
        List<Map.Entry<String, List<String>>> actual = Xul.regroup(values, s -> Objects.equals("A", s));

        assertEquals(expected, actual);
    }

}
