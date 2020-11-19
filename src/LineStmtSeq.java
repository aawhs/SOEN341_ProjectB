import java.util.Iterator;

public class LineStmtSeq{
    private LinkedQueue sequence= new LinkedQueue();
    public void add(LineStmt item){
        sequence.add(item);
    }
    public LineStmt getNext(){
        return (LineStmt) sequence.getNext();
    }
}
