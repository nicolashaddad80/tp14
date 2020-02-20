package fr.cnam.tp14;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;


public class DomTP14QuestionsResponses {

    /*Internal Factory Class*/
    public static class Fatory {

        /* Put constructor to private to abvoid invocking it*/
        private Fatory() {
        }

        public static Document newInstance(String xmlFileName) {
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
    };

    /*putting Constructor private to avoid invoking it*/

    private DomTP14QuestionsResponses() {
    }

    public final static int question1(Document doc) {
        String sTagFilter = "auto";
        var filtredNodeList = doc.getElementsByTagName(sTagFilter);
        return filtredNodeList.getLength();
    }

    public final static int question2(Document doc) {

        String sTagFilter = "iface";
        var filtredNodeList = doc.getElementsByTagName(sTagFilter);
        return filtredNodeList.getLength();
    }

    public final static String question3(Document doc) {

        String sTagFilter = "auto";
        int num = 0;
        StringBuilder myReturnStringBuilder = new StringBuilder();

        var filtredNodeList = doc.getElementsByTagName(sTagFilter);
        for (int i = 0; i < filtredNodeList.getLength(); i++) {

            Node auto = filtredNodeList.item(i);
            myReturnStringBuilder.append(++num).append(" ").append(auto.getNodeName());

            Node nameChild = auto.getFirstChild();
            while (nameChild != null) {
                //checking before Casting
                if (nameChild.getNodeType() == Node.ELEMENT_NODE) {
                    Element nameElem = (Element) nameChild;
                    myReturnStringBuilder.append("\t").append(nameElem.getAttribute("value"));

                }
                nameChild = nameChild.getNextSibling();
            }
            myReturnStringBuilder.append("\n");
        }
        return myReturnStringBuilder.toString();
    }

    public final static String question4(Document doc) {

        String sTagFilter = "iface";
        int num = 0;
        StringBuilder myReturnStringBuilder = new StringBuilder();

        var filtredNodeList = doc.getElementsByTagName(sTagFilter);
        for (int i = 0; i < filtredNodeList.getLength(); i++) {

            Node iface = filtredNodeList.item(i);
            myReturnStringBuilder.append(++num).append(" ").append(iface.getNodeName());

            if (iface.getNodeType() == Node.ELEMENT_NODE) {
                Element ifaceElem = (Element) iface;
                myReturnStringBuilder.append("\t").append(ifaceElem.getAttribute("name"));

            }

            myReturnStringBuilder.append("\n");
        }
        return myReturnStringBuilder.toString();
    }

    public final static String question5(Document doc) {
        String sTagFilter = "dhcp";
        int num = 0;
        StringBuilder myReturnStringBuilder = new StringBuilder();
        var filtredNodeList = doc.getElementsByTagName(sTagFilter);
        for (int i = 0; i < filtredNodeList.getLength(); i++) {
            Node dhcp = filtredNodeList.item(i);
            myReturnStringBuilder.append(++num).append(" ").append(dhcp.getNodeName());
            if (dhcp.getNodeType() == Node.ELEMENT_NODE) {
                Element dhcpElem = (Element) dhcp;
                myReturnStringBuilder.append("\t").append(dhcpElem.getAttribute("hostname"));
            }
            myReturnStringBuilder.append("\n");
        }
        return myReturnStringBuilder.toString();
    }

    public final static String question6(Document doc, String gatewayIpAddress) {
        String sTagFilter = "gateway";
        int num = 0;
        StringBuilder myReturnStringBuilder = new StringBuilder();
        var filtredNodeList = doc.getElementsByTagName(sTagFilter);
        for (int i = 0; i < filtredNodeList.getLength(); i++) {
            Node gateway = filtredNodeList.item(i);
            if (gateway.getNodeType() == Node.ELEMENT_NODE) {
                Element ifaceParentElem = (Element) gateway.getParentNode().getParentNode().getParentNode();
                myReturnStringBuilder.append(++num).append(" ").append(ifaceParentElem.getNodeName());
                myReturnStringBuilder.append("\t").append(ifaceParentElem.getAttribute("name"));

            }
            myReturnStringBuilder.append("\n");
        }
        return myReturnStringBuilder.toString();
    }

    public final static String question7(Document doc) {

        String sTagFilter = "static";
        int num = 0;
        StringBuilder myReturnStringBuilder = new StringBuilder();

        var filtredNodeList = doc.getElementsByTagName(sTagFilter);
        for (int i = 0; i < filtredNodeList.getLength(); i++) {

            Node staticNode = filtredNodeList.item(i);
            Node staticAddressIP = staticNode.getFirstChild().getNextSibling();
            Node staticNetmaskIP = staticAddressIP.getNextSibling().getNextSibling();

            myReturnStringBuilder.append(++num).append(" ").append(((Element) staticNode.getParentNode().getParentNode()).getAttribute("name")).append(" : \n");
            myReturnStringBuilder.append("\t").append(staticAddressIP.getNodeName()).append("\t").append(staticAddressIP.getTextContent()).append("\n");
            myReturnStringBuilder.append("\t").append(staticNetmaskIP.getNodeName()).append("\t").append(staticNetmaskIP.getTextContent()).append("\n");

            myReturnStringBuilder.append("\n");
        }
        return myReturnStringBuilder.toString();
    }
}


