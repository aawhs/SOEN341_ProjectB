package com.cm.assembler;

class ListingOption extends Option {
    public ListingOption() {
        super(new String[]{"-l"},"-listing");
        setEnable(true);
        process();
    }

    @Override
    public void process() {
        setReq(true);
       
    }

}
