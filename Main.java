/*
 * I certify that the Java code I am submitting is all my own work.
 * None of the code is copied from any source or any person.
 * I did not use AI to generate the code for my program.
 * Signed: Amal Shire
 * Date: 11/24/2026
 */

/*
 * author Amal Shire
 * Date: 11/19/2026
 * Class: CSS405
 * Assignment: Assignment 4
 * File Name: Main.java
 * Description: Allows user to input file and displays the traversals
 *
 * References: GeeksforGeeks
 */

import java.util.Scanner;
/*
 * Method Name: main
 * Description: Allows user to input file and displays the traversals
 *
 * Param: String[] args
 */
public static void main(String[] args) {

    Scanner input = new Scanner(System.in);

    WordFrequencyCounter counter = new WordFrequencyCounter();
    System.out.print("Enter File to Read: ");
    String filename = input.nextLine();

    counter.readFile(filename);

    System.out.println("=== In-Order Traversal (Alphabetical) ===");
    counter.getTree().inorder();
    System.out.println("=== PreOrder Traversal (Using Stack) ===");
    counter.getTree().preorder();

    input.close();
}