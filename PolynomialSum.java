/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polynomialsum;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


/**
 *
 * @author ayah
 */
public class Scan {

    private String coe[] = null;
    private String expo[] = null;
    Node data = new Node();
    Node fill = new Node(); 
    LinkedList[] list = new LinkedList[size()];
    
    


    public Scan() {
    }//no args constructor 

    public Scan(String coe[], String expo[], Node data) {//a coinstractor takes coefficient exponent data
        this.data = data;
        this.expo = expo;
        this.coe = coe;
    }

    public Scan(String coe[]) {//a coeficcient takes string[]
        this.coe = coe;
    }

    public Scan(String expo[], Node data) {//a constructor takes string[] and LL
        this.data = data;
        this.expo = expo;
    }

    public Scan(Node data) {//a constructor takes LL
        this.data = data;
    }

    public Node getData() {//getter for data
        return data;
    }

    public void setData(Node data) {//setter for data
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

    void pass(String[] expo, String[] coe, Node data) {//a function reads from file and split the string into coefficients and exponents 

        int exp,co=0; //variables to assign exponet and co values in'em
        File x = new File("polynomial.txt"); //This is used to input the movies text

        if (x.exists()) {//checks of the file exist

            
            Scanner input = null;//initilalize input scanner 
            try {
                input = new Scanner(x); // Scanning
                
            } catch (FileNotFoundException ex) {
               System.out.println("noooooo data!!!!!!!!!!!");
            }

            while (input.hasNext()) {//checks if the file has nextLine

               
                String line = input.nextLine(); // This is used to get to the next line and trim thm from the sides
                String[] terms = line.split("(\\+)");//splits on sum notation
                System.out.println(line);
                for (String term : terms) {
                    expo = term.split("\\^");//split on power notation

                    coe = expo[0].split("x");//split on x

                    if (expo.length > 1 && coe.length == 1) {//splits terms with power
                        System.out.println("exponet: " + expo[1] + "\ncoefficientA is : " + coe[0]);
                        exp = Integer.parseInt(expo[1]);//parse string expo into int
                        co = Integer.parseInt(coe[0]);//parse string coe int int
                        
                        data.fillData(exp,co); //adds values to data
                    } else if (expo.length <= 1 && coe.length == 1) {//split linear terms
                       // System.out.println("exponent is 1" + "\ncoefficientB is :" + coe[0]);
                        exp = 1;//expo equals one 
                        co = Integer.parseInt(coe[0]);////parse string coe into int
                        data.fillData(exp, co); //adds values to data[]
                    }//end if statement
                    else if (coe.length != 1 && expo.length != 1) {
                       // System.out.println("exponent is : " + expo[1] + "\ncoefficient  is 1");
                        exp = Integer.parseInt(expo[1]);
                        co = 1;
                        data.fillData(exp, co); //adds values to data
                    } else if (coe.length != 1 && expo.length == 1) {
                       // System.out.println("exponent is : 1 \nexponent is : 1");
                        exp = co = 1;//expo and co equlas one
                     data.fillData(exp, co); //adds values to data
                    }//end of if else if statements 

                }//end enhanced for loop

            }//end of while loop

        }//end of ifExsist is statement

    }//end of method
    public int size(){
       return fill.numOfLines();
        
    }

}//end of scan class
