package edu.berkeley.aep;

/**
 * Created by kinshuksinha on 4/1/17.
 */
//Understands a general HTML element of form <name> text </name>
public class Element {
    private final String tag;
    private final String content;

    public Element(String content, String tag){
        this.tag = tag;
        this.content = "\n" + content;
    }

    public String render(){
        String result = "";
        result += "<!DOCTYPE html>\n";
        result +=  "<"+this.tag +">";
        result +=  this.content;
        result +=  "</"+this.tag +">";
        return result;
    }
}
