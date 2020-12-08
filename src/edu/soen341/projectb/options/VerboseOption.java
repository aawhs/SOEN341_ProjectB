//Verbose option implementation
package edu.soen341.projectb.options;

import java.io.File;

class VerboseOption extends Option {
    //Set verbose option and enable it
    public VerboseOption() {
        super(new String[]{"-v"}, "-verbose");
        setEnable(true);
        process();
    }

    // Return verbose option statement with right format
    @Override
    public void process() {
        
            System.out.print(String.format("%1s%10s%15s%10s%20s%20s\n",
                    "Line", "Address", "Machine Code", "Label", "Assembly Code", "Comment") + "\n");
        
        setReq(true);
        
    }
    //**
    @Override
    public void setFiles(File file) {

    }
}
