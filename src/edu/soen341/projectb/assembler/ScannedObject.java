package edu.soen341.projectb.assembler;
import edu.soen341.projectb.nodes.Node;
    //The ScannedObject class is designed to Create new identifiable objects that relate to objects already scanned by the lexer
public class ScannedObject{
    //Paramaterized Constructor for the ScannedObject Class
    public ScannedObject(String keyword, Tokens token) {
        this.keyword = keyword;
        this.token = token;
    }
    //Basic Setter method in relation to ScannedObject Class
    public void setToken(Tokens token) {
        this.token = token;
    }
    //Basic Setter method in relation to ScannedObject Class
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
    //Basic Getter method in relation to ScannedObject Class
    public Tokens getToken() {
        return token;
    }
    //Basic Getter method in relation to ScannedObject Class
    public String getKeyword() {
        return keyword;
    }
    //Necessary Data Members for the ScannedObject Class
    private String keyword;
    private Tokens token;
}
