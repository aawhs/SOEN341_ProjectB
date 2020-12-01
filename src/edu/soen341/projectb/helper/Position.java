package edu.soen341.projectb.helper;

public class Position {
    public Position(int linePos, int colPos){
        this.linePos = linePos;
        this.colPos = colPos;
    }


    public int getLinePos() {
        return linePos;
    }

    public int getColPos() {
        return colPos;
    }
    public String toString(){
        return "(" + colPos + "," + linePos + ")";
    }


    private Integer colPos;
    private Integer linePos;
}
