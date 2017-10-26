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
public class Node {// a class to define exponent and coefficient to fill each term's data in nodes 

    private int expo;//defines exponent 
    private int coe;//defines coefficient
    Node next;//ref to next node
    Node head;//ref to first node
    

    Node() {//no args constuctor
    }

    Node(int expo, int coe) {//a constructor which takes two int epxo and coefficient

        this.expo = expo;
        this.coe = coe;

    }

    public int getExpo() {//expo's getter
        return expo;
    }

    public void setExpo(int expo) {//expo's setter
        this.expo = expo;
    }

    public int getCoe() {//coe's getter
        return coe;
    }

    public void setCoe(int coe) {//coe's setter
        this.coe = coe;
    }

    public int numOfLines() {//calculates num of file's line
        int num = 0;//initialize num

        File x = new File("polynomial.txt"); //This is used to input the movies text

        if (x.exists()) {//checks of the file exist

            Scanner input = null;//initilalize input scanner 
            try {
                input = new Scanner(x); // Scanning

            } catch (FileNotFoundException ex) {
                System.out.println("noooooo data!!!!!!!!!!!");
            }

            while (input.hasNext()) {//checks if the file has nextLine
                String line = input.nextLine(); // This is used to get to the next line 
                if (line != null) {//checks if the file has data
                    num++;//increments number of lines
                }//end of if statement

            }//end of while loop
        }//end of class
        return num;//returns number of file's lines
    }//end of method

    public void fillData(int expo, int coe) {

        for (int i = 0; i < 2; i++) {
            head.next.expo = expo;
            head.next.coe = coe;
        }
     System.out.println("Exponent is :"+expo+"\ncoefficient is :"+coe);
     
    }
    
    public void displayLink(){
        System.out.println("expo is : "+ expo+" coe is : "+ coe);
    
    }

}//end of class
