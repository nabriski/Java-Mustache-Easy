package com.nabriski.mustacheeasy;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Tests for {@link Foo}.
 *
 * @author user@example.com (John Doe)
 */
public class TestMustacheEasy {

    @Test
    public void testSimpleTemplate() {
        String tmplStr = "Hi {{name}}";
        String json = "{\"name\":\"Harry\"}";
        assertEquals(MustacheEasy.execute(tmplStr,json),"Hi Harry");
    }
}
