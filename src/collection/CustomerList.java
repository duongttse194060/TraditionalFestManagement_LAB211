package collection;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ADMIN
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import model.Customer;
import tool.Inputter;
import tool.Acceptable;
import menu.Displayer;

public class CustomerList {

    public static ArrayList<Customer> customers = new ArrayList<>();

    public static void addCustomer() {
        Scanner sc = new Scanner(System.in);
        String input = "";

        do {
            String code = Inputter.inputCustomerId(customers);
            String name = formatName(Inputter.inputName());
            String phoneNumber = Inputter.inputPhoneNumber();
            String email = Inputter.inputEmail();
            customers.add(new Customer(code, name, phoneNumber, email));
            System.out.println("New customer registered successfully! ");

            while (true) {
                System.out.println("Do you want to register another customer ? (Y/N)");
                input = sc.nextLine();
                if (input.equalsIgnoreCase("n")) {
                    return;
                } else if (input.equalsIgnoreCase("y")) {
                    break;
                } else {
                    System.out.println("Your choice is invalid, please try again.");
                }
            }

        } while (true);
    }

    public static void updateCustomer() {
        Customer foundCustomer = null;
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Enter Customer Id to upgrade: ");
            String toFind = sc.nextLine();
            foundCustomer = searchById(toFind);
            if (foundCustomer == null) {
                System.out.println("This customer does not exist! Please try again: ");
            } else {
                System.out.println("Customer have been found!");
                Displayer.displayCustomerInformation(toFind);
                System.out.println("Enter new information to update or press ENTER to skip: ");
                break;
            }
        }

        // Update Name
        while (true) {
            System.out.println("Enter new name to update: ");
            String newName = sc.nextLine();
            if (newName.isEmpty()) {
                System.out.println("Keeping old name. ");
                break;
            } else if (Inputter.isValid(newName, Acceptable.NAME_VALID)) {
                foundCustomer.setName(formatName(newName));
                break;
            } else {
                System.out.println("Invalid name, please try again. ");
            }
        }

        // Update Phone Number
        while (true) {
            System.out.println("Enter new phone number to update: ");
            String newPhoneNumber = sc.nextLine();
            if (newPhoneNumber.isEmpty()) {
                System.out.println("Keeping old phone number. ");
                break;
            } else if (Inputter.isValid(newPhoneNumber, Acceptable.PHONE_VALID)) {
                foundCustomer.setPhoneNumber(newPhoneNumber);
                break;
            } else {
                System.out.println("Invalid phone number, please try again. ");
            }
        }

        // Update Email
        while (true) {
            System.out.println("Enter new email to upgrade: ");
            String newEmail = sc.nextLine();
            if (newEmail.isEmpty()) {
                System.out.println("Keeping old email. ");
                break;
            } else if (Inputter.isValid(newEmail, Acceptable.EMAIL_VALID)) {
                foundCustomer.setEmail(newEmail);
                break;
            } else {
                System.out.println("Invalid email, please try again. ");
            }
        }
        System.out.println("This customer has been upgraded sucessfully !!! ");

        // Back to Menu
        while (true) {
            System.out.println("Do you wish to continue upgrade customer ? (Y/N)");
            String answer = sc.nextLine();
            if (answer.equalsIgnoreCase("n")) {
                System.out.println("Back to the main menu... ");
                break;
            } else if (answer.equalsIgnoreCase("y")) {
                System.out.println("Continue upgrading... ");
                updateCustomer();
                break;
            } else {
                System.out.println("Invalid input, please try again. ");
            }
        }
    }

    public static Customer searchById(String id) {
        for (Customer c : customers) {
            if (c.getCode().equalsIgnoreCase(id)) {
                return c;
            }
        }
        return null;
    }

    public static void searchByName() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name or partial name to search: ");
        String name = sc.nextLine();
        ArrayList<Customer> matchedList = new ArrayList<>();
        for (Customer c : customers) {
            if (c.getName().toLowerCase().contains(name.toLowerCase())) {
                matchedList.add(c);
            }
        }
        if (matchedList.isEmpty()) {
            System.out.println("No one matches the search criteria!");
        } else {
            Collections.sort(matchedList);
            System.out.println("Matching Customers: " + name);
            Displayer.showCustomerList(matchedList);
        }
    }

    public static String formatName(String name) {
        String[] parts = name.split("\\s+");
        if (parts.length > 1) {
            name = name.trim().replaceAll("\\s+", " ");
            int lastIndexOfSpace = name.lastIndexOf(" ");
            String tempName = name.substring(lastIndexOfSpace + 1);
            String others = name.substring(0, lastIndexOfSpace);
            return tempName + ", " + others;
        }
        return name;
    }
}
