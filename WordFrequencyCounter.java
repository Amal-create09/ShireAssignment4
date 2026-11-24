/*
 * I certify that the Java code I am submitting is all my own work.
 * None of the code is copied from any source or any person.
 * I did not use AI to generate the code for my program.
 * Signed: Amal Shire
 * Date: 11/24/2026
 */

/*
 * author Amal Shire
 * Date: 11/24/2026
 * Class: CSS405
 * Assignment: Assignment 4
 * File Name: Main.java
 * Description:
 *
 * References: GeeksforGeeks, copilot for debugging
 */

import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

/*
 * Method Name: wordFrequencyCounter
 * Description:
 *
 * Param: none
 * Return: tree
 */
public class WordFrequencyCounter {
    private AVLTrees tree = new AVLTrees();
    /*
     * Method Name: readFile
     * Description: reads the file and separates the spaces and punctation
     *
     * Param: filename
     */
    public void readFile(String filename) {
        try {
            Scanner input = new Scanner(new File(filename));

            while (input.hasNext()) {
                String word = input.next().toLowerCase().replaceAll("[^a-z]", "");
                if (word.isEmpty()) {
                    continue;
                }
                tree.insert(word);
            }
            input.close();
        } catch (FileNotFoundException e) {
            System.out.print("File not found:" + filename);
        }
    }
    /*
     * Method Name: getTree
     * Description: calls the tree
     *
     * Param: none
     * Return: tree
     */
    public AVLTrees getTree() {
        return tree;
    }
    }

