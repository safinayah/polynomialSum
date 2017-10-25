/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polynomialsum;

/**
 *
 * @author ayah
 */
public class Node {
    
    Node next;//ref to next node

    private int co; //cooficient

    private int expo; //exponent
    

    Node(){ }//no args constructor 

    Node(int co) {//a cosntructor 
        this.co = co;
        
    }


    Node(int co, int expo) {//a cosntructor takes coefficient and exponent 
        this.co = co;
        this.next=next;
        this.expo = expo;

    }



} // end class Node
