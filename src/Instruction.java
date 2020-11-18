public class Instruction {

    Opcode mnemonic;
    Operand operand;

    public Instruction(Opcode opcde, Operand oprnd){
        this.mnemonic = opcde;
        this.operand = oprnd;
    }
}
