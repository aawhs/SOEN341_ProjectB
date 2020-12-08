package edu.soen341.projectb.assembler;
    //The LineStmt class is intended to hold the different objects related to a Line Statement
public class LineStmt {

    //Paramaterized Constructor for the LineStmt Class

    Label label;
    Instruction instruction;
    Directive directive;
    Comment comment;
    private char EOL = '\n';

    public LineStmt() {
    }

    public Directive getDirective() {
        return directive;
    }

    public void setDirective(Directive directive) {
        this.directive = directive;
    }

    public LineStmt(Label label, Directive directive, Comment comment) {
        this.label = label;
        this.directive = directive;
        this.comment = comment;
    }


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



    public Comment getComment(){
        return this.comment;
    }

    public boolean isEmpty(){

        return (label == null) &&
                (instruction == null) &&
                (comment == null);
    }

    public void print(){
        /*
        System.out.println("Label : " + label.getLabel() + " Op Code : " + instruction.getOpCode() + " Mnemonic : " +
                instruction.getMnemonic() + " Operand : " + instruction.getOperand() + " Comment : " + comment.getComment());

         */

        if(directive != null){
            System.out.print(String.format("       %02X              %4s         %4s %4S                %4S",
                    directive.getOpcode(), label.getLabel(), directive.getDirective(),
                    directive.getStringOperand(), comment.getComment()) + "\n");
        }else{
            System.out.print(String.format("       %02X              %4s         %4s %4S                %4S",
                    instruction.getOpCode(), label.getLabel(), instruction.getMnemonic(),
                    instruction.getOperand(), comment.getComment()) + "\n");
        }
    }

}
