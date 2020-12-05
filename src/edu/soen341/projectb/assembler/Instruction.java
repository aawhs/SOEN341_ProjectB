package edu.soen341.projectb.assembler;

import edu.soen341.projectb.assembler.Operand;

public class Instruction implements Opcode {
    //public String [] Ioperands = new String [] {"i3","u3","i4","u4","i5","u5"};
    //public String [] Roperands = new String [] {"i8","u8","i16","u16","i32","u32"};
    public String mnemonic = "";
    public int opCode;
    public Operand operand;
    //public String mnemonicType = "";
    //public String operands = "";

    public Instruction(String inst){setInstruction(inst);}

    public Instruction(Opcode opcode, Operand operand){
        this.operand = operand;
    }

    public Instruction(){}

    public void setInstruction(String inst){
        for(int i = 0; i< Opcode.inherentMnemonics.length; i++){
            if(Opcode.inherentMnemonics[i].contains(inst)){
                this.mnemonic = Opcode.inherentMnemonics[i];
                this.opCode = Opcode.inherentOpcodes[i];
            }
        }
        for(int i = 0; i< Opcode.immediateMnemonics.length; i++) {
            if (Opcode.immediateMnemonics[i].contains(inst)) {
                this.mnemonic = Opcode.immediateMnemonics[i];
                this.opCode = Opcode.immediateOpcodes[i];
            }
        }
        for(int i = 0; i< Opcode.relativeMnemomnics.length; i++) {
            if (Opcode.relativeMnemomnics[i].contains(inst)) {
                this.mnemonic = Opcode.relativeMnemomnics[i];
                this.opCode = Opcode.relativeOpcodes[i];
                break;
            }
        }
    }

    public void parseMnemonic(String inst){
        String mnemonic_temp = "";
        for (int i = 0; i < inst.length(); i++){
            if(inst.charAt(i) == ' ' || inst.charAt(i) == '.'){break;}
            mnemonic_temp += inst.charAt(i);
        }
        setInstruction(mnemonic_temp);
    }

    public String[] printInstruction(){
        String[] inst = new String[2];
        inst[0]= String.format("%02d",opCode);
        inst[1]=mnemonic;
        return inst;
    }

    /**
     * Used in AUnit testing
     * @return mnemonic
     */
    public String getMnemonic() {return mnemonic;}
}

