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
import model.FeastMenu;
import model.FeastOrder;
import java.util.ArrayList;
import collection.CustomerList;
import collection.FeastMenuList;
import collection.FeastOrderList;
import menu.Displayer;
import java.util.InputMismatchException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.DateTimeException;

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

    public static String inputMenuCode() {
        Scanner sc = new Scanner(System.in);
        String menuCode;
        while (true) {
            System.out.println("Enter set menu code (PW001 - PW006): ");
            menuCode = sc.nextLine().trim();
            if (isValid(menuCode, Acceptable.MENUCODE_VALID)) {
                break;
            } else {
                System.out.println("Your menu code is invalid, please try again. ");
            }
        }
        return menuCode;
    }

    public static String findCustomerCode() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Enter customer code: ");
            String code = sc.nextLine().trim();

            for (Customer c : CustomerList.customers) {
                if (code.equalsIgnoreCase(c.getCode())) {
                    return code.toUpperCase();
                }
            }

            System.out.println("Customer code can not found. Please try again.");
        }
    }

    public static String findMenuCode() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter set menu code (PW001 - PW006): ");
            String menuCode = sc.nextLine().trim();
            for (FeastMenu fm : FeastMenuList.feastMenus) {
                if (menuCode.equalsIgnoreCase(fm.getMenuCode())) {
                    return menuCode.toUpperCase();
                }
            }
            System.out.println("Invalid menu code. Please try again. ");
        }
    }

    public static int inputQuantity() {
        Scanner sc = new Scanner(System.in);
        int table;
        while (true) {
            try {
                System.out.println("Enter number of tables you wish to order: ");
                table = sc.nextInt();
                sc.nextLine();
                if (table > 0) {
                    break;
                } else {
                    System.out.println("Invalid input, please try again. ");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, number of tables must be an integer greater than 0");
                sc.nextLine();
            }
        }
        return table;
    }

    public static String inputDate() {
        Scanner sc = new Scanner(System.in);
        String date;

        while (true) {
            System.out.println("Enter the date in the format 'dd/MM/yyyy' to hold the event: ");
            date = sc.nextLine().trim();
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate inputDate = LocalDate.parse(date, formatter);

                if (inputDate.isAfter(LocalDate.now())) {
                    return date;
                } else if (inputDate.isBefore(LocalDate.now())) {
                    System.out.println("Event date is invalid. Input date must be in the future (after today).");
                } else {
                    System.out.println("Event date cannot be today. Please choose a future date.");
                }
            } catch (DateTimeException e) {
                System.out.println("Invalid date format, please try again.");
            }
        }
    }

    public static boolean isValidDate(String date) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate inputDate = LocalDate.parse(date, formatter);
            LocalDate today = LocalDate.now();
            if (inputDate.isAfter(today)) {
                return true;
            } else if (inputDate.isEqual(today)) {
                System.out.println("Event date cannot be today. Please choose a future date.");
            } else {
                System.out.println("Event date is invalid. Input date must be in the future (after today).");
            }
        } catch (DateTimeException e) {
            System.out.println("Invalid date format, please try again (e.g., dd/MM/yyyy).");
        }
        return false;
    }

    public static void displayFile() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("============= DISPLAY MENU =============");
                System.out.println("0. Return to Main Menu");
                System.out.println("1. Display Customers List");
                System.out.println("2. Display Orders List");
                System.out.println("========================================");
                System.out.print("Choose an option (0-2): ");

                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 0:
                        System.out.println("Returning to Main Menu...");
                        return;
                    case 1:
                        CustomerList.readFromFile(); // Đọc dữ liệu từ file trước
                        if (CustomerList.customers == null || CustomerList.customers.isEmpty()) {
                            System.out.println("No customer data found in file.");
                        } else {
                            System.out.println("Customer list information from file:");
                            Displayer.showCustomerList(CustomerList.customers);
                        }
                        return;
                    case 2:
                        FeastOrderList.readFromFile(); // Đọc dữ liệu từ file trước
                        if (FeastOrderList.feastOrders == null || FeastOrderList.feastOrders.isEmpty()) {
                            System.out.println("No order data found in file.");
                        } else {
                            System.out.println("Order list information from file:");
                            Displayer.showOrderList();
                        }
                        return;
                    default:
                        System.out.println("Invalid option. Please choose 0, 1 or 2.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Input invalid, must be an integer (0-2).");
                sc.nextLine();
            }
        }
    }

}
