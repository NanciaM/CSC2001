import java.util.Scanner;
import java.io.*;
import java.io.FileNotFoundException;

public class  Test{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
       KnowledgeEntry test1 = new KnowledgeEntry("banana");
       KnowledgeEntry test2 = new KnowledgeEntry("banana", "is tasty", Double.toString(0.9));
       KnowledgeEntry test3 = new KnowledgeEntry(  "is tasty", Double.toString(0.9));

       System.out.println(test1.getTerm());
       System.out.println(test2.getConfidenceScore());
       System.out.println(test3.getSentence());
    }
       
}