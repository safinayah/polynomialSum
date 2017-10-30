package polynomialsum;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

class LinkedList {

    private static int counter;
    private Node head;
    private Node last;
    // Default constructor
    public LinkedList() {
        Node n = new Node(); 
        this.head = n; 
        this.last=this.head;
    }
    // appends the specified element to the end of this list.
   
    // appends the specified element to the end of this list.
    public void add(Node n) {
        this.last.next = n;
        this.last = this.last.next;
        // increment the number of elements variable
        incrementCounter();
        
       
    }

    private static int getCounter() {
        return counter;
    }

    private static void incrementCounter() {
        counter++;
    }

    private void decrementCounter() {
        counter--;
    }

    // returns the number of elements in this list.
    public int size() {
        return getCounter();
    }

    @Override
      public String toString() {
        StringBuilder output = new StringBuilder();
        Node current = this.head.next;
 
            while (current != null) {
                output.append(current.toString());
                current = current.getNext();
            }

        
        return output.toString();
    }

}
