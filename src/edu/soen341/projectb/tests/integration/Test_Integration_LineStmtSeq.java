package edu.soen341.projectb.tests.integration;

import edu.soen341.projectb.assembler.*;


/**
 * Integration testing Label, Instruction, Comment, LineStmt and LineStmtSeq classes
 */
public class Test_Integration_LineStmtSeq {

    public static void main(String[] args){
        System.out.print("Test LineStmtSeq\n");
        System.out.println(String.format("01 Hello  pop      THIS IS A COMMENT"));
        System.out.println(String.format("13 Hello2  add      THIS IS A COMMENT 2"));

        /**
         * Initialize lineStmtSeq for integration testing
         */
        LineStmtSeq lineStmtSeq = new LineStmtSeq();

        /**
         * Prepare labels, instructions and comments for LineStmt objects to be passed into Nodes
         * and then into lineStmtSeq
         */
        Label label = new Label("Hello");
        Instruction instruction = new Instruction("pop");
        Comment comment = new Comment("sdsds ;This is a comment");
        LineStmt lineStmt = new LineStmt(label, instruction, comment);

        Label label2 = new Label("Hello2");
        Instruction instruction2 = new Instruction("add");
        Comment comment2 = new Comment("sdsds ;This is a comment 2");
        LineStmt lineStmt2 = new LineStmt(label2, instruction2, comment2);

        /**
         * Add line statements to lineStmtSeq
         */
        lineStmtSeq.add(lineStmt);
        lineStmtSeq.add(lineStmt2);

        /**
         * Print the line statements from the sequence
         */
        System.out.println();
        lineStmtSeq.pop().print();
        lineStmtSeq.pop().print();
    }
}
