package edu.soen341.projectb.nodes;

import edu.soen341.projectb.assembler.LineStmt;

public class Node{
	private LineStmt lineStatement;
	private Node next;

	public Node(LineStmt lineStatement){
		this.lineStatement = lineStatement;
		this.next = null;
	}

	public void setNext(Node node){
		this.next = node;
	}

	public void setLineStmt(LineStmt line){
		this.lineStatement = line;
	}

	public LineStmt getLineStmt(){
		return this.lineStatement;
	}

	public Node getNext(){
		return this.next;
	}

	/**
	 * Used in AUnit testing
	 * @return lineStatement
	 */
	public LineStmt getLineStatement(){return lineStatement;}
}