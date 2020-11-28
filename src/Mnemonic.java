public abstract class Mnemonic {
    public void setMnemonic(String mnemonic) {
        this.mnemonic = mnemonic;
    }

    public int getOpcode() {
        return opcode;
    }

    public void setOpcode(int opcode) {
        this.opcode = opcode;
    }

    public String mnemonic;
    public int opcode;

    abstract void getMnemonic();
}
