package edu.soen341.projectb.tests;

import edu.soen341.projectb.assembler.Comment;
import edu.soen341.projectb.assembler.Instruction;
import edu.soen341.projectb.assembler.Label;
import edu.soen341.projectb.assembler.LineStmt;
import edu.soen341.projectb.nodes.Node;

import javax.sound.sampled.Line;

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
        System.out.println( '\n' + node.getLineStmt().getLabel().getIdentifier() + ", " +
                            node.getLineStmt().getInstruction().getMnemonic() + ", " +
                            node.getLineStmt().getComment().getComment());
    }
}
