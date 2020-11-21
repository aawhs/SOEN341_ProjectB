package com.cm.assembler;

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

    private Label getLabel(){
        return this.label;
    }

    public Instruction getInstruction(){
        return this.instruction;
    }

    private Comment getComment(){
        return this.comment;
    }

    private boolean isEmpty(){

        return (label == null) &&
                (instruction == null) &&
                (comment == null);
    }
}
