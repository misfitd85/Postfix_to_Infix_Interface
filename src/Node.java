//package Project 2;
import java.io.IOException;


/*
File: Node.java
Description: Node interface class for OperandNodes and OperatorNodes for Expression Tree
 */
public interface Node {

    //public double evaluate();
    String inOrderWalk();
    String postOrderWalk() throws IOException;
    void post() throws IOException;
}



