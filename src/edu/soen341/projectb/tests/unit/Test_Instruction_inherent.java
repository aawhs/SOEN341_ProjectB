package edu.soen341.projectb.tests.unit;

import edu.soen341.projectb.assembler.Instruction;

public class Test_Instruction_inherent {
    public static void main(String[] args){
        Instruction instruction = new Instruction();
        System.out.print("Test inherent instruction\n");
        System.out.print(String.format("0x01 pop"));

        instruction.setInstruction("pop");
        System.out.println("\n0x" + instruction.printInstruction()[0] + " " +
                instruction.printInstruction()[1]);
    }
}
