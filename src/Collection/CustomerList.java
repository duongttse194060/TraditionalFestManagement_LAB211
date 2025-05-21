package Collection;

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

public class CustomerList {

    public static ArrayList<Customer> customers = new ArrayList<>();

    public static void addCustomer() {
        Scanner sc = new Scanner(System.in);
        String input = "";

        do {
            System.out.println("Register a new customer: ");
            String code = Inputter.inputCustomerId(customers);
            String name = Inputter.inputName();
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

    public static void searchCustomer() {
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
            showCustomerList(matchedList);
        }
    }

    public static void displayAll() {
        Collections.sort(customers);
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("Code        | Customer Name         | Phone          | Email           ");
        System.out.println("-----------------------------------------------------------------------");
        for (Customer c : customers) {
            System.out.println(c);
        }
        System.out.println("-----------------------------------------------------------------------");
    }

    public static void showCustomerList(ArrayList<Customer> list) {
        Collections.sort(list);
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("Code        | Customer Name         | Phone          | Email           ");
        System.out.println("-----------------------------------------------------------------------");
        for (Customer c : list) {
            System.out.println(c);
        }
        System.out.println("-----------------------------------------------------------------------");
    }
}
