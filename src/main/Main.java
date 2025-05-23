/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.util.Scanner;
import menu.Menu;
import collection.CustomerList;
import collection.FeastMenuList;
import collection.FeastOrderList;
import menu.Displayer;

/**
 *
 * @author ADMIN
 */
public class Main {

    public static void main(String[] args) {
        FeastMenuList.readFile();
        int choice = 0;
        Scanner sc = new Scanner(System.in);

        do {
            Menu.function();
            System.out.print("Enter your choice (1-8): ");
            try {
                choice = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.println("You choose option 1: Register new customer. ");
                    CustomerList.addCustomer();
                    Displayer.displayAllCustomers();
                    break;
                case 2:
                    System.out.println("You choose option 2: Update customer information. ");
                    CustomerList.updateCustomer();
                    Displayer.displayAllCustomers();
                    break;
                case 3:
                    System.out.println("You choose option 3: Search for customer information by name. ");
                    CustomerList.searchByName();
                    break;
                case 4:
                    System.out.println("You choose option 4: Display Feast Menu. ");
                    Displayer.displayMenu();
                    break;
                case 5:
                    System.out.println("You choose option 5: Place a new feast order. ");
                    FeastOrderList.addOrder();
                    Displayer.showAllOrder();
                    break;
                case 6:
                    System.out.println("You choose option 6: Update order information by Order ID. ");
                    FeastOrderList.updateOrder();
                    Displayer.showAllOrder();
                    break;
                default:
                    System.out.println("Invalid choice. Program exited... ");
                    return;
            }

        } while (true);
    }
}
