import java.io.*;
import java.util.*;

/*
File: Evaluation.java
Description: Evaluates an arithmetic expression

 */


class Evaluation {

    private static Stack<Node> expressionStack = new Stack<>();
    private static Node operator;




    static String evaluate(String expression) throws IOException{
        String[] tokens = expression.split(" ");

        for(String token : tokens){
            String operandSplit = "[\\d.?]+";
            String operatorSplit = "[*/+\\-]";



            if(token.matches(operandSplit)){
                expressionStack.push(new OperandNode(token));
            } else if(token.matches(operatorSplit)){
                operator = new OperatorNode(token, expressionStack.pop(),expressionStack.pop());
                expressionStack.push(operator);
            }
           }

        operator.post();

        return expressionStack.pop().inOrderWalk();

    }



}
