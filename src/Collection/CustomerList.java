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

}
