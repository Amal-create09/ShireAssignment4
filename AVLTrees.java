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
 * File Name: AVLTrees.java
 * Description: Establish the Tree, operations, traversals, rotations and rebalancing
 *
 * References: GeeksforGeeks, Zybooks, copilot for debugging
 */

import java.util.Stack;

/*
 * Method Name: AVLTrees
 * Description: Set up the tree and trees functions
 *
 * Param: Root
 */
public class AVLTrees {
    private AVLNode root;
    /*
     * Method Name: Insert
     * Description: calls insert operation
     *
     * Param: Key
     */
    public void insert(String key) {
        root = insert(root, key, null);
        if(root != null) {
            root.setParent(null);
        }
    }
    /*
     * Method Name: delete
     * Description: calls the delete operation
     *
     * Param: key
     */
    public void delete(String key) {
        root = delete(root, key);
        if(root != null) {
            root.setParent(null);
        }
    }
    /*
     * Method Name: search
     * Description: call the search operation
     *
     * Param: key
     */
    public boolean search(String key) {
        return search(root, key) != null;
    }
    /*
     * Method Name: inorder
     * Description: calls the inorder traversal
     *
     * Param: root
     */
    public void inorder() {
        inorder(root);
    }
    /*
     * Method Name: preorder
     * Description: calls preorder traversal
     *
     * Param: root
     */
    public void preorder() {
        preorder(root);
    }
    /*
     * Method Name: insert
     * Description: inserts a new node and increment the count
     *
     * Param: node, key, parent
     * Return: node
     */
    private AVLNode insert(AVLNode node, String key, AVLNode parent) {
        if(node == null) {
            AVLNode newNode = new AVLNode(key);
            newNode.setParent(parent);
            return newNode;
        }

        int cmp = key.compareTo(node.getKey());

        if(cmp < 0) {
            node.setLeft(insert(node.getLeft(), key, node));
        }
        else if(cmp > 0) {
            node.setRight(insert(node.getRight(), key, node));
        }
        else {
            node.incrementCount();
            return node;
        }
        return rebalance(node);
    }
    /*
     * Method Name: search
     * Description: searches for the node
     *
     * Param: node, key
     * Return: key
     */
    private AVLNode search(AVLNode node, String key) {
        if(node == null) {
            return null;
        }

        int cmp = key.compareTo(node.getKey());

        if(cmp == 0) {
            return node;
        }

        if(cmp < 0) {
            return search(node.getLeft(), key);
        }
        return search(node.getRight(), key);
    }
    /*
     * Method Name: delete
     * Description: searches a node, deletes it and handles its successors
     *
     * Param: node, key
     * Return: node
     */
    private AVLNode delete(AVLNode node, String key) {
        if(node == null) {
            return null;
        }

        int cmp = key.compareTo(node.getKey());

        if(cmp < 0) {
            node.setLeft(delete(node.getLeft(), key));
            if(node.getLeft() != null) {
                node.getLeft().setParent(node);
            }
        }
        else if(cmp > 0) {
            node.setRight(delete(node.getRight(), key));
            if(node.getRight() != null) {
                node.getRight().setParent(node);
            }
        }
        else {
            if(node.getLeft() == null || node.getRight() == null) {
                AVLNode temp;
                if(node.getLeft() != null) {
                    temp = node.getLeft();
                }
                else {
                    temp = node.getRight();
                }
                if(temp == null) {
                    return null;
                }
                temp.setParent(node.getParent());
                return temp;
            }

            AVLNode successor = minValueNode(node.getRight());
            node.setKey(successor.getKey());
            node.setRight(delete(node.getRight(), successor.getKey()));

            if(node.getRight() != null) {
                node.getRight().setParent(node);
            }
        }
        return rebalance(node);
    }
    /*
     * Method Name: minValueNode
     * Description: finds the smallest node to use for deletion
     *
     * Param: node
     * Return: current
     */
    private AVLNode minValueNode(AVLNode node) {
        AVLNode current = node;
        while(current.getLeft() != null) {
            current = current.getLeft();
        }
        return current;
    }
    /*
     * Method Name: rebalance
     * Description: checks nodes and rotates them if needed
     *
     * Param: node
     * Return: node
     */
    private AVLNode rebalance(AVLNode node) {
        node.updateHeight();

        int balance = node.getBalance();

        if(balance > 1 && node.getLeft().getBalance() >= 0) {
            return rotateRight(node);
        }
        if(balance > 1 && node.getLeft().getBalance() < 0) {
            node.setLeft(rotateLeft(node.getLeft()));
            return rotateRight(node);
        }
        if(balance < -1 && node.getRight().getBalance() <= 0) {
            return rotateLeft(node);
        }
        if(balance < -1 && node.getRight().getBalance() > 0) {
            node.setRight(rotateRight(node.getRight()));

            return rotateLeft(node);
        }
        return node;
    }
    /*
     * Method Name: rotatedRight
     * Description: rotates the left subtree
     *
     * Param: y
     * Return: x
     */
    private AVLNode rotateRight(AVLNode y) {
        AVLNode oldParent = y.getParent();
        AVLNode x = y.getLeft();
        AVLNode T2 = x.getRight();

        x.setRight(y);
        y.setLeft(T2);

        x.setParent(oldParent);
        y.setParent(x);

        y.updateHeight();
        x.updateHeight();

        return x;
    }
    /*
     * Method Name: rotateLeft
     * Description: rotates the right subtree
     *
     * Param: x
     * Return: y
     */
    private AVLNode rotateLeft(AVLNode x) {
        AVLNode oldParent = x.getParent();
        AVLNode y = x.getRight();
        AVLNode t2 = y.getLeft();

        y.setLeft(x);
        x.setRight(t2);

        y.setParent(oldParent);
        x.setParent(y);

        x.updateHeight();
        y.updateHeight();

        return y;
    }
    /*
     * Method Name: inorder
     * Description: displays nodes keys and count in inorder traversal
     *
     * Param: node
     */
    private void inorder(AVLNode node) {
        if(node == null) {
            return;
        }
        inorder(node.getLeft());

        System.out.println(
                node.getKey() + ":" + node.getCount()
        );
        inorder(node.getRight());
    }
    /*
     * Method Name: preorder
     * Description: displays nodes keys and count in preorder traversal
     *
     * Param: root
     */
    private void preorder(AVLNode root) {

        if (root == null) {
            return;
        }

        Stack<AVLNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {

            AVLNode current = stack.pop();

            System.out.println(
                    current.getKey() + " : " +
                            current.getCount()
            );

            if (current.getRight() != null) {
                stack.push(current.getRight());
            }

            if (current.getLeft() != null) {
                stack.push(current.getLeft());
            }
        }
    }
}