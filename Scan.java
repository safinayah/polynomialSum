/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polynomialsum;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ayah
 */
public class Scan {

  
    public Scan() {
    }//no args constructor 

    public LinkedList[] pass() {//a function reads from file and split the string into coefficients and exponents 
      
        String coe[] = null;
        String expo[] = null;

        File x = new File("polynomial.txt"); //This is used to input the movies text

        int lineNum = this.numOfLines();
        int i =0;
        LinkedList[] arr = new LinkedList[lineNum];
        if (x.exists()) {//checks of the file exist

            Scanner input = null;//initilalize input scanner 
            try {
                input = new Scanner(x); // Scanning

            } catch (FileNotFoundException ex) {
                System.out.println("noooooo data!!!!!!!!!!!");
            }

            while (input.hasNext()) {//checks if the file has nextLine
                LinkedList s = new LinkedList();
                String line = input.nextLine(); // This is used to get to the next line and trim thm from the sides
                String[] terms;//splits on sum notation
                System.out.println(line);
                terms = line.split("([\\+|\\-])");
                for (String term : terms) {
                    expo = term.split("\\^");//split on power notation

                    coe = expo[0].split("x");//split on x

                    if (expo.length > 1 && coe.length == 1) {//splits terms with power
                        // System.out.println("exponet: " + expo[1] + "\ncoefficientA is : " + coe[0]);
   
                        s.add(new Node(Integer.parseInt(expo[1]),Integer.parseInt(coe[0])));
                    }else if (expo.length <= 1 && coe.length == 1) {//split linear terms
                        // System.out.println("exponent is 1" + "\ncoefficientB is :" + coe[0]);
                       s.add(new Node(0,Integer.parseInt(coe[0])));
                     
                    }//end if statement
                    else if (coe.length != 1 && expo.length != 1) {
                        s.add(new Node(Integer.parseInt(expo[1]),1));
                    

                    } else if (coe.length != 1 && expo.length == 1) {
                        // System.out.println("exponent is : 1 \nexponent is : 1");
                        s.add(new Node(1,1));
                    }//end of if else if statements 
                    
                }//end enhanced for loop
                arr[i] = s;
                i++;
            }//end of while loop
            input.close();
        }//end of ifExsist is statement

        return arr;
    }//end of method

        public int numOfLines() {//calculates num of file's line
        int num = 0;//initialize num

        File x = new File("polynomial.txt"); //This is used to input the movies text

        if (x.exists()) {//checks of the file exist

            Scanner input = null;//initilalize input scanner 
            try {
               input = new Scanner(x);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(LinkedList.class.getName()).log(Level.SEVERE, null, ex);
            }

            while (input.hasNext()) {//checks if the file has nextLine
                String line = input.nextLine(); // This is used to get to the next line 
                if (line != null) {//checks if the file has data
                    num++;//increments number of lines
                }//end of if statement

            }//end of while loop
                    input.close();
        }//end of class

        return num;//returns number of file's lines
    }//end of method
}//end of scan class
