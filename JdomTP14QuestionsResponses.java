package fr.cnam.tp14;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.filter.ElementFilter;
import org.jdom2.input.SAXBuilder;
import org.jdom2.util.IteratorIterable;

import java.io.FileReader;
import java.io.IOException;

public class JdomTp14QuestionsResponses {
    /*putting Constructor private to avoid invoking it*/
    private JdomTp14QuestionsResponses() {
    }

    public final static int question1(Document doc) {

        int nbAuto = 0;
        IteratorIterable<Element> itAuto = doc.getDescendants(new ElementFilter("auto"));
        for (Element chapter : itAuto) nbAuto++;

        return nbAuto;
    }

    public final static int question2(Document doc) {

        int nbIface = 0;
        IteratorIterable<Element> itIface = doc.getDescendants(new ElementFilter("iface"));
        for (Element chapter : itIface) nbIface++;

        return nbIface;
    }

    public final static String question3(Document doc) {
        int num = 0;
        StringBuilder myReturnStringBuilder = new StringBuilder();
        IteratorIterable<Element> itAuto = doc.getDescendants(new ElementFilter("auto"));
        for (Element auto : itAuto) {
            myReturnStringBuilder.append(++num);
            myReturnStringBuilder.append(" ");
            myReturnStringBuilder.append(auto.getName());

            for (Element name : auto.getChildren("name")) {
                myReturnStringBuilder.append("\t").append(name.getAttribute("value").getValue());
            }
            myReturnStringBuilder.append("\n");
        }
        return myReturnStringBuilder.toString();
    }

    public final static String question4(Document doc) {

        int num = 0;
        StringBuilder myReturnStringBuilder = new StringBuilder();
        ElementFilter allElements = new ElementFilter();
        String filterIface = "iface";

        IteratorIterable<Element> itAll = doc.getDescendants(allElements);
        for (Element element : itAll) {

            String currentElementName = element.getName();
            if (currentElementName.equals(filterIface)) {
                myReturnStringBuilder.append(++num);
                myReturnStringBuilder.append(" ");
                myReturnStringBuilder.append(currentElementName);

                myReturnStringBuilder.append("\t").append(element.getAttribute("name").getValue());
                myReturnStringBuilder.append("\n");
            }
        }

        return myReturnStringBuilder.toString();
    }

    public final static String question5(Document doc) {

        String sFilter = "dhcp";
        int num = 0;
        StringBuilder myReturnStringBuilder = new StringBuilder();
        ElementFilter allElements = new ElementFilter(sFilter);

        IteratorIterable<Element> filteredIt = doc.getDescendants(allElements);
        try {
            for (Element element : filteredIt) {

                myReturnStringBuilder.append(++num);
                myReturnStringBuilder.append(" ");
                myReturnStringBuilder.append(element.getName());
                myReturnStringBuilder.append("\t").append(element.getAttribute("hostname").getValue());
                myReturnStringBuilder.append("\n");
            }
        } catch (NullPointerException e) {
                /*Nothing to do as this dhscp hosthame attribute is optional
                this just means current dhcp Element does not have hostname
                 */
        }

        return myReturnStringBuilder.toString();
    }

    public final static String question6(Document doc, String gatewayIpAddress) {
        String sFilter = "gateway";
        int num = 0;
        StringBuilder myReturnStringBuilder = new StringBuilder();
        ElementFilter allElements = new ElementFilter(sFilter);

        IteratorIterable<Element> filteredIt = doc.getDescendants(allElements);

        for (Element element : filteredIt) {
            if (element.getValue().equals(gatewayIpAddress)) {
                Element gatewayIfaceParent = element.getParentElement().getParentElement().getParentElement();
                myReturnStringBuilder.append(++num);
                myReturnStringBuilder.append(" ");
                myReturnStringBuilder.append(gatewayIfaceParent.getName());
                myReturnStringBuilder.append("\t").append(gatewayIfaceParent.getAttribute("name").getValue());
                myReturnStringBuilder.append("\n");
            }
        }

        return myReturnStringBuilder.toString();
    }

    public final static String question7(Document doc) {
        String sFilter = "static";
        int num = 0;
        StringBuilder myReturnStringBuilder = new StringBuilder();
        ElementFilter allElements = new ElementFilter(sFilter);

        IteratorIterable<Element> filteredIt = doc.getDescendants(allElements);

        for (Element element : filteredIt) {
            Element staticAddressIP = element.getChild("address");
            Element staticNetmaskIP = element.getChild("netmask");
            myReturnStringBuilder.append(++num).append(" ").append(element.getParentElement().getParentElement().getAttribute("name").getValue()).append(" : \n");
            myReturnStringBuilder.append("\t").append(staticAddressIP.getName()).append("\t").append(staticAddressIP.getValue()).append("\n");
            myReturnStringBuilder.append("\t").append(staticNetmaskIP.getName()).append("\t").append(staticNetmaskIP.getValue()).append("\n");
        }

        return myReturnStringBuilder.toString();
    }

    /*Internal Factory Class*/
    public static class Fatory {

        /* Put constructor to private to abvoid invocking it*/
        private Fatory() {
        }

        public static Document newInstance(String xmlFileName) {

            SAXBuilder builder = new SAXBuilder(true);
            Document doc = null;
            try {
                doc = builder.build(new FileReader(xmlFileName));
                return doc;
            } catch (JDOMException e) {
                throw new RuntimeException("Erreur dans JDOME : ", e);
            } catch (IOException e) {
                throw new RuntimeException("Erreur sur la lectrure du fichier : ", e);
            }
        }
    }
}

