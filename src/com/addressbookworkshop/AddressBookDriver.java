package com.addressbookworkshop;

import com.addressbookworkshopvalidation.CustomException;

import java.util.Scanner;

public class AddressBookDriver {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws CustomException, IllegalAccessException {
        AddressBookService addressBookService = new AddressBookService();
        System.out.println("Welcome to Address Book");
        while(true){
            System.out.println("Enter 1 to enter data \nEnter 2 to display data \nEnter 3 to exit");
            int option = sc.nextInt();
            switch (option){
                case 1:
                    addressBookService.addContact();
                    break;
                case 2:
                    addressBookService.display();
                    break;
                case 3:
                    System.out.println("Thank You!");
                    return;
                default:
                    System.out.println("Enter valid option");
                    break;
            }
        }
    }
}
