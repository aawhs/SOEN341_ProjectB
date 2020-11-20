public class Test_Error {
    public static void main(String[] args){
        System.out.print("_Error test\n");
        System.out.print(String.format("This is a test error at position: 1, 1"));


        Position position = new Position(1,1);
        _Error.create("This is a test error: ", position);
        _Error.printErrors();
    }
}
