package edu.soen341.projectb.nodes;


import edu.soen341.projectb.assembler.Tokens;

public class Node{
	//private Tokens token;
	//private String keyword;
	private Object obj;
	private Node next;


	public Node(Object o){
		this.obj = o;
		//this.token = t;
		//this.keyword = s;
	}

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


}
