/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polynomialsumgui;

import java.util.Scanner;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author ayah
 */
public class PolynomialSumGUI extends Application {

    public static void out() {
        Scan s = new Scan();
        LinkedList finalList=new LinkedList();
        LinkedList[] l = s.pass();

        Scanner sc = new Scanner(System.in);

        LinkedList sum = new LinkedList();
        sum = l[0];
        for (int i = 1; i < l.length; i++) {

            sum = s.getSum(l[i], sum);
            finalList = sum;
                    System.out.println("sum ans is: "+s.ans(finalList));


            // sum = saddPol(sum,l[i]);
        }
        LinkedList sub = new LinkedList();
        sub = l[0];
        for (int i = 1; i < l.length; i++) {
            sub = s.getSub(l[i], sub);
            finalList = sub;
            System.out.println("sub Ans is : "+s.ans(finalList));

        }

        LinkedList multi = new LinkedList();
        multi = l[0];
        for (int i = 1; i < l.length; i++) {
            multi = s.getMulti(l[i], multi);
            finalList = multi;
            System.out.println("multi ans"+s.ans(finalList));
        }
        System.out.println("Summation\n-----------------------------");
        System.out.println(sum.toString());
        System.out.println("Subtraction\n-----------------------------");
        System.out.println(sub.toString());
        System.out.println("Mutliplication\n-----------------------------");
        System.out.println(multi.toString());
        System.out.println("Answer\n-----------------------------");

        //s.pass();
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        out();

    }

}
