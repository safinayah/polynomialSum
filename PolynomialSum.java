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
public class PolynomialSum {

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

            while (input.hasNext()) {

                // System.out.println("I CAN SEE THE FILE");
                int i = 0;

                String line = input.nextLine(); // This is used to get to the next line and trim thm from the sides
                String[] terms = line.split("(-|\\+)");
                for (String term : terms) {
                    String[] parts = term.split("\\^");
                    System.out.println("Exponent: " + (parts.length > 1 ? parts[0] : parts[0]));
                }
            }

        }
    }
}
