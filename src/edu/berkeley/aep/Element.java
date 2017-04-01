package edu.berkeley.aep;

/**
 * Created by kinshuksinha on 4/1/17.
 */
//Understands a general HTML element of form <> text </>
public class Element {
    protected String tag;
    protected String indent;
    protected String content;

    public Element(){
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
