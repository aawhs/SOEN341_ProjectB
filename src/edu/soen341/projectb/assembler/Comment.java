package edu.soen341.projectb.assembler;

public class Comment {

    private static char commentStart = ';';
    private static char EOL = '\n';
    String comment;

    public Comment(String c){
        this.comment = parseComment(c);
    }
    /**
     * Used in AUnit testing
     * @return comment
     */


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
    public String getComment() {return comment;}

}
