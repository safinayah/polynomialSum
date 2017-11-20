/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polynomialsumgui;

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

    LinkedList s;
    LinkedList[] arr;
    LinkedList finalList;
    String line;

    public Scan() {
    }//no args constructor

    public LinkedList[] pass() {//a function reads from file and split the string into coefficients and exponents

        String coe[] = null;
        String expo[] = null;

        File x = new File("polynomial.txt"); //This is used to input the movies text

        int lineNum = this.numOfLines();
        int i = 0;
        arr = new LinkedList[lineNum];
        if (x.exists()) {//checks of the file exist

            Scanner input = null;//initilalize input scanner
            try {
                input = new Scanner(x); // Scanning

            } catch (FileNotFoundException ex) {
                System.out.println("noooooo data!!!!!!!!!!!");
            }

            while (input.hasNext()) {//checks if the file has nextLine
                s = new LinkedList();
                String line = input.nextLine(); // This is used to get to the next line and trim thm from the sides
                String[] terms;//splits on sum notation
                System.out.println(line);

                terms = line.split("([\\+|-])");
                for (String term : terms) {
                    expo = term.split("\\^");//split on power notation
                    coe = expo[0].split("x");//split on x

                    if (expo.length > 1 && coe.length == 1) {//splits terms with power
                        //System.out.println("exponet: " + expo[1] + "\ncoefficientA is : " + coe[0]);

                        s.add(new Node(Integer.parseInt(expo[1]), Integer.parseInt(coe[0])));
                    } else if (expo.length <= 1 && coe.length == 1) {//split linear terms
                        // System.out.println("exponent is 1" + "\ncoefficientB is :" + coe[0]);
                        s.add(new Node(1, Integer.parseInt(coe[0])));

                    }//end if statement
                    else if (coe.length != 1 && expo.length != 1) {
                        s.add(new Node(Integer.parseInt(expo[1]), 1));

                    } else if (coe.length != 1 && expo.length == 1) {
                        // System.out.println("exponent is : 1 \nexponent is : 1");
                        s.add(new Node(1, 1));
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
                line = input.nextLine(); // This is used to get to the next line
                if (line != null) {//checks if the file has data
                    num++;//increments number of lines
                }//end of if statement

            }//end of while loop
            input.close();
        }//end of class

        return num;//returns number of file's lines
    }//end of method

    public LinkedList getSub(LinkedList l1, LinkedList l2) {//same as add except we literally switched the + operator
        LinkedList result = new LinkedList();
        Node l2h = l2.head;//linkedlist1 head
        Node l1h = l1.head;//linkedlist two head
        while (l1h.next != null) {//////while next noe is not null
            l1h = l1h.next;
            result.add(new Node(l1h.expo, l1h.coe));
        }
        while (l2h.next != null) {//checks if next node is not equal null
            l2h = l2h.next;
            result.add(new Node(l2h.expo, l2h.coe));
        }

        Node curr = result.head;//a refrence on the first node on final list "result"
        Node pos = result.head.next;//a refrence on the next node n the final lisr "result"

        while (curr.next != null) {//iterate through the new list and add every term that has the same exponent.
            curr = curr.next;
            pos = curr;
            while (pos.next != null) {
                pos = pos.next;
                if (curr.expo == pos.expo) {
                    curr.coe = curr.coe - pos.coe;
                    pos.expo = 0;//make every term in the polynomial that has been added 0 
                    pos.coe = 0;
                }
                //System.out.println("iteration");
            }
        }

        result.cleanup();

        return result;

    }

    public LinkedList getMulti(LinkedList l1, LinkedList l2) {

        LinkedList result = new LinkedList();
        Node l2h = l2.head;
        Node l1h = l1.head;
        while (l1h.next != null) {
            l1h = l1h.next;
            while (l2h.next != null) {
                l2h = l2h.next;
                result.add(new Node(l2h.expo + l1h.expo, l2h.coe * l1h.coe));
            }
            l2h = l2.head;
        }
        //create  a new linkedlist of the result of multiplying every node with every node

        //add the nodes with the same exponents to simplify
        Node curr = result.head;
        Node pos = result.head.next;

        while (curr.next != null) {//iterate through the new list and add every term that has the same exponent.
            curr = curr.next;
            pos = curr;
            while (pos.next != null) {
                pos = pos.next;
                if (curr.expo == pos.expo) {
                    curr.coe = curr.coe + pos.coe;
                    pos.expo = 0;//make every term in the polynomial that has been added 0 
                    pos.coe = 0;
                }
                //System.out.println("iteration");
            }
        }

        result.cleanup();

        return result;
    }

    public LinkedList getSum(LinkedList l1, LinkedList l2) {
        LinkedList result = new LinkedList();
        Node l2h = l2.head;
        Node l1h = l1.head;
        while (l2h.next != null) {
            l2h = l2h.next;
            result.add(new Node(l2h.expo, l2h.coe));
        }
        while (l1h.next != null) {
            l1h = l1h.next;
            result.add(new Node(l1h.expo, l1h.coe));
        }//Merge the 2 lists

        Node curr = result.head;
        Node pos;

        while (curr.next != null) {//iterate through the new list and add every term that has the same exponent.
            curr = curr.next;
            pos = curr;
            while (pos.next != null) {
                pos = pos.next;
                if (curr.expo == pos.expo) {
                    curr.coe = curr.coe + pos.coe;
                    pos.coe = 0;//make every term in the polynomial that has been added 0 
                    pos.expo = 0;
                }

            }
        }

        result.cleanup();//remove all 0 terms

        return result;
    }

    public double ans(LinkedList finalList) {
        System.out.println("Enter A value!!!");
        Scanner sc= new Scanner(System.in);
        int x= sc.nextInt();
       
            double a = 0;

            Node c = finalList.head.next;

            while (c != null) {

                a += Math.pow(x, c.expo) * c.coe;
                c = c.next;

            }

            return a;

        }
    }//end of scan class
