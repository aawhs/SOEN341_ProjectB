
class VerboseOption extends Option {
    public VerboseOption() {
        super(new String[]{"-v"}, "-verbose");
        setEnable(true);
    }


    @Override
    public void process() {
        setReq(true);
        
    }
}
