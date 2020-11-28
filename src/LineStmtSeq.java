public class LineStmtSeq{
    private LinkedQueue sequence = new LinkedQueue();
    public void add(LineStmt item){
        Node node = new Node(item);
        sequence.add(node);
    }
    public LineStmt pop(){
        return sequence.pop().getLineStmt();
    }

    public LinkedQueue getSequence(){
        return sequence;
    }
}
