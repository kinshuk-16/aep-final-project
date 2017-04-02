package edu.berkeley.aep;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by kinshuksinha on 4/1/17.
 */
//Understands a general HTML element of form <name> text </name>
public class Element {
    private String tag;
    private String attributes;
    private String content;

    public Element(String tag){
        this.tag = tag;
        this.content = "";
        this.attributes ="";
    }

    public Element(String content, String tag){
        this.tag = tag;
        this.attributes ="";
        this.content = "\n" + content;
    }

    public Element(String tag, List<Map<String, String>> attributes){
        this.tag = tag;
        this.content = "";
        this.attributes =addAttributes(attributes);

    }

    public Element(String content, String tag, List<Map<String, String>> attributes ){
        this.tag = tag;
        this.attributes = addAttributes(attributes);
        this.content = "\n" + content;

    }

    private String addAttributes(List<Map<String, String>> attributes){
        String attributeString = " ";
        Iterator<Map<String, String>> attrIterator = attributes.iterator();
        while(attrIterator.hasNext()){
            Map <String, String> attr = attrIterator.next();
            attributeString += attr.keySet().toArray()[0] + "=\"" + attr.get(attr.keySet().toArray()[0]) +"\"";
        }
        return attributeString;
    }

    public void append(String content){
        this.content += "\n"+ content;
    }

    public void append(Element innerElement){
        this.content += innerElement.openTag();
    }

    public void append(List<Map<String, String>> attributes) {
        this.attributes = addAttributes(attributes);
    }

    private String openTag(){
        return "\n<"+this.tag + this.attributes +">" + this.content + "\n</"+this.tag +">";
    }

    public String render(){
        String result = "";
        result += "<!DOCTYPE html>";
        result +=  openTag();
        return result;
    }


}
