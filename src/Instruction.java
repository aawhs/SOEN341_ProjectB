public class Instruction implements Opcode {

    public String mnemonic = "";
    public int opCode;

    public Instruction(String inst){getInstruction(inst);}
/*
    public Instruction(Opcode opcde, Operand oprnd){
        this.mnemonic = opcde;
        this.operand = oprnd;
    }
*/
    public Instruction(){}

    public void getInstruction(String inst){
      for(int i = 0; i<inherentMnemonics.length; i++){
          if(inherentMnemonics[i].contains(inst)){
              this.mnemonic = inherentMnemonics[i];
              this.opCode = inherentOpcodes[i];
              break;
          }
      }
    }

    public void parseMnemonic(String inst){
        getInstruction(inst);
    }


    public String printInstruction(){
        String inst = String.format("\n0x%02X",opCode) + " " + mnemonic;
        return inst;
    }

    /**
     * Used in AUnit testing
     * @return mnemonic
     */
    public String getMnemonic() {return mnemonic;}
}

