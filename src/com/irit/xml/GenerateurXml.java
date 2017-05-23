package com.irit.xml;


import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.util.HashMap;

/**
 * Created by mkostiuk on 22/05/2017.
 */
public interface GenerateurXml {

    public String getDocXml(HashMap<String, String> args) throws ParserConfigurationException, TransformerException;

}
