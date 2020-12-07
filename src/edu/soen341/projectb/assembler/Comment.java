package edu.soen341.projectb.assembler;
    //The Comment class is intended to create and hold Comment Objects based on the Tokens Acquired by the Lexer
public class Comment {
    //Standard paramaterized constructor
    public Comment(String c){
        this.comment = parseComment(c);
    }
    //Parse method in relation to Parser Class for handling Comment Objects being parsed
    public String parseComment(String c){
        boolean cmt = false;
        String str = "";
        for(int i = 0; i < c.length(); i++){
            if(cmt == true){
                str = str + c.charAt(i);
            }
            if(c.charAt(i) == commentStart){
                cmt = true;
            }
            if(c.charAt(i) == EOL){
                return str;
            }
        }
        return str;
    }
    //Basic Getter method in relation to Comments Object
    public String getComment() {
        return comment;
    }
    //Necessary Data Members needed in relation to comments
    private static char commentStart = ';';
    private static char EOL = '\n';
    String comment;
}
