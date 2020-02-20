package fr.cnam.tp14.tests;

import fr.cnam.tp14.JdomTP14QuestionsResponses;
import org.jdom2.Document;
import org.jdom2.input.SAXBuilder;

import java.io.FileReader;

public class JDomTP14QuestionsResponsesTest {

    public static void main(String[] args) throws Exception {

        if (args.length == 0) {
            System.out.println("Usage : JdomTP14QuestionsResponsesTest <nomFichier.xml>");
        } else {

            int qNum = 0;
            SAXBuilder builder = new SAXBuilder(true);
            Document doc = builder.build(new FileReader(args[0]));

            System.out.println("Question" + (++qNum) + ": Nombre interfaces Auto : " + JdomTP14QuestionsResponses.question1(doc));
            System.out.println("Question" + (++qNum) + ": Nombre interfaces definies : " + JdomTP14QuestionsResponses.question2(doc));
            System.out.println("Question" + (++qNum) + ": Noms Des Interfaces auto : \n" + JdomTP14QuestionsResponses.question3(doc));
            System.out.println("Question" + (++qNum) + ": Noms Des Interfaces Autres que auto : \n" + JdomTP14QuestionsResponses.question4(doc));
            System.out.println("Question" + (++qNum) + ": Les adresses des DHCP utilises sont : \n" + JdomTP14QuestionsResponses.question5(doc));
            System.out.println("Question" + (++qNum) + ": Les interfaces qui utilisent la getway 5.135.166.254 sont : \n" + JdomTP14QuestionsResponses.question6(doc, "5.135.166.254"));
            System.out.println("Question" + (++qNum) + ": Les netmask et adresses ip des intarfaces definies static sont : \n" + JdomTP14QuestionsResponses.question7(doc));
        }
    }
}
