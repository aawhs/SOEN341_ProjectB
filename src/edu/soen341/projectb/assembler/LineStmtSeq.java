package edu.soen341.projectb.assembler;
import edu.soen341.projectb.nodes.LinkedQueue;
import edu.soen341.projectb.nodes.Node;
    //Class with the needed methods to hold a sequence of LineStmt objects for the Lexer
public class LineStmtSeq{
    //Necessary method needed in relation to Sequences of LineStmt Objects
    public void add(LineStmt item){
        Node node = new Node(item);
        sequence.add(node);
    }
    //Necessary method needed in relation to Sequences of LineStmt Objects
    public LineStmt pop(){
        return (LineStmt) sequence.pop().getObject();
    }
    //Necessary Data Members for the LineStmtSeq Class
    private LinkedQueue sequence = new LinkedQueue();
}
