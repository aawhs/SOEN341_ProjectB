package edu.soen341.projectb.options;

import java.io.File;

class noOption extends Option {

    public noOption() {
        super(new String[]{"-e"}, "-empty");
        setEnable(false);
    }

    @Override
    public void process() {

    }

    @Override
    public void setFiles(File file) {

    }
}