public class Operand {
    Label label;
    int address;
    int offset;

    public Operand(Label l, int a, int o){
        this.label = l;
        this.address = a;
        this.offset = o;
    }
}
