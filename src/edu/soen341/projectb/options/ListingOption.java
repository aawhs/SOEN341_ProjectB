package edu.soen341.projectb.options;

import java.io.File;
import java.io.IOException;

class ListingOption extends Option {
    public ListingOption() throws IOException {
        super(new String[]{"-l"},"-listing");
        setEnable(true);
        process();
    }

    @Override
    public void process() throws IOException {
        
        file = super.getFile();
        //FileWriter fr = new FileWriter(file);
        /*System.out.println("Listing File : " + file.getAbsolutePath());
                fr.write(String.format("%1s%10s%15s%10s%20s%20s\n",
                        "Line", "Address", "Machine Code", "Label", "Assembly Code", "Comment") + "\n");

         */
        setReq(true);
       
    }

    @Override
    public void setFiles(File file) {

    }

}
