/*
 * To change this license header, choose License Headers in Driver Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author ayah
 */
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        //Application.launch(args);

        File x = new File("polynomial.txt"); //This is used to input the movies text

        if (x.exists()) {

            // System.out.print("Helloooooooooo");
            Scanner input = new Scanner(x);// Scanning
            // System.out.println("fvjfdvd  "+input.nextLine());

            do{

                // System.out.println("I CAN SEE THE FILE");
                int i = 0;

                String line = input.nextLine(); // This is used to get to the next line and trim thm from the sides
                String[] tokens = line.split("(?=[x])");
                
                    String[] temp = tokens[1].split("(?=[+-])");
                    
                    String[] tmp = temp[0].split("x");
                    // System.out.println("fvjfdvd  "+input.nextLine());
                    System.out.println("polynomial :" + line + "\ncoo is " + tokens[i] + "\nlast is " + temp[i] + "\nexpo " + tmp[1]);
                  
                }while (input.hasNext()) ;
            }
        }
    }

