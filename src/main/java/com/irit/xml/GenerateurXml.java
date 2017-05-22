package com.irit.xml;

import javax.swing.text.Document;
import java.util.HashMap;

/**
 * Created by mkostiuk on 22/05/2017.
 */
public interface GenerateurXml {

    public Document getDocXml(HashMap<String, String> args);

}
