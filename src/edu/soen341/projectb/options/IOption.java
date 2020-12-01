package edu.soen341.projectb.options;

import java.io.File;
import java.io.IOException;

public interface IOption {
    default void printUsage() {
        System.out.println("Usage: CommandLine = CommandName [Option] {SourceFile}\n" +
                "Options Available\n"+
                "HelpOption    = \"-?\" | \"-h\" | \"-help\"\n" +
                "VerboseOption = \"-v\" | \"-verbose\"\n" +
                "ListingOption  = \"-l\" | \"-listing\"\n");
    }

    boolean isOption();
    boolean isEnabled();
    boolean isRequired();
    void process() throws IOException;
    void setEnable(boolean en);
    void setFiles(File file);
    void setUsage(String usage);
    void setClassName(String className);

}



