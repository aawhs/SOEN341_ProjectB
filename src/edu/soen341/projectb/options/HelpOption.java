package edu.soen341.projectb.options;

import edu.soen341.projectb.options.Option;

import java.io.File;

import static java.lang.System.exit;

class HelpOption extends Option {

    public HelpOption() {
        super(new String[]{"-?","-h"}, "-help");
        setEnable(true);
        process();
    }

    @Override
    public void printUsage() {
        //System.out.println("\n"+ usage);
        System.out.println(
                getUsage()+
                "\n\n" +
                "Options Available\n"+
                "Help    = \"-?\" | \"-h\" | \"-help\"\n" +
                "Verbose = \"-v\" | \"-verbose\"\n" +
                "Listing  = \"-l\" | \"-listing\"\n");
    }

    public void setUsage(){
        usage = "Usage: CommandLine = CommandName [Option] {SourceFile}";
       
    }

    @Override
    public void process() {
        setUsage();
        printUsage();
        exit(1);
    }

    @Override
    public void setFiles(File file) {

    }
}
