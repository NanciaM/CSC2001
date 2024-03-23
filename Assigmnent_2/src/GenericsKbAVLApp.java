/*CSC2001 Assigment 1
 * Java program for querying and updating knowledge in GenericsKB 
 * Using traditional Arrays data structure.
 * by Nancia Mwaramba
 */


import java.util.Scanner;
import java.io.*;
import java.io.FileNotFoundException;

public class  GenericsKbAVLApp{
     public static AVLTree avlKnowledgeBase = new AVLTree();
    public static int currentSize = 0;
    
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
                    searchInFile(input);
                    break;
                case 3:
                    searchByQuery(input);
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
        try {  //test is file data meets basic format
            Scanner fileInput = new Scanner(new FileInputStream(fileName));
            while (fileInput.hasNextLine()) {
                String line = fileInput.nextLine();
                String[] segment = line.split("\t");

                if (segment.length == 3) {
                    String term = segment[0];
                    String sentence = segment[1];
                    String confidenceScore = segment[2];
		    avlKnowledgeBase.insert(term,sentence,confidenceScore);
                } else {
                    System.out.println("Invalid data format in the file.");
                }
               
            }
             
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Please check the file name and try again.");
        } catch (NumberFormatException e) {
            System.out.println("Error parsing confidence score. Please check the file format.");
      }   
        System.out.println("Knowledge base loaded successfully.");
    }

    public static void searchByQuery(Scanner input){
	System.out.print("Enter the Query file name: ");// get the name of file to be loaded
	String Qfile = input.next();
		 try{
				// Read in the file
	 	Scanner fileTerms = new Scanner(new FileInputStream(Qfile));
		 	while(fileTerms.hasNextLine()){
		 	String word = fileTerms.nextLine();
			String statement = ""; // Default value for statement and cofidenceScore
				String conScore = "";
				avlKnowledgeBase.find(word, statement, conScore);
			}
		} catch(FileNotFoundException e){
			System.out.println("File not found.");
		}
	}

    public static void searchInFile(Scanner input) {
    System.out.print("Enter the term to search: ");
    String term = input.next();
    input.nextLine();
    System.out.print("Enter the Statement: ");
    String statement = input.next();
    input.nextLine();
    System.out.print("Enter Confidence score: ");
    Double cScore = input.nextDouble();
    String confidenceScore = Double.toString(cScore);
    input.nextLine();

    // Check if the node is found in the AVL tree
    AVLTreeNode foundNode = avlKnowledgeBase.find(term, statement, confidenceScore, avlKnowledgeBase.getRoot());
    avlKnowledgeBase.visit(foundNode);
  }
}
