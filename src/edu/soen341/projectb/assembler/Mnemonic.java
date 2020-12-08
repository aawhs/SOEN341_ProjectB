package edu.soen341.projectb.assembler;
    //Abstract class used for Identifying objects as Mnemonic
public abstract class Mnemonic {
    //Basic Setter method in relation to Mnemonic Class
    public void setMnemonic(String mnemonic) {
        this.mnemonic = mnemonic;
    }
    //Basic Setter method in relation to Mnemonic Class
    public void setOpcode(int opcode) {
        this.opcode = opcode;
    }
    //Basic Getter method in relation to Mnemonic Class
    public int getOpcode() {
        return opcode;
    }
    //Abstract Getter method in relation to Mnemonic Class
    abstract void getMnemonic();
    //Necessary Data Members for the Mnemonic Class
    public String mnemonic;
    public int opcode;
}
