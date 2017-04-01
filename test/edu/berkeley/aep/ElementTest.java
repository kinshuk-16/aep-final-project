package edu.berkeley.aep;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by kinshuksinha on 4/1/17.
 */
public class ElementTest {
    @Test
    public void callingRenderOnElementWillReturnDoctypeTagAndNullTags(){
        Element index = new Element();
        String expected = "<!DOCTYPE html>\n" +
                            "<null>null</null>";
        assertEquals(expected, index.render());
    }
}
