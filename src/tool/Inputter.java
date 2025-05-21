/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tool;

/**
 *
 * @author ADMIN
 */
import menu.Menu;
import java.util.Scanner;
import model.Customer;
import java.util.ArrayList;

public class Inputter {

    public static int choice;

    public static boolean isValid(String input, String pattern) {
        return input.matches(pattern);
    }

    public static boolean isDuplicated(String id, ArrayList<Customer> list) {
        for (Customer c : list) {
            if (c.getCode().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    public static String inputCustomerId(ArrayList<Customer> list) {
        Scanner sc = new Scanner(System.in);
        String code;
        while (true) {
            System.out.print("Enter Customer ID: ");
            code = sc.nextLine().trim();
            if (!isValid(code, Acceptable.CUSTOMERID_VALID)) {
                System.out.println("Invalid ID format. Must start with C/G/K followed by 4 digits.");
            } else if (isDuplicated(code, list)) {
                System.out.println("ID is already used. Please enter another one.");
            } else {
                break;
            }
        }
        return code;
    }

    public static String inputName() {
        Scanner sc = new Scanner(System.in);
        String name;
        while (true) {
            System.out.print("Enter Customer Name: ");
            name = sc.nextLine().trim();
            if (isValid(name, Acceptable.NAME_VALID)) {
                break;
            } else {
                System.out.println("Your name is invalid, please try again.");
            }
        }
        return name;
    }

    public static String inputPhoneNumber() {
        Scanner sc = new Scanner(System.in);
        String phoneNumber;
        while (true) {
            System.out.print("Enter Customer Phone Number: ");
            phoneNumber = sc.nextLine().trim();
            if (isValid(phoneNumber, Acceptable.PHONE_VALID)) {
                break;
            } else {
                System.out.println("Your phone number is invalid, please try again.");
            }
        }
        return phoneNumber;
    }

    public static String inputEmail() {
        Scanner sc = new Scanner(System.in);
        String email;
        while (true) {
            System.out.print("Enter Customer Email: ");
            email = sc.nextLine().trim();
            if (isValid(email, Acceptable.EMAIL_VALID)) {
                break;
            } else {
                System.out.println("Your email is invalid, please try again.");
            }
        }
        return email;
    }
}
