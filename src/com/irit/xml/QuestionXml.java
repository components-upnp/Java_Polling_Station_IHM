package com.irit.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;
import java.util.HashMap;

/**
 * Created by mkostiuk on 22/05/2017.
 */
public class QuestionXml implements GenerateurXml {
    public String getDocXml(HashMap<String, String> args) throws ParserConfigurationException, TransformerException {

        String udn = args.get("UDN");
        String question = args.get("QUESTION");
        String key = args.get("KEY");
        String nbQuestion = args.get("NBQUESTION");

        String namespace = "";
        Document doc;
        DocumentBuilderFactory db = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;

        builder = db.newDocumentBuilder();
        doc = builder.newDocument();
        Element root = doc.createElementNS(namespace, "MasterRemoteControl");
        doc.appendChild(root);

        Element k = doc.createElementNS(namespace, "Key");
        root.appendChild(k);
        k.appendChild(doc.createTextNode(key));

        Element u = doc.createElementNS(namespace, "UDN");
        root.appendChild(u);
        u.appendChild(doc.createTextNode(udn));

        Element q = doc.createElementNS(namespace, "Question");
        root.appendChild(q);
        q.appendChild(doc.createTextNode(question));

        Element nb = doc.createElementNS(namespace, "NbQuestion");
        root.appendChild(nb);
        nb.appendChild(doc.createTextNode(nbQuestion));

        DOMSource source = new DOMSource(doc);
        StringWriter writer = new StringWriter();
        StreamResult result = new StreamResult(writer);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.transform(source, result);

        return writer.toString();
    }
}
