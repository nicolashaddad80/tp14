package fr.cnam.tp14.tests;

import fr.cnam.tp14.DomTp14QuestionsResponses;
import fr.cnam.tp14.JdomTp14QuestionsResponses;


public class Tp14QuestionsResponsesTest {

    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            System.out.println("Usage : Tp14QuestionsResponsesTest <nomFichier>");
        } else {
            int qNum = 0;

            /*Using DOM*/
            org.w3c.dom.Document domDoc = DomTp14QuestionsResponses.Fatory.newInstance(args[0]);

            System.out.println("=======================  DOM Used ==============================");
            System.out.println("Question" + (++qNum) + ": Nombre interfaces Auto : " + DomTp14QuestionsResponses.question1(domDoc));
            System.out.println("Question" + (++qNum) + ": Nombre interfaces definies : " + DomTp14QuestionsResponses.question2(domDoc));
            System.out.println("Question" + (++qNum) + ": Noms Des Interfaces auto : \n" + DomTp14QuestionsResponses.question3(domDoc));
            System.out.println("Question" + (++qNum) + ": Noms Des Interfaces Autres que auto : \n" + DomTp14QuestionsResponses.question4(domDoc));
            System.out.println("Question" + (++qNum) + ": Les adresses des DHCP utilises sont : \n" + DomTp14QuestionsResponses.question5(domDoc));
            System.out.println("Question" + (++qNum) + ": Les interfaces qui utilisent la getway 5.135.166.254 sont : \n" + DomTp14QuestionsResponses.question6(domDoc, "5.135.166.254"));
            System.out.println("Question" + (++qNum) + ": Les netmask et adresses ip des intarfaces definies static sont : \n" + DomTp14QuestionsResponses.question7(domDoc));

            /*Using JDOM*/
            org.jdom2.Document jDomDoc = JdomTp14QuestionsResponses.Fatory.newInstance(args[0]);
            qNum = 0;
            System.out.println("======================= JDOM Used ==============================");
            System.out.println("Question" + (++qNum) + ": Nombre interfaces Auto : " + JdomTp14QuestionsResponses.question1(jDomDoc));
            System.out.println("Question" + (++qNum) + ": Nombre interfaces definies : " + JdomTp14QuestionsResponses.question2(jDomDoc));
            System.out.println("Question" + (++qNum) + ": Noms Des Interfaces auto : \n" + JdomTp14QuestionsResponses.question3(jDomDoc));
            System.out.println("Question" + (++qNum) + ": Noms Des Interfaces Autres que auto : \n" + JdomTp14QuestionsResponses.question4(jDomDoc));
            System.out.println("Question" + (++qNum) + ": Les adresses des DHCP utilises sont : \n" + JdomTp14QuestionsResponses.question5(jDomDoc));
            System.out.println("Question" + (++qNum) + ": Les interfaces qui utilisent la getway 5.135.166.254 sont : \n" + JdomTp14QuestionsResponses.question6(jDomDoc, "5.135.166.254"));
            System.out.println("Question" + (++qNum) + ": Les netmask et adresses ip des intarfaces definies static sont : \n" + JdomTp14QuestionsResponses.question7(jDomDoc));
        }

        /*Using SAX*/
        //TODO Coming soon
        System.out.println("======================= SAX Used ==============================");
        System.out.println("On Going");
    }
}
