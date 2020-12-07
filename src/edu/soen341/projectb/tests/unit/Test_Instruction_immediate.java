package edu.soen341.projectb.tests.unit;

import edu.soen341.projectb.assembler.Instruction;

public class Test_Instruction_immediate {
    public static void main(String[] args){
        Instruction instruction = new Instruction();
        System.out.print("Test immediate instruction\n");
        System.out.print(String.format("0x48 br.15"));

        instruction.setInstruction("br.i5");
        System.out.println("\n0x" + instruction.printInstruction()[0] + " " +
                instruction.printInstruction()[1]);
    }
}
