package com.addressbookworkshopvalidation;

public enum Message {
    START_WITH_CAPITAL("Please enter valid name formate."),
    NUMBER("Please enter the number");
    String s;
    Message(String s) {
        this.s = s;
    }

    public String getMessage() {
        return s;
    }
}
