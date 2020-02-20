package fr.cnam.tp14;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class DomDocumentFactoryBuilder {

    /* Put constructor to private to abvoid invocking it*/
    private DomDocumentFactoryBuilder() {
    }

    public Document newInstance(String xmlFileName) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(false);
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();

            return builder.parse(xmlFileName);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException("Erreur sur le parseur xml : ", e);
        } catch (IOException e) {
            throw new RuntimeException("Erreur sur la lectrure du fichier : ", e);
        } catch (SAXException e) {
            throw new RuntimeException("Erreur dans sax : ", e);
        }
    }
}
