package edu.soen341.projectb.assembler;

import edu.soen341.projectb.nodes.Node;

public class ScannedObject{
    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Tokens getToken() {
        return token;
    }

    public void setToken(Tokens token) {
        this.token = token;
    }

    private String keyword;
    private Tokens token;

    public ScannedObject(String keyword, Tokens token) {
        this.keyword = keyword;
        this.token = token;
    }
}
