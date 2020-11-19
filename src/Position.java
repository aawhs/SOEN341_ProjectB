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


    private int colPos;
    private int linePos;
}
