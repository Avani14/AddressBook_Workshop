package com.addressbookworkshop;

import com.addressbookworkshopvalidation.Message;
import com.addressbookworkshopvalidation.Regex;
import com.addressbookworkshopvalidation.Validation;

public class Contacts {
    @Validation(required = true,getRegex = Regex.START_WITH_CAPITAL,getMessage = Message.START_WITH_CAPITAL)
    private String name;
    @Validation(required = true,getRegex = Regex.NUMBER_ONLY,getMessage = Message.NUMBER)
    private String phone_number;

    public Contacts(String name, String phone_number) {
        this.name = name;
        this.phone_number = phone_number;
    }

    public String getName() {
        return name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    @Override
    public String toString() {
        return "Contacts{" +
                "name='" + name + '\'' +
                ", phone_number='" + phone_number + '\'' +
                '}';
    }
}
