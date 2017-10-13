/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * @author ayah
 */

    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ayah
 */
public class Node {
    
    public int co; //cooficient

    public Node next; //reference to next node
    
    public int expo; //exponent
    
  
    Node(){}//no args constructor 
    Node(int co){
        this.co=co;
    }
    Node(int co,Node next, int expo){
        this.co=co ;
        this.expo=expo; 
          
    }
    Node(int co,int expo){
        this.co=co; 
        
        this.expo=expo; 
        
    }


    public void displayLink(){       // display ourself
      
      System.out.println("cooficient:  "+ co+ "expo:  "+expo);
      }
   }  // end class Node
    
    
    

