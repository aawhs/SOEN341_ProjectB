package edu.soen341.projectb.assembler;

public class Instruction implements Opcode {

    public String mnemonic = "";
    public int opCode;
    public Operand operand;

    public Instruction(String inst){getInstruction(inst);}

    public Instruction(Opcode opcode, Operand opernd){
        this.operand = operand;
    }

    public Instruction(){}

    public void getInstruction(String inst){
      for(int i = 0; i< Opcode.inherentMnemonics.length; i++){
          if(Opcode.inherentMnemonics[i].contains(inst)){
              this.mnemonic = Opcode.inherentMnemonics[i];
              this.opCode = Opcode.inherentOpcodes[i];
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
        getInstruction(mnemonic_temp);
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
