package fr.cnam.tp14.tests;

import fr.cnam.tp14.DomTP14QuestionsResponses;
import org.w3c.dom.Document;


public class DomTP14QuestionsResponsesTest {

    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            System.out.println("Usage : DomTP14QuestionsResponsesTest <nomFichier>");
        } else {

            Document doc = DomTP14QuestionsResponses.Fatory.newInstance(args[0]);
            int qNum = 0;
            System.out.println("Question" + (++qNum) + ": Nombre interfaces Auto : " + DomTP14QuestionsResponses.question1(doc));
            System.out.println("Question" + (++qNum) + ": Nombre interfaces definies : " + DomTP14QuestionsResponses.question2(doc));
            System.out.println("Question" + (++qNum) + ": Noms Des Interfaces auto : \n" + DomTP14QuestionsResponses.question3(doc));
            System.out.println("Question" + (++qNum) + ": Noms Des Interfaces Autres que auto : \n" + DomTP14QuestionsResponses.question4(doc));
            System.out.println("Question" + (++qNum) + ": Les adresses des DHCP utilises sont : \n" + DomTP14QuestionsResponses.question5(doc));
            System.out.println("Question" + (++qNum) + ": Les interfaces qui utilisent la getway 5.135.166.254 sont : \n" + DomTP14QuestionsResponses.question6(doc, "5.135.166.254"));
            System.out.println("Question" + (++qNum) + ": Les netmask et adresses ip des intarfaces definies static sont : \n" + DomTP14QuestionsResponses.question7(doc));
        }
    }
}
