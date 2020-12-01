package edu.soen341.projectb.options;

import edu.soen341.projectb.options.IOption;

import java.util.Arrays;
import java.io.File;


abstract class Option implements IOption {



    //Constructor
    public Option(String[] optShort, String optLong){
        setOptShort(optShort);
        setOptLong (optLong);
    }

    //Interface Methods
    @Override
    public void printUsage(){
        System.out.println("Usage: CommandLine = CommandName [Option] {SourceFile}\n" +
                "Options Available\n"+
                "HelpOption    = \"-?\" | \"-h\" | \"-help\"\n" +
                "VerboseOption = \"-v\" | \"-verbose\"\n" +
                "ListingOption  = \"-l\" | \"-listing\"\n");
    }

    //Option Attributes
    protected String[] optShort;
    protected String optLong;
    protected String usage;
    protected String className;
    protected String[] opt;
    protected boolean en;
    protected boolean req;
    protected File file;

    //Set & Get Functions
    public void setFile(File fileName){this.file = fileName;}
    public void setOptShort(String[] opt){this.optShort  = opt;}
    public void setOptLong (String opt)  {this.optLong   = opt;}
    @Override public void setUsage(String usage)   {this.usage     = usage;}
    @Override public void setClassName(String name){this.className = name;}
    public void setEnable(boolean en)     {this.en        = en;}
    public void setReq(boolean req)     {this.req        = req;}

    public final File getFile() {return this.file;}
    public final String[] getOptShort() {return this.optShort;}
    public final String   getOptLong()  {return this.optLong;}
    public final String   getUsage()    {return this.usage;}
    public final String   getClassName(){return this.className;}


    @Override
    public boolean isOption(){
        return Arrays.toString(optShort).contains("-");
    }

    @Override
    public boolean isEnabled() {
        return en;
    }

    @Override
    public boolean isRequired() {
        return this.req;
    }
}

