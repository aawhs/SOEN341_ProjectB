package com.cm.assembler;

public class Test_Node {
    public static void main(String[] args){
        System.out.print("Test Node\n");
        System.out.print(String.format("Hello, pop, This is a comment"));

        /**
         * Prepare label, instruction and comment for LineStmt object to be passed into Node
         */
        Label label = new Label("Hello");
        Instruction instruction = new Instruction("pop");
        Comment comment = new Comment("sdsds ;This is a comment");
        LineStmt lineStmt = new LineStmt(label, instruction, comment);
        Node node = new Node(lineStmt);

        /**
         * Print the Node's label, instruction and comment
         */
        System.out.println( '\n' + node.getLineStmt().label.getIdentifier() + ", " +
                            node.getLineStmt().instruction.getMnemonic() + ", " +
                            node.getLineStmt().comment.getComment());
    }
}
