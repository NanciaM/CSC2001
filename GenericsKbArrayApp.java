/*CSC2001 Assigment 1
 * Java program for querying and updating knowledge in GenericsKB 
 * Using traditional Arrays data structure.
 * by Nancia Mwaramba
 */


import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class GenericsKbArrayApp {
    private static final int MAX_SIZE = 100000; // GenericsKB.txt has approximatetely 50000 terms, thus max size allows an additional 50000 new terms
    private static Statements[] knowledgeBase = new Statements[MAX_SIZE];
    private static int currentSize = 0;

    private static class Statements {
        String term;
        String sentence;
        double confidenceScore;

        public Statements(String term, String sentence, double confidenceScore) {
            this.term = term;
            this.sentence = sentence;
            this.confidenceScore = confidenceScore;
        }

        public String getTerm() {
            return term;
        }

        public String getSentence() {
            return sentence;
        }

        public float getConfidenceScore() {
            return confidenceScore;
        }
    }
 

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
                    add_NewStatement(input);
                    break;
                case 3:
                    searchByTerm(input);
                    break;
                case 4:
                    searchByTermAndSentence(input);
                    break;
                case 5:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 5);

    }

    private static void Menu() {
        System.out.println("Choose an action from the menu:");
        System.out.println("1. Load a knowledge base from a file");
        System.out.println("2. Add a new statement to the knowledge base");
        System.out.println("3. Search for an item in the knowledge base by term");
        System.out.println("4. Search for an item in the knowledge base by term and sentence");
        System.out.println("5. Quit");
    }

    private static void loadKnowledgeBase_FromFile(Scanner input) {
        System.out.print("Enter the file name: ");// get the name of file to be loaded
        String file = input.next();

        try (Scanner fileInput = new Scanner(new File(fileName))) {  //test is file data meets basic format
            while (fileInput.hasNextLine()) {
                String line = fileInput.nextLine();
                String[] segment = line.split("\t");

                if (segment.length == 3) {
                    String term = segment[0];
                    String sentence = segment[1];
                    float confidenceScore = segment[2];
 
                } else {
                    System.out.println("Invalid data format in the file.");
                }
            }
            System.out.println("Knowledge base loaded successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Please check the file name and try again.");
        } catch (NumberFormatException e) {
            System.out.println("Error parsing confidence score. Please check the file format.");
        }
    }

    private static void add_NewStatement(Scanner input) {
        System.out.print("Enter the term: ");
        String term = input.next();
        input.nextLine();  

        System.out.print("Enter the sentence: ");
        String sentence = input.nextLine();

        System.out.print("Enter the confidence score (between 0 and 1): ");
        float confidenceScore = input.nextfloat();

        // Search for the term in the knowledge base
        int position = FindTerm_ByIndexPosition(term);

        if (position != -1) {
            // Term found, update the statement
            knowledgeBase[position] = new Statements(term, sentence, confidenceScore);
            System.out.println("Statement for term " + term + " has been updated.");
        } else {
            // Term not found, inform the user
            System.out.println("Term " + term + " not found in the knowledge base.");
        }
        System.out.println("Statement for term has been updated.");
    }

    private static int FindTerm_ByIndexPosition(String term) {
        for (int i = 0; i < knowledgeBase.length; i++) {
            if (knowledgeBase[i] != null && knowledgeBase[i].getTerm().equals(term)) {
                return i;  // Found the term, return the position
            }
        }
        return -1;  // Term not found
    }

    private static void searchByTerm(Scanner input) {
        System.out.print("Enter the term to search: ");
        String term = input.next();
        input.nextLine();  

        int position = FindTerm_ByIndexPosition(term);

        if (position != -1) {
            // Term found, update the statement
            Statements foundTerm = knowledgeBase[position]
            System.out.println("Statement found: " + foundTerm.getTerm() + " " +
            foundTerm.getSentence() + " (Confidence Score: " +
            foundTerm.getConfidenceScore() + ")");
        } else {
            // Term not found, inform the user
            System.out.println("Term " + term + " not found in the knowledge base.");
        }
    }    
