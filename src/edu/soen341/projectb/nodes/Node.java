//Node class which represents a basic node structure with fields and behaviour
package edu.soen341.projectb.nodes;


import edu.soen341.projectb.assembler.Tokens;

public class Node{
	//Constructor that sets the node to its object argument

	//private Tokens token;
	//private String keyword;
	private Object obj;
	private Node next;



	public Node(Object o){
		this.obj = o;
		//this.token = t;
		//this.keyword = s;
	}
	//Setters for node fields
	public void setNext(Node node){
		this.next = node;
	}

	/*
	public void setToken(Tokens t){
		this.token = t;
	}

	public void setKeyword(String s){
		this.keyword = s;
	}


	 */
	/**
		 * Used in AUnit testing
		 * @return Object
		 */

	//Getters for node fields


	/*

	public Tokens getToken(){
		
		return this.token;
	}

	public String getKeyword(){
		return this.keyword;
	}


	 */
	public Node getNext(){
		return this.next;
	}

	public Object getObject(){
		return this.obj;
	}
	//Node attributes
	private Tokens token;
	private String keyword;
	private Node next;
	private Object obj;

}
