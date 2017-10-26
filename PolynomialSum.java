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
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scan s = new Scan();
        String[] expo = s.getExpo();
        String[] coe = s.getCoe();
        Node data = s.getData();
   LinkedList list = new LinkedList();
        Node p = new Node() ; 
        int x= p.numOfLines();
       // System.out.println("File's line = "+x); 
        
       // p.fillData(x, x);
      //  s.pass(expo, coe, data);
      System.out.println(list);

    }//end of main

}//end of class
