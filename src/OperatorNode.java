//package Project 2;
import java.io.*;

/*
File: OperatorNode.java
Description: Implements Node. Creates OperatorNodes for tree. OperandNodes assigned as children nodes.
and prints tree in postorder format.
 */

public class OperatorNode implements Node{
    private String operator;
    private Node left, right;
    private static int i;
    private File file = new File("3 Address.txt");

    public OperatorNode(String operator, Node left, Node right){
        this.operator = operator;
        this.left = left;
        this.right = right;

        opEval(operator); //will create method to assign different operators
    }

    /*
    public double evaluate(){
        double leftValue = left.evaluate();
        double rightValue = right.evaluate();
        return operator.evaluate(leftValue, rightValue);
    }*/

    //for infix expression
    public String inOrderWalk(){
        return "(" + left.inOrderWalk() + " " + operator + " " + right.inOrderWalk() + ")";
    }

    public void post() throws IOException{
        i = 0;
        postOrderWalk();
    }


    //method performs post order walk of tree
    //each line is given name of operator and additional values of children nodes
    //results written to file

    public String postOrderWalk() throws IOException{
        String leftValue = left.postOrderWalk();
        String rightValue = right.postOrderWalk();
        String opValue = opEval(this.operator);
        String print = "R" + i++;
        //return leftValue + " " + rightValue + " " + operator;

        String line = opValue + " " + print + " " + leftValue + " " + rightValue;
        writeToFile(line);
        return line;
    }


    private String opEval(String operator){

        String op = "";

        switch(operator){
            case "+":
                op = "Add";
                break;
            case "-":
                op = "Sub";
                break;
            case "*":
                op = "Mul";
                break;
            case "/":
                op = "Div";
                break;
        }
        return op;
    }

//Writes to file 3 Address.txt

    private void writeToFile(String line) throws IOException{
        BufferedWriter bw = new BufferedWriter(new FileWriter(file,true));
        bw.write(line);
        bw.newLine();
        bw.close();
    }

}