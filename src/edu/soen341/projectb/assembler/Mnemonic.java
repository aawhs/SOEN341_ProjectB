package edu.soen341.projectb.assembler;

public abstract class Mnemonic {
    public String mnemonic;
    public int opcode;


    public void setMnemonic(String mnemonic) {
        this.mnemonic = mnemonic;
    }

    public int getOpcode() {
        return opcode;
    }

    public void setOpcode(int opcode) {
        this.opcode = opcode;
    }
    
    abstract void getMnemonic();
}
