/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polynomialsumgui;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;

/**
 *
 * @author ayah
 */
public class FXMLDocumentController implements Initializable {

    Scan s = new Scan();

    LinkedList[] l = s.pass();

    @FXML
    private Pane pane;
    @FXML
    private Label label0;
    @FXML
    private Label label1;
    @FXML
    private Label label2;
    @FXML
    private TextArea txt;
    @FXML
    private Label label;
    @FXML
    private Button sumBtn;
    @FXML
    private Button multiBtn;
    @FXML
    private Button sunBtn;
    @FXML
    private Label SumLabel;
    @FXML
    private Label multiLabel;
    @FXML
    private Label subLabel;

    @FXML
    private void handleButtonAction(ActionEvent event)  {
        String l;
        
        File x = new File("polynomial.txt"); //This is used to input the movies text
       
        if (x.exists()) {//checks of the file exist

            Scanner input = null;//initilalize input scanner
            try {
                input = new Scanner(x); // Scanning

            } catch (FileNotFoundException ex) {
                System.out.println("noooooo data!!!!!!!!!!!");//handle
            }

            while (input.hasNext()) //checks if the file has nextLine
            {
                l = input.nextLine(); // This is used to get to the next line and trim thm from the sides
                txt.setText(l);
                
            }
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
    }

    @FXML
    private void handleButtonActionSum(ActionEvent event) {
        LinkedList sum = new LinkedList();
        sum = l[0];
        for (int i = 1; i < l.length; i++) {

            sum = s.getSum(l[i], sum);

            // sum = saddPol(sum,l[i]);
        }
        label1.setText(sum.toString());
        //ans.setText("Answer is : "+s.ans(sum));


    }

    @FXML
    private void handleButtonActionSub(ActionEvent event) {

        LinkedList sub = new LinkedList();
        sub = l[0];
        for (int i = 1; i < l.length; i++) {
            sub = s.getSub(l[i], sub);
        }
        label2.setText(sub.toString());
       // ans.setText("Answer is : "+s.ans(sub));

    }

    @FXML
    private void handleButtonActionMulti(ActionEvent event) {

        LinkedList multi = new LinkedList();
        multi = l[0];
        for (int i = 1; i < l.length; i++) {
            multi = s.getMulti(l[i], multi);
        }
        label0.setText(multi.toString());
        //ans.setText("Answer is : "+s.ans(multi));

    }

  
  public String getLine() {//get file's data
        String l = null;

        File x = new File("polynomial.txt"); //This is used to input the movies text
       
        if (x.exists()) {//checks of the file exist

            Scanner input = null;//initilalize input scanner
            try {
                input = new Scanner(x); // Scanning

            } catch (FileNotFoundException ex) {
                System.out.println("noooooo data!!!!!!!!!!!");//handle
            }

            while (input.hasNext()) //checks if the file has nextLine
            {
                l = input.nextLine(); // This is used to get to the next line and trim thm from the sides
                
            }
        }
        return l;
    }

    @FXML
    private void handleButtonActionsumResult(ActionEvent event) {
             LinkedList sum = new LinkedList();
        sum = l[0];
        for (int i = 1; i < l.length; i++) {

            sum = s.getSum(l[i], sum);

            // sum = saddPol(sum,l[i]);
        }
        SumLabel.setText(""+ s.ans(sum));
        
        //ans.setText("Answer is : "+s.ans(sum));
        
    }

    @FXML
    private void handleButtonActionMultiRes(ActionEvent event) {
         LinkedList multi = new LinkedList();
        multi = l[0];
        for (int i = 1; i < l.length; i++) {
            multi = s.getMulti(l[i], multi);
        }
        multiLabel.setText(""+s.ans(multi));
        //ans.setText("Answer is : "+s.ans(multi));
    }

    @FXML
    private void handleButtonActionSubRes(ActionEvent event) {
        
        LinkedList sub = new LinkedList();
        sub = l[0];
        for (int i = 1; i < l.length; i++) {
            sub = s.getSub(l[i], sub);
        }
        subLabel.setText(""+s.ans(sub));
       // ans.setText("Answer is : "+s.ans(sub));
    }
   

}
