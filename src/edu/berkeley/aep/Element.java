package edu.berkeley.aep;

/**
 * Created by kinshuksinha on 4/1/17.
 */
//Understands a general HTML element of form <name> text </name>
public class Element {
    private final String tag;
    private String content;

    public Element(String content, String tag){
        this.tag = tag;
        this.content = "\n" + content;
    }

    public Element(String tag){
        this.tag = tag;
        this.content = "";
    }

    public void append(String content){
        this.content += "\n"+ content;
    }

    public void append(Element innerElement){
        this.content += innerElement.openTag();
    }

    private String openTag(){
        return "\n<"+this.tag +">" + this.content + "\n</"+this.tag +">";
    }

    public String render(){
        String result = "";
        result += "<!DOCTYPE html>";
        result +=  openTag();
        return result;
    }
}
