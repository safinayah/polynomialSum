package polynomialsum;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author ayah
 */
public class LinkedList {
   

    private Node head;
    
    public void insertFirst(int co, int expo) {//make new Node
        Node firstNode = new Node(co, expo);
        firstNode.next = head;
        head = firstNode;
    }//end of isert first method
    
    public void LinkedList() {//constructor
        head = null;
    }//end of consructor

    public boolean isEmpty() {
        return (head == null);
    }//end if isEmpty method



    public void displayList() {//displays the list
        Node curr = head;
        while (curr != null) {
           System.out.println(curr);
            curr = curr.next;

        }//end of while statement
        System.out.println("");

    }//end of displayList method

    @Override
    public String toString() {
        return "LinkedList{" + "head=" + head + '}';
    }

}//end of class
