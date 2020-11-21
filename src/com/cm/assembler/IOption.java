package com.cm.assembler;

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
    void process();
    void setEnable(boolean en);
    void setUsage(String usage);
    void setClassName(String className);

}



