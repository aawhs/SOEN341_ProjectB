import java.util.ArrayList;

public class _Error {
    _Error(String t, Position pos){
        this.text = t;
        this.pos = pos;
    }
    static _Error create(String t, Position position){
        _Error e = new _Error(t, position);
        addError(e);
        return e;
    }

    static ArrayList<_Error> list_of_errors = new ArrayList<>();

    static void addError(_Error error){
        list_of_errors.add(error);
    }

    void printErrors(){
        for(int i = 0; i < list_of_errors.size(); i++){
            System.out.println(list_of_errors.get(i).text + " " + list_of_errors.get(i).pos.toString());

        }
    }

    private String text;
    private Position pos;
}
