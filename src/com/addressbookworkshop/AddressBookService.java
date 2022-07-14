package com.addressbookworkshop;

import com.addressbookworkshopvalidation.CustomException;
import com.addressbookworkshopvalidation.Validate;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class AddressBookService {
    Scanner sc = new Scanner(System.in);
    ArrayList<Contacts> arrayList = new ArrayList<Contacts>();
    HashMap<String, ArrayList<Contacts>> hashMap = new HashMap<>();
    public void addContact() throws CustomException, IllegalAccessException {
        System.out.println("Enter address book name:");
        String addressbookName = sc.next();
        System.out.println("Enter name: ");
        String name = sc.next();
        if(checkDuplicate(name)) {
            System.out.println("Enter phone number:");
            String phone = sc.next();
            Contacts c = new Contacts(name, phone);
            Validate.validate(c);
            arrayList.add(c);
            hashMap.put(addressbookName, arrayList);
        }
        return;
    }
    public void display(){
        if(hashMap.isEmpty()){
            System.out.println("Address book is empty!");
            return;
        }
        System.out.println("Please enter the address book name");
        String name = sc.next();
        hashMap.get(name).stream().sorted((contact1, contact2) -> contact1.getName().compareToIgnoreCase(contact2.getName()))
                .forEach(contact -> System.out.println(contact));

    }
    public boolean checkDuplicate(String name){
        if(hashMap.isEmpty()){
            return true;
        }
        for(Contacts c : arrayList){
            if(c.getName().compareToIgnoreCase(name)==0){
                System.out.println("This name is already in the address book");
                return false;
            }
        }
        return true;
    }

}
