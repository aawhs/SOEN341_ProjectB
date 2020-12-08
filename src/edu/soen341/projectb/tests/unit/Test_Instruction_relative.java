package edu.soen341.projectb.tests.unit;

import edu.soen341.projectb.assembler.Instruction;

public class Test_Instruction_relative {
    public static void main(String[] args){
        Instruction instruction = new Instruction();
        System.out.print("Test relative instruction\n");
        System.out.print(String.format("0x176 addv.u8"));

        instruction.setInstruction("addv.u8");
        System.out.println("\n0x" + instruction.printInstruction()[0] + " " +
                instruction.printInstruction()[1]);
    }
}
