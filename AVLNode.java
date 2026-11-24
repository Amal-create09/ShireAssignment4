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
 * References: GeeksforGeeks, Zybooks, copilot for debugging
 */

/*
 * Method Name: AVLNode
 * Description: sets up the tree nodes
 *
 * Param: key, count, parent, left, right, height
 */
public class AVLNode {
    private String key;
    private int count;
    private AVLNode parent;
    private AVLNode left;
    private AVLNode right;
    private int height;
    /*
     * Method Name: AVLNode
     * Description: null methods
     *
     * Param: nodeKey
     */
    public AVLNode(String nodeKey) {
        this.key = nodeKey;
        this.parent = null;
        this.left = null;
        this.right = null;
        this.height = 0;
        this.count = 1;
    }
    /*
     * Method Name: getBalance
     * Description: gets the balance of a tree
     *
     * Param: none
     * Return: leftHieght - rightHeight
     */
    public int getBalance() {
        int leftHeight = -1;
        if(left != null) {
            leftHeight = left.height;
        }
        int rightHeight = -1;
        if(right != null) {
            rightHeight = right.height;
        }
        return leftHeight - rightHeight;
    }
    /*
     * Method Name: setKey
     * Description: sets the key
     *
     * Param: newKey
     */
    public void setKey(String newKey) {
        key = newKey;
    }
    /*
     * Method Name: getKey
     * Description: calls key
     *
     * Param: none
     * Return: key
     */
    public String getKey() {
        return key;
    }
    /*
     * Method Name: getHeight
     * Description: calls the height
     *
     * Param: none
     * Return: height
     */
    public int getHeight() {
        return height;
    }
    /*
     * Method Name: getCount
     * Description: calls the count
     *
     * Param: none
     * Return: count
     */
    public int getCount() {
        return count;
    }
    /*
     * Method Name: incrementCount
     * Description: increase the count each node
     *
     * Param: none
     */
    public void incrementCount() {
        count++;
    }
    /*
     * Method Name: setParent
     * Description: set the parent node
     *
     * Param: newParent
     */
    public void setParent(AVLNode newParent) {
        parent = newParent;
    }
    /*
     * Method Name: getParent
     * Description: calls the parent node
     *
     * Param: none
     * Return: parent
     */
    public AVLNode getParent() {
        return parent;
    }
    /*
     * Method Name: getLeft
     * Description: calls left child
     *
     * Param: none
     * Return: left
     */
    public AVLNode getLeft() {
        return left;
    }
    /*
     * Method Name: setLeft
     * Description: sets the left child
     *
     * Param: newLeftChild
     */
    public void setLeft(AVLNode newLeftChild) {
        left = newLeftChild;
        if(left != null) {
            left.parent = this;
        }
        updateHeight();
    }
    /*
     * Method Name: getRight
     * Description: calls the right child
     *
     * Param: none
     * Return: right
     */
    public AVLNode getRight() {
        return right;
    }
    /*
     * Method Name: setRight
     * Description: set up right child
     *
     * Param: newRightChild
     */
    public void setRight(AVLNode newRightChild) {
        right = newRightChild;
        if(right != null) {
            right.parent = this;
        }
        updateHeight();
    }

    /*
     * Method Name: updateHeight
     * Description: updates the height when changes
     *
     * Param: none
     */
    public void updateHeight() {
        int leftHeight = -1;
        if(left != null) {
            leftHeight = left.height;
        }
        int rightHeight = -1;
        if(right != null) {
            rightHeight = right.height;
        }
        height = Math.max(leftHeight, rightHeight) + 1;
    }
}
