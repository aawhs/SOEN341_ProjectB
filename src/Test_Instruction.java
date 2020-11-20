public class Test_Instruction {
    public static void main(String[] args){
        Instruction instruction = new Instruction();
        System.out.print("Test Instruction\n");
        System.out.print(String.format("0x01 pop"));

        instruction.parseMnemonic("pop");
        instruction.printInstruction();
    }
}
