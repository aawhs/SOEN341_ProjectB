package edu.soen341.projectb.assembler;

import edu.soen341.projectb.nodes.LinkedQueue;
import edu.soen341.projectb.nodes.Node;

public class LineStmtSeq{
    private LinkedQueue sequence = new LinkedQueue();
    public void add(LineStmt item){
        Node node = new Node(item);
        sequence.add(node);
    }
    public LineStmt pop(){
        return (LineStmt) sequence.pop().getObject();
    }
}
