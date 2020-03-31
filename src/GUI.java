

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

/*
Developer: Devin Norwood
Class: CMSC 350
File: GUI.java
Description: GUI interface which converts a postfix expression to infix expression
*/


public class GUI extends JFrame {

    //variables for the GUI
    private String exp;
    private JTextField calcInput;
    private JLabel inputLabel;
    private JButton evaluate;
    private JLabel result;
    private JTextField calcOutput;

    private Evaluation eval = new Evaluation();


    //Constructor for the GUI
    GUI() {
        super("Three Address Generator");
        JPanel p1 = new JPanel();
        setLayout(new FlowLayout());

        inputLabel = new JLabel("Enter Postfix Expression:");
        add(inputLabel);

        calcInput = new JTextField(null, 20);
        add(calcInput);

        evaluate = new JButton("Construct Tree");
       add(evaluate);

        result = new JLabel("Infix Expression");
        add(result);

        calcOutput = new JTextField(null,20);
        add(calcOutput);
        calcOutput.setEditable(false);

//Button Handler for Evaluate
        evaluate.addActionListener((ActionEvent e) ->{
            exp = calcInput.getText();

            try{
                if(exp.isEmpty()){
                    throw new NullPointerException();
                } else{
                    calcOutput.setText(Evaluation.evaluate(exp));
                }
            }//end try block
            catch(NullPointerException e1){
                JOptionPane.showMessageDialog(null,"Please enter expression.","Error",JOptionPane.ERROR_MESSAGE);
            }//end e1 catch
            catch(IOException e2){
                JOptionPane.showMessageDialog(null,"Error Writing to File.","Error",JOptionPane.ERROR_MESSAGE);
            }});


        }//end Action Listener


        public static void main (String[]args){

            GUI calc = new GUI();
            calc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            calc.setSize(400, 300);
            calc.setVisible(true);

        }//end main method

    }//end GUI class





