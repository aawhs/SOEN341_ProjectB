
class ListingOption extends Option {
    public ListingOption() {
        super(new String[]{"-l"},"-listing");
        setEnable(true);
    }

    @Override
    public void process() {
        setReq(true);
       
    }

}
