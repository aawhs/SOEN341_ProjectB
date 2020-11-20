public class _Error {
    _Error(String t, Position pos){
        this.text = t;
        this.pos = pos;
    }
    static _Error create(String t, Position position){
        _Error e = new _Error(t, position);
        return e;
    }
    
    private String text;
    private Position pos;
}
