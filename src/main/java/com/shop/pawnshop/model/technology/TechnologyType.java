package com.shop.pawnshop.model.technology;



public enum TechnologyType {
    SMALL("small"),
    LARGE("large");

    private final String technology;

    TechnologyType(String technology){
        this.technology = technology;
    }
    public String getTechnology(){
        return technology;
    }
}
