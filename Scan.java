/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polynomialsum;

import java.io.File;
import java.io.FileNotFoundException;
import static java.lang.Integer.parseInt;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ayah
 */
public class Scan {

    private String coe[] = null;
    private String expo[] = null;
    private LinkedList data = new LinkedList();

    public Scan() {
    }//no args constructor 

    public Scan(String coe[], String expo[], LinkedList data) {//a coinstractor takes coefficient exponent data
        this.data = data;
        this.expo = expo;
        this.coe = coe;
    }

    public Scan(String coe[]) {//a coeficcient takes string[]
        this.coe = coe;
    }

    public Scan(String expo[], LinkedList data) {//a constructor takes string[] and LL
        this.data = data;
        this.expo = expo;
    }

    public Scan(LinkedList data) {//a constructor takes LL
        this.data = data;
    }

    public LinkedList getData() {//getter for data
        return data;
    }

    public void setData(LinkedList data) {//setter for data
        this.data = data;
    }

    public String[] getCoe() {//getter of coefficient
        return coe;
    }

    public void setCoe(String[] coe) {//setter of coefficient
        this.coe = coe;
    }

    public String[] getExpo() {//getter of exponent
        return expo;
    }

    public void setExpo(String[] expo) {//setter of exponent
        this.expo = expo;
    }

    void pass(String[] expo, String[] coe, LinkedList data) {//a function reads from file and split the string into coefficients and exponents 

      
        File x = new File("polynomial.txt"); //This is used to input the movies text

        if (x.exists()) {

            // System.out.print("Helloooooooooo");
            Scanner input = null;
            try {
                input = new Scanner(x); // Scanning
                // System.out.println("fvjfdvd  "+input.nextLine());
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Scan.class.getName()).log(Level.SEVERE, null, ex);
            }

            while (input.hasNext()) {

                // System.out.println("I CAN SEE THE FILE");
                int i = 0;

                String line = input.nextLine(); // This is used to get to the next line and trim thm from the sides
                String[] terms = line.split("(\\+)");
                
                for (String term : terms) {
                    expo = term.split("\\^");
                    
                     coe = expo[0].split("x");
                    
                    
                        if (expo.length > 1 && coe.length == 1){//splits terms with power
                    
                        System.out.println("exponet: " + expo[1] + "\ncoefficientA is : " + coe[0]);
                        int c = Integer.parseInt(expo[1]);
                        System.out.println("vvvv"+c);
             
                       
                    } else if (expo.length <= 1 && coe.length == 1) {//split linear terms
                        System.out.println("exponent is 1"+"\ncoefficientB is :" + coe[0]);
                    }//end if statement
                    else if(coe.length != 1 && expo.length !=1 ){
                        System.out.println("exponent is : "+expo[1]+ "\ncoefficient  is 1");
                    } else if(coe.length != 1 && expo.length ==1 ){
                        System.out.println("exponent is : 1 \nexponent is : 1");
                    }

                }//end enhanced for loop
                    
                   // System.out.println("term: " + (expo.length > 1 ? expo[0] : expo[0]+"\ncoe is: "+coe[0]));
                    
                }
                
            }

    }//end of method

}
