package edu.soen341.projectb.assembler;

public class LineStmt {
    Label label;
    Instruction instruction;
    Comment comment;
    private char EOL = '\n';

    public LineStmt(Label l, Instruction i, Comment c){
        this.label = l;
        this.instruction = i;
        this.comment = c;
    }

    public Label getLabel(){
        return this.label;
    }

    public Instruction getInstruction(){
        return this.instruction;
    }

    public Comment getComment(){
        return this.comment;
    }

    public boolean isEmpty(){

        return (label == null) &&
                (instruction == null) &&
                (comment == null);
    }

    public void print(){
        System.out.println(label.getLabel() + " " + instruction.getOpCode() + " " +
                instruction.getMnemonic() + " " + instruction.getOperand() + " " + comment.getComment());
    }
}
