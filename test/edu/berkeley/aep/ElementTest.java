package edu.berkeley.aep;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by kinshuksinha on 4/1/17.
 */
public class ElementTest {
    @Test
    public void EmptyTagNameWithEmptyContentShouldStartWithDocTypeAndThenHaveEmptyTagsWithNewLineInBetween(){
        Element index = new Element("","");
        String expected ="<!DOCTYPE html>" +
                "\n<>"+
                "\n"+
                "\n</>";
        assertEquals(expected,index.render());
    }
    @Test
    public void BodyTagWithSampleContentShouldStartWithDocTypeAndThenHavebodyTagsWithSampleContentInBetween(){
        Element index = new Element("Sample","body");
        String expected ="<!DOCTYPE html>" +
                "\n<body>"+
                "\nSample"+
                "\n</body>";
        assertEquals(expected,index.render());
    }
}
