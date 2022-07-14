package com.addressbookworkshopvalidation;

public enum Regex {
    START_WITH_CAPITAL("^[A-Z].*"),
    NUMBER_ONLY("^(91|0)?+[7-9]{1}+[0-9]{9}$");
    private String constant;
    Regex(String s) {
        this.constant = s;
    }

    public String getCode() {
        return constant;
    }
}
