package fr.cnam.tp14.tests;

import fr.cnam.tp14.DomTP14QuestionsResponses;
import fr.cnam.tp14.JdomTP14QuestionsResponses;
import org.w3c.dom.Document;


public class DomTP14QuestionsResponsesTest {

    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            System.out.println("Usage : DomTP14QuestionsResponsesTest <nomFichier>");
        } else {
            int qNum = 0;

            /*Using DOM*/
            org.w3c.dom.Document domDoc = DomTP14QuestionsResponses.Fatory.newInstance(args[0]);

            System.out.println("=======================  DOM Used ==============================");
            System.out.println("Question" + (++qNum) + ": Nombre interfaces Auto : " + DomTP14QuestionsResponses.question1(domDoc));
            System.out.println("Question" + (++qNum) + ": Nombre interfaces definies : " + DomTP14QuestionsResponses.question2(domDoc));
            System.out.println("Question" + (++qNum) + ": Noms Des Interfaces auto : \n" + DomTP14QuestionsResponses.question3(domDoc));
            System.out.println("Question" + (++qNum) + ": Noms Des Interfaces Autres que auto : \n" + DomTP14QuestionsResponses.question4(domDoc));
            System.out.println("Question" + (++qNum) + ": Les adresses des DHCP utilises sont : \n" + DomTP14QuestionsResponses.question5(domDoc));
            System.out.println("Question" + (++qNum) + ": Les interfaces qui utilisent la getway 5.135.166.254 sont : \n" + DomTP14QuestionsResponses.question6(domDoc, "5.135.166.254"));
            System.out.println("Question" + (++qNum) + ": Les netmask et adresses ip des intarfaces definies static sont : \n" + DomTP14QuestionsResponses.question7(domDoc));

            /*Using JDOM*/
            org.jdom2.Document jDomDoc = JdomTP14QuestionsResponses.Fatory.newInstance(args[0]);
            qNum = 0;
            System.out.println("======================= JDOM Used ==============================");
            System.out.println("Question" + (++qNum) + ": Nombre interfaces Auto : " + JdomTP14QuestionsResponses.question1(jDomDoc));
            System.out.println("Question" + (++qNum) + ": Nombre interfaces definies : " + JdomTP14QuestionsResponses.question2(jDomDoc));
            System.out.println("Question" + (++qNum) + ": Noms Des Interfaces auto : \n" + JdomTP14QuestionsResponses.question3(jDomDoc));
            System.out.println("Question" + (++qNum) + ": Noms Des Interfaces Autres que auto : \n" + JdomTP14QuestionsResponses.question4(jDomDoc));
            System.out.println("Question" + (++qNum) + ": Les adresses des DHCP utilises sont : \n" + JdomTP14QuestionsResponses.question5(jDomDoc));
            System.out.println("Question" + (++qNum) + ": Les interfaces qui utilisent la getway 5.135.166.254 sont : \n" + JdomTP14QuestionsResponses.question6(jDomDoc, "5.135.166.254"));
            System.out.println("Question" + (++qNum) + ": Les netmask et adresses ip des intarfaces definies static sont : \n" + JdomTP14QuestionsResponses.question7(jDomDoc));
        }

        /*Using SAX*/
        //TODO Coming soon
        System.out.println("======================= SAX Used ==============================");
        System.out.println("On Going");
    }
}
