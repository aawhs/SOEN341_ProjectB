package edu.soen341.projectb.options;

import java.io.File;

class VerboseOption extends Option {
    public VerboseOption() {
        super(new String[]{"-v"}, "-verbose");
        setEnable(true);
        process();
    }


    @Override
    public void process() {
        
            System.out.print(String.format("%1s%10s%15s%10s%20s%20s\n",
                    "Line", "Address", "Machine Code", "Label", "Assembly Code", "Comment") + "\n");
        
        setReq(true);
        
    }

    @Override
    public void setFiles(File file) {

    }
}
