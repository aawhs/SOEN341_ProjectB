public class OptionFactory {
    public Option getOption(String optionType){
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
