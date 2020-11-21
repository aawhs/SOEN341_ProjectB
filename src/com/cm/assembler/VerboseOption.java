package com.cm.assembler;

class VerboseOption extends Option {
    public VerboseOption() {
        super(new String[]{"-v"}, "-verbose");
        setEnable(true);
        process();
    }


    @Override
    public void process() {
        setReq(true);
        
    }
}
