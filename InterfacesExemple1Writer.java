package fr.cnam.tp14;

import org.jdom.Attribute;
import org.jdom.DocType;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import java.io.IOException;
import java.io.Writer;

public class InterfacesExemple1Writer {

    /* putting Constructor to private to avoid Invocking it*/

    private InterfacesExemple1Writer() {
    }

    public static void serialiser(Writer out) throws IOException {

        // Création du document XML
        Element racine = new Element("interfaces");
        DocType docType = new DocType("interfaces", "interfaces.dtd");
        Document document = new Document(racine, docType);
        // Production du fichier XML en se basant sur la DTD Fournis et le fichier exemple

        /*iface "lo"*/
        Element xmlIface1 = new Element("iface");
        xmlIface1.setAttribute(new Attribute("name", "lo"));

        Element xmlInet1 = new Element("inet");
        Element xmlLoopback1 = new Element("loopback");

        xmlInet1.addContent(xmlLoopback1);
        xmlIface1.addContent(xmlInet1);
        racine.addContent(xmlIface1);

        /*iface "eth0"*/
        Element xmlIface2 = new Element("iface");
        xmlIface2.setAttribute(new Attribute("name", "eth0"));

        Element xmlInet2 = new Element("inet");
        Element xmlDhcp2 = new Element("dhcp");
        xmlDhcp2.setAttribute(new Attribute("hostname", "inteldhcpserver"));

        xmlInet2.addContent(xmlDhcp2);
        xmlIface2.addContent(xmlInet2);
        racine.addContent(xmlIface2);

        /*iface "eth1"*/
        Element xmlIface3 = new Element("iface");
        xmlIface3.setAttribute(new Attribute("name", "eth1"));

        Element xmlInet3 = new Element("inet");
        Element xmlStatic3 = new Element("static");

        Element xmlAddress3 = new Element("address");
        xmlAddress3.setText("5.135.166.198");
        xmlStatic3.addContent(xmlAddress3);

        Element xmlNetmask3 = new Element("netmask");
        xmlNetmask3.setText("255.255.255.255");
        xmlStatic3.addContent(xmlNetmask3);

        Element xmlGateaway3 = new Element("gateway");
        xmlGateaway3.setText("5.135.166.254");
        xmlStatic3.addContent(xmlGateaway3);

        xmlInet3.addContent(xmlStatic3);
        xmlIface3.addContent(xmlInet3);
        racine.addContent(xmlIface3);

        /*iface "eth3"*/
        Element xmlIface4 = new Element("iface");
        xmlIface4.setAttribute(new Attribute("name", "eth3"));

        Element xmlInet4 = new Element("inet");
        Element xmlDhcp4 = new Element("dhcp");


        xmlInet4.addContent(xmlDhcp4);
        xmlIface4.addContent(xmlInet4);
        racine.addContent(xmlIface4);

        /*auto "lo"*/
        Element xmlAuto1 = new Element("auto");

        Element xmlAutoName1_1 = new Element("name");
        xmlAutoName1_1.setAttribute(new Attribute("value","lo"));

        xmlAuto1.addContent(xmlAutoName1_1);
        racine.addContent(xmlAuto1);

        /*auto "eth0 & eth1"*/
        Element xmlAuto2 = new Element("auto");

        Element xmlAutoName2_1 = new Element("name");
        xmlAutoName2_1.setAttribute(new Attribute("value","eth0"));
        xmlAuto2.addContent(xmlAutoName2_1);

        Element xmlAutoName2_2 = new Element("name");
        xmlAutoName2_2.setAttribute(new Attribute("value","eth1"));
        xmlAuto2.addContent(xmlAutoName2_2);

        racine.addContent(xmlAuto2);

        /*Writing Document*/

        try {
            XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
            outputter.output(document, out);
        } catch (IOException e) {
            throw new RuntimeException("Erreur sur écriture : ", e);
        }
    }
}