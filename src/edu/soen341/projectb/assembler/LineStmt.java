package edu.soen341.projectb.assembler;
    //The LineStmt class is intended to hold the different objects related to a Line Statement
public class LineStmt {
    //Paramaterized Constructor for the LineStmt Class
    public LineStmt(Label l, Instruction i, Comment c){
        this.label = l;
        this.instruction = i;
        this.comment = c;
    }
    //Specific Method Designed to output the LineStmt in a Printable Format
    public void print(){
        System.out.println(label.getLabel() + " " + instruction.getOpCode() + " " +
                instruction.getMnemonic() + " " + instruction.getOperand() + " " + comment.getComment());
    }
    //Custom Method to Verify if the LineStmt Object is Empty
    public boolean isEmpty(){

        return (label == null) &&
                (instruction == null) &&
                (comment == null);
    }
    //Basic Getter method in relation to LineStmt Class
    public Label getLabel(){
        return this.label;
    }
    //Basic Getter method in relation to LineStmt Class
    public Instruction getInstruction(){
        return this.instruction;
    }
    //Basic Getter method in relation to LineStmt Class
    public Comment getComment(){
        return this.comment;
    }
    //Necessary Data Members for the LineStmt Class
    Label label;
    Instruction instruction;
    Comment comment;
    private char EOL = '\n';
}
