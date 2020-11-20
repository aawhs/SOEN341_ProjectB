import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class main {
    public static void main(String args[]) throws IOException, URISyntaxException {
       IReader reader = new Reader("S1Test1.asm");
       reader.readFile();

       ISymbolTable keywordTable = new SymbolTable();

       SymbolTable st = new SymbolTable();
       Label l= new Label(null);
       Instruction i= new Instruction("tgt");
       Comment c = new Comment("Testing");
       LineStmt stmt = new LineStmt(l,i,c);

       Label l2= new Label(null);
       Instruction i2= new Instruction("pop");
       Comment c2 = new Comment("Testing");
       LineStmt stmt2 = new LineStmt(l2,i2,c2);

       Label l3= new Label(null);
       Instruction i3= new Instruction("exit");
       Comment c3 = new Comment("Testing");
       LineStmt stmt3 = new LineStmt(l3,i3,c3);

       LineStmtSeq seq = new LineStmtSeq();
       seq.add(stmt);
       seq.add(stmt2);
       seq.add(stmt3);


       seq.pop().getInstruction().printInstruction();
       seq.pop().getInstruction().printInstruction();
       seq.pop().getInstruction().printInstruction();
       reader.openFile();
       ILexer lexer = new Lexer(reader, keywordTable);
       keywordTable = lexer.getKeywordTable();

       while(keywordTable.iterator().hasNext()){
          System.out.println(keywordTable.iterator().next().toString());
       }
    }
}
