package fr.cnam.tp14.tests;

import fr.cnam.tp14.InterfacesExemple1Writer;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class InterfacesExemple1WriterTest {


    public static void main(String[] args) throws Exception {
        Writer monFichierxml = null;
        try {
            monFichierxml = new FileWriter("InterfacesExample1AutoJDOMGenerated.xml");
        } catch (IOException e) {
            System.out.println("Problem sur le fichier créé");
            //Not mandatory to close FileWriter as it is autoClosable
        }
        try {

            InterfacesExemple1Writer.serialiser(monFichierxml);
        } catch (IOException e) {
            System.out.println("Problem sur le fichier DTD");
            //Not mandatory to close FileWriter as it is autoClosable
        }
    }
}
