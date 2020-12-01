package edu.soen341.projectb.options;

import edu.soen341.projectb.options.*;

import java.io.IOException;

public class OptionFactory {
    public Option getOption(String optionType) throws IOException {
        if(optionType == null){
            return new noOption();
        }


        boolean h = (optionType.equalsIgnoreCase("-h")) ||
                (optionType.equalsIgnoreCase("-?")) ||
                (optionType.equalsIgnoreCase("-help"));

        boolean v = (optionType.equalsIgnoreCase("-v")) ||
                (optionType.equalsIgnoreCase("-verbose"));

        boolean l = (optionType.equalsIgnoreCase("-l")) ||
                (optionType.equalsIgnoreCase("-listing"));


        if(h){
            return new HelpOption();
        } else if (v){
            return new VerboseOption();

        }else if (l){
            return new ListingOption();
        }
        return new noOption();
    }

}
