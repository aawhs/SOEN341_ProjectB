public class LineStmtSeq{
    private Linked sequence = new Linked();
    public void add(LineStmt item){
        Node node = new Node(item);
        sequence.add(node);
    }
    public LineStmt pop(){
        return sequence.pop().getLineStmt();
    }
}
