//Implementation for no option choice
package edu.soen341.projectb.options;

import java.io.File;

class noOption extends Option {
    //Setting option as false by default
    public noOption() {
        super(new String[]{"-e"}, "-empty");
        setEnable(false);
    }
    //**
    @Override
    public void process() {

    }

    @Override
    public void setFiles(File file) {

    }
}