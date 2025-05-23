/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package collection;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
import tool.Inputter;
import tool.Acceptable;
import model.FeastOrder;
import model.FeastMenu;
import menu.Displayer;
/**
 *
 * @author ADMIN
 */
public class FeastOrderList {

    public static ArrayList<FeastOrder> feastOrders = new ArrayList<>();

    public static void addOrder() {
        Scanner sc = new Scanner(System.in);
        String input = "";

        do {
            String customerCode = Inputter.findCustomerCode();
            Displayer.displayMenu();
            String menuCode = Inputter.findMenuCode();
            FeastMenu toOrder = FeastMenuList.findFeastMenuByCode(menuCode);
            String date = Inputter.inputDate();

            if (checkDupplicatedOrder(customerCode, menuCode, date)) {
                System.out.println("Dupplicated date! This order is already saved");
            } else {
                double price = Double.parseDouble(toOrder.getPrice());
                String setPrice = FeastMenuList.formatPrice(price);
                int quantity = Inputter.inputQuantity();

                String totalCost = FeastMenuList.formatPrice(calculateTotalCost(menuCode, quantity));

                int orderId = 0;
                for (FeastOrder fo : feastOrders) {
                    if (fo.getOrderID() > orderId) {
                        orderId = fo.getOrderID(); // Tìm order ID lớn nhất 
                    }
                }
                orderId++; // Tạo 1 order ID mới lớn hơn để không bị trùng lặp
                FeastOrder newOrder = new FeastOrder(customerCode, menuCode, date, quantity, orderId, setPrice, totalCost);
                feastOrders.add(newOrder);
                System.out.println("New order placed successfully!");
                Displayer.displayOrder(newOrder);
                while (true) {
                    System.out.println("Do you want to place another order(Y/N)");
                    input = sc.nextLine();
                    if (input.equalsIgnoreCase("n")) {
                        return;
                    } else if (input.equalsIgnoreCase("y")) {
                        break;
                    } else {
                        System.out.println("Invalid input. Please try again. ");
                    }
                }
            }
        } while (true);
    }

    public static void updateOrder() {
        int orderId = 0;
        FeastOrder foundOrder;
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("Enter Order ID (Integer Number) to upgrade: ");
                orderId = sc.nextInt();
                sc.nextLine();
                foundOrder = searchByOrderId(orderId);
                if (foundOrder == null) {
                    System.out.println("This Order does not exist. ");
                    continue;
                }
                System.out.println("Order ID has been found!");
                Displayer.displayOrder(foundOrder);
                System.out.println("Enter new information to update or press ENTER to skip: ");
                break;
            } catch (InputMismatchException e) {
                System.out.println("Order ID must be an integer number, please try again. ");
                sc.nextLine();
            }
        }

        // Update Set Menu Code
        while (true) {
            System.out.println("Enter new set menu code to update: ");
            String newMenuCode = sc.nextLine();
            if (newMenuCode.isEmpty()) {
                System.out.println("Keeping old set menu code. ");
                break;
            } else if (Inputter.isValid(newMenuCode, Acceptable.MENUCODE_VALID)) {
                foundOrder.setSetMenuCode(newMenuCode);
                break;
            } else {
                System.out.println("Invalid set menu code, please try again. ");
            }
        }

        // Update table number 
        while (true) {
            try {
                System.out.print("Enter new number of tables to upgrade: ");
                String input = sc.nextLine();
                if (input.isEmpty()) {
                    System.out.println("Keeping old information.");
                    break;
                }
                int newTableNumber = Integer.parseInt(input);
                if (newTableNumber > 0) {
                    foundOrder.setTableNumber(newTableNumber);
                    break;
                } else {
                    System.out.println("Must be greater than 0, try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number, must be an integer greater than 0, try again.");
            }
        }

        // Update event date 
        while (true) {
            System.out.println("Enter new event date (dd/MM/yyyy) to upgrade: ");
            String newDate = sc.nextLine();
            if (newDate.isEmpty()) {
                System.out.println("Keeping old information.");
                break;
            } else if (Inputter.isValidDate(newDate)) {
                foundOrder.setEventDate(newDate);
                break;
            } else {
                System.out.println("Invalid event date, please try again. ");
            }

        }

        // Update total price
        double totalPrice = 0;
        for (FeastMenu fm : FeastMenuList.feastMenus) {
            if (fm.getMenuCode().equalsIgnoreCase(foundOrder.getSetMenuCode())) {
                totalPrice = Double.parseDouble(fm.getPrice()) * foundOrder.getTableNumber();
                break;
            }
        }
        foundOrder.setTotalCost(FeastMenuList.formatPrice(totalPrice));
        System.out.println("This order information has been upgraded successfully !!!");

        // Back to Menu
        while (true) {
            System.out.println("Do you wish to continue upgrade feast order list ? (Y/N)");
            String answer = sc.nextLine();
            if (answer.equalsIgnoreCase("n")) {
                System.out.println("Back to the main menu... ");
                break;
            } else if (answer.equalsIgnoreCase("y")) {
                System.out.println("Continue upgrading... ");
                updateOrder();
                break;
            } else {
                System.out.println("Invalid input, please try again. ");
            }
        }
    }

    public static boolean checkDupplicatedOrder(String customerCode, String menuCode, String eventDate) {
        for (FeastOrder fo : feastOrders) {
            if (customerCode.equalsIgnoreCase(fo.getCustomerCode())
                    && menuCode.equalsIgnoreCase(fo.getSetMenuCode())
                    && eventDate.equalsIgnoreCase(fo.getEventDate())) {
                return true;
            }
        }
        return false;
    }

    public static double calculateTotalCost(String setMenuCode, int quantity) {
        for (FeastMenu fm : FeastMenuList.feastMenus) {
            if (fm.getMenuCode().equalsIgnoreCase(setMenuCode)) {
                return Double.parseDouble(fm.getPrice()) * quantity;
            }
        }
        return 0;
    }

    public static FeastOrder searchByOrderId(int id) {
        for (FeastOrder fo : feastOrders) {
            if (id == fo.getOrderID()) {
                return fo;
            }
        }
        return null;
    }


    

}
