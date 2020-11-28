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
    public String getComment() {return comment;}

}
