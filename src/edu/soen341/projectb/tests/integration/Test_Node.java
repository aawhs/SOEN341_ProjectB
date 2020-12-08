package edu.soen341.projectb.tests.integration;

import edu.soen341.projectb.assembler.Comment;
import edu.soen341.projectb.assembler.Instruction;
import edu.soen341.projectb.assembler.Label;
import edu.soen341.projectb.assembler.LineStmt;
import edu.soen341.projectb.nodes.Node;

import javax.sound.sampled.Line;

/**
 * Integration testing Label, Instruction, Comment, LineStmt and Node classes
 */
public class Test_Node {
    public static void main(String[] args){
        System.out.print("Test Node\n");
        System.out.print(String.format("01 Hello  pop      THIS IS A COMMENT"));

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
        /*System.out.println( '\n' + node.getObject().getLabel().getIdentifier() + ", " +
                            node.getObject().getInstruction().getMnemonic() + ", " +
                            node.getObject().getComment().getComment());*/
        System.out.println();
        LineStmt lineStmt1 = (LineStmt) node.getObject();
        lineStmt1.print();

    }
}
