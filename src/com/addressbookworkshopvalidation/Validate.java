package com.addressbookworkshopvalidation;

import com.addressbookworkshop.Contacts;

import java.lang.reflect.Field;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    public static void validate(Contacts contacts) throws IllegalAccessException, CustomException {
        Class c = contacts.getClass();
        Field[] field = c.getDeclaredFields();
        for(Field f: field){
            Validation v = f.getAnnotation(Validation.class);
            f.setAccessible(true);
            validate(f.getName(),f.get(contacts),v);
        }
    }
    private static void validate(String fieldName,Object obj, Validation v) throws CustomException {
        String str =(String) obj;
        if(v.required()&& str == null){
            throw  new CustomException("This field "+fieldName+" is required.");
        }
        if(v.required() && str != null){
            Pattern p = Pattern.compile(v.getRegex().getCode());
            Matcher m = p.matcher(str);
            if(!m.find()){
                throw new CustomException(v.getMessage().getMessage());
            }
        }
    }
}
