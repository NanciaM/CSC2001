/*CSC2001 Assigment 1
 * Java program for querying and updating knowledge in GenericsKB 
 * Using traditional Arrays data structure.
 * by Nancia Mwaramba
 */


import java.util.Scanner;
import java.io.*;
import java.io.FileNotFoundException;

public class  GenericsKbAVLApp{
    public static AVLTree<dataType> avlKnowledgeBase = new AVLTree<dataType>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;

        do {
            Menu();
            System.out.print("Enter your choice: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    loadKnowledgeBase_FromFile(input);
                    break;
                case 2:
                    searchBy_Term(input);
                    break;
                case 3:
                    searchByQueryFile(input);
                    break;
                case 4:
                    System.out.println("Exiting the program.");
                    break;
               
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 4);

    }

    public static void Menu() {
        System.out.println("Choose an action from the menu:");
        System.out.println("1. Load a knowledge base from a file");
        System.out.println("2. Search for an item in the knowledge base by term");
        System.out.println("3. Search from query file");
        System.out.println("4. Quit");
    }

    public static void loadKnowledgeBase_FromFile(Scanner input){
        System.out.print("Enter the file name: ");// get the name of file to be loaded
        String fileName = input.next();
        while (fileInput.hasNextLine()) {
            String line = fileInput.nextLine();
            String[] segment = line.split("\t");
            String term = segment[0];
            String sentence = segment[1];
            String confidenceScore = Double.toString(segment[2]);
            KnowledgeEntry data = new KnowledgeEntry(sentence, confidenceScore);
            avlKnowledgeBase.insert(term);

        }

    }

    public static void searchBy_Term(Scanner input){
        System.out.println("2 works");
    }

    public static void searchByQueryFile(Scanner input){
        System.out.println("3 works");
    }

}