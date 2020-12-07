package edu.soen341.projectb.assembler;

public class LineStmt {
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
        /*
        System.out.println("Label : " + label.getLabel() + " Op Code : " + instruction.getOpCode() + " Mnemonic : " +
                instruction.getMnemonic() + " Operand : " + instruction.getOperand() + " Comment : " + comment.getComment());

         */

        if(directive != null){
            System.out.print(String.format("           %02X              %4s         %4s%4S                 %4S",
                    directive.getOpcode(), label.getLabel(), directive.getDirective(),
                    directive.getStringOperand(), comment.getComment()) + "\n");
        }else{
            System.out.print(String.format("           %02X              %4s         %4s%4S                 %4S",
                    instruction.getOpCode(), label.getLabel(), instruction.getMnemonic(),
                    instruction.getOperand(), comment.getComment()) + "\n");
        }
    }
}
