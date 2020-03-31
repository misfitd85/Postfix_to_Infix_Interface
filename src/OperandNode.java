/*
File: OperandNode.java
Description: Class which implements Node to create OperandNode for Expression Tree
 */

public class OperandNode implements Node{

    //String for value
    private String value;

    OperandNode(String value){
        this.value = value;
    }

    //for infix expression
    public String inOrderWalk(){
        return String.valueOf(value);
    }


   /* public double evaluate(){
        return value;
    }*/

    //for postfix expression
    public String postOrderWalk(){
        return String.valueOf(value);
    }

    public void post(){}

}