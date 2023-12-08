package org.example.IDFC.enums;

public enum Constants {
    MINIMUM_BALANCE("minimum_balance",1500),
    CREDIT_ROI("credit_roi",0.002f),
    FD_ROI("fd_roi",0.06f),
    FD_YEAR("fd_year",3);
    private final float value;
    private final String name;
    Constants(String name,float value){
        this.name = name;
        this.value = value;
    }

    public float getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
