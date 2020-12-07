//Position class which monitors the position of elements in the assembly test files
package edu.soen341.projectb.helper;

public class Position {
    //Constructor that sets the positions for the element
    public Position(int linePos, int colPos){
        this.linePos = linePos;
        this.colPos = colPos;
    }
    // Returns string representation of position
    public String toString(){
        return "(" + colPos + "," + linePos + ")";
    }
    //getters for lines and columns
    public int getLinePos() {
        return linePos;
    }

    public int getColPos() {
        return colPos;
    }

    //Variables for lines and columns
    private Integer colPos;
    private Integer linePos;
}
