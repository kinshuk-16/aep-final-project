package edu.berkeley.aep;

import org.junit.Test;

import java.util.*;

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

    @Test
    public void BodyTagWithNoContentShouldAppendNewLineToItOnCallingAppend(){
        Element index = new Element("body");
        index.append("");
        String expected ="<!DOCTYPE html>" +
                "\n<body>"+
                "\n"+
                "\n</body>";
        assertEquals(expected,index.render());
    }

    @Test
    public void BodyTagWithNoContentShouldAppendSampleContentToItOnCallingAppendWithSampleContent(){
        Element index = new Element("body");
        index.append("Sample Content");
        String expected ="<!DOCTYPE html>" +
                "\n<body>"+
                "\nSample Content"+
                "\n</body>";
        assertEquals(expected,index.render());
    }

    @Test
    public void ShouldBeAbleToAppendBodyTagInsideHtmlTag(){
        Element index = new Element("html");
        Element index_body = new Element("body");
        String expected ="<!DOCTYPE html>" +
                "\n<html>"+
                "\n<body>"+
                "\n</body>"+
                "\n</html>";
        index.append(index_body);
        assertEquals(expected,index.render());
    }

    @Test
    public void ShouldBeAbleToAppendBodyTagWithSampleContentAndHeadTagIndideHtmlTag(){
        Element index = new Element("html");
        Element index_body = new Element("body");
        Element index_head = new Element("head");
        index_body.append("Sample Content");
        index.append(index_head);
        index.append(index_body);
        String expected ="<!DOCTYPE html>" +
                "\n<html>"+
                "\n<head>"+
                "\n</head>"+
                "\n<body>"+
                "\nSample Content"+
                "\n</body>"+
                "\n</html>";
        assertEquals(expected,index.render());
    }

    @Test
    public void ShouldBeAbleToAddAttributeHrefAndValueHomeToTag(){
        List<Map<String,String>> attributes = new ArrayList<Map<String,String>>();
        Map <String, String> href = Collections.singletonMap("href","home");
        attributes.add(href);
        Element anchor = new Element("a",attributes);
        anchor.append("Go To Home Page");
        String expected = "<!DOCTYPE html>" +
                "\n<a href=\"home\">"+
                "\nGo To Home Page"+
                "\n</a>";
        assertEquals(expected,anchor.render());

    }

    @Test
    public void ShouldBeAbleToAddAttributeHrefAndValueHomeToTagAndContent(){
        List<Map<String,String>> attributes = new ArrayList<Map<String,String>>();
        Map <String, String> href = Collections.singletonMap("href","home");
        attributes.add(href);
        Element anchor = new Element("Go To Home Page","a",attributes);
        String expected = "<!DOCTYPE html>" +
                "\n<a href=\"home\">"+
                "\nGo To Home Page"+
                "\n</a>";
        assertEquals(expected,anchor.render());

    }

    @Test
    public void ShouldBeAbleToAppendAttributeHrefAndValueHomeToAnchorTag(){
        List<Map<String,String>> attributes = new ArrayList<Map<String,String>>();
        Map <String, String> href = Collections.singletonMap("href","home");
        attributes.add(href);
        Element anchor = new Element("a");
        anchor.append("Go To Home Page");
        anchor.append(attributes);
        String expected = "<!DOCTYPE html>" +
                "\n<a href=\"home\">"+
                "\nGo To Home Page"+
                "\n</a>";
        assertEquals(expected,anchor.render());
    }
    @Test
    public void shouldBeAbleToCreateAndRenderVoidTagBr(){
        Element br = new Element("br",true);
        String expected = "<!DOCTYPE html>" +
                "\n<br/>";
        assertEquals(expected,br.render());

    }
    // write test for self closing tag. Set a flag in constructor. Only constructor with tag can be used, raise exception if othr constructor
    // called with flag true(more tests for this). Different implementation for open tag. 4 tests (1 for each constructor - 1 calls open tag, 3 raises exception)
}
