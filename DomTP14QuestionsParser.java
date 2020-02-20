package fr.cnam.tp14;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class DomTP14QuestionsParser {


    private static int question1(Document doc) {
        String sTagFilter = "auto";
        var filtredNodeList = doc.getElementsByTagName(sTagFilter);
        return filtredNodeList.getLength();
    }

    /*
        public void printNode(Node n) {
            if (n.getNodeType() == Node.ELEMENT_NODE) {
                this.printer.print(n.getNodeName() + " {");
                this.printer.indent();
                // attributes
                NamedNodeMap attrs = n.getAttributes();
                for (int i = 0; i < attrs.getLength(); i++) {
                    Attr attr = (Attr) attrs.item(i);
                    this.printer.print("[" + attr.getName() + " = " + attr.getValue() + "]");
                }
            } else if (n.getNodeType() == Node.TEXT_NODE) {
                this.printer.print("\"" + n.getNodeValue().trim() + "\"");
            }
            // children
            Node child = n.getFirstChild();
            while (child != null) {
                this.printNode(child);
                child = child.getNextSibling();
            }
            // close node
            if (n.getNodeType() == Node.ELEMENT_NODE) {
                this.printer.deindent();
                this.printer.print("}");
            }
    */
    private static int question2(Document doc) {

        String sTagFilter = "iface";
        var filtredNodeList = doc.getElementsByTagName(sTagFilter);
        return filtredNodeList.getLength();
    }

    private static String question3(Document doc) {

        String sTagFilter = "auto";
        int num = 0;
        StringBuilder myReturnStringBuilder = new StringBuilder();

        var filtredNodeList = doc.getElementsByTagName(sTagFilter);
        for (int i = 0; i < filtredNodeList.getLength(); i++) {

            Node auto = filtredNodeList.item(i);
            myReturnStringBuilder.append(++num).append(" ").append(auto.getNodeName());

            Node nameChild = auto.getFirstChild();
            while (nameChild != null) {
                //checking before Castring
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

    private static String question4(Document doc) {

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

    private static String question5(Document doc) {

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

    private static String question6(Document doc, String gatewayIpAddress) {

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


    private static String question7(Document doc) {


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


    //TODO CLEAN Moove in separated class and decklare this having public static questionN , create methode that builds new Document (Factory builder)
    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            System.out.println("Usage : DOMPrinter <nomFichier>");
        } else {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(true);
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(args[0]);

            int qNum = 0;
            System.out.println("Question" + (++qNum) + ": Nombre interfaces Auto : " + question1(doc));
            System.out.println("Question" + (++qNum) + ": Nombre interfaces definies : " + question2(doc));
            System.out.println("Question" + (++qNum) + ": Noms Des Interfaces auto : \n" + question3(doc));
            System.out.println("Question" + (++qNum) + ": Noms Des Interfaces Autres que auto : \n" + question4(doc));
            System.out.println("Question" + (++qNum) + ": Les adresses des DHCP utilises sont : \n" + question5(doc));
            System.out.println("Question" + (++qNum) + ": Les interfaces qui utilisent la getway 5.135.166.254 sont : \n" + question6(doc, "5.135.166.254"));
            System.out.println("Question" + (++qNum) + ": Les netmask et adresses ip des intarfaces definies static sont : \n" + question7(doc));

        }
    }
}


