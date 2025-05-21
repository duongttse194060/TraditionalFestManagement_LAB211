/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.util.Scanner;
import menu.Menu;
import collection.CustomerList;
import collection.FeastMenuList;

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
                    CustomerList.addCustomer();
                    CustomerList.displayAll();
                    break;
                case 2:
                    CustomerList.updateCustomer();
                    CustomerList.displayAll();
                    break;
                case 3:
                    CustomerList.searchByName();
                    break;
                case 4:
                    System.out.println("You choose option 4:");
                    FeastMenuList.displayMenu();
                    break;
                default:
                    System.out.println("Invalid choice. Program exited... ");
                    return;
            }

        } while (true);
    }
}
