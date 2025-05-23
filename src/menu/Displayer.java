/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menu;

import model.Customer;
import java.util.Collections;
import collection.CustomerList;
import model.FeastOrder;
import model.FeastMenu;
import collection.FeastMenuList;
import collection.FeastOrderList;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class Displayer {

    public static void displayCustomerInformation(String id) {
        Customer c = CustomerList.searchById(id);
        System.out.println("Customer Information: ");
        System.out.println("Customer ID: " + c.getCode());
        System.out.println("Customer Name: " + c.getName());
        System.out.println("Customer Phone Number: " + c.getPhoneNumber());
        System.out.println("Customer Email: " + c.getEmail());
    }

    public static void displayOrder(FeastOrder order) {
        FeastMenu toOrder = FeastMenuList.findFeastMenuByCode(order.getSetMenuCode());

        System.out.println("------------------------------------------------------------------------");
        System.out.println("Customer order information  [Order ID: " + order.getOrderID() + "]");
        System.out.println("------------------------------------------------------------------------");
        Displayer.displayCustomerInformation(order.getCustomerCode());
        System.out.println("------------------------------------------------------------------------");
        System.out.println("Code of Set Menu: " + order.getSetMenuCode());
        System.out.println("Set menu name   : " + toOrder.getName());
        System.out.println("Event date      : " + order.getEventDate());
        System.out.println("Number of tables: " + order.getTableNumber());
        System.out.println("Price           : " + FeastMenuList.formatPrice(Double.parseDouble(toOrder.getPrice())) + " Vnd");
        System.out.println("Ingredients     : \n" + FeastMenuList.formatIngredients(toOrder.getIngredients()));
        System.out.println("------------------------------------------------------------------------");
        System.out.println("Total cost      : " + order.getTotalCost() + " Vnd");
        System.out.println("------------------------------------------------------------------------");
    }

    public static void showAllOrder() {
        System.out.println("All Orders Information: ");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.printf("| %-10s | %-10s | %-10s | %-12s | %-8s | %-15s |\n",
                "Order ID", "Cust.Code", "MenuCode", "Event Date", "Tables", "Total Cost");
        System.out.println("--------------------------------------------------------------------------------");

        for (FeastOrder order : FeastOrderList.feastOrders) {
            String formattedCost = String.format("%,d Vnd", order.getTotalCost());  // có dấu phẩy
            System.out.printf("| %-10d | %-10s | %-10s | %-12s | %-8d | %-15s |\n",
                    order.getOrderID(),
                    order.getCustomerCode(),
                    order.getSetMenuCode(),
                    order.getEventDate(),
                    order.getTableNumber(),
                    formattedCost);
        }

        System.out.println("--------------------------------------------------------------------------------");
    }

    public static void displayAllCustomers() {
        Collections.sort(CustomerList.customers);
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("Code        | Customer Name         | Phone          | Email           ");
        System.out.println("-----------------------------------------------------------------------");
        for (Customer c : CustomerList.customers) {
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

    public static void displayMenu() {
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("List of Set Menus for ordering party:");
        System.out.println("-------------------------------------------------------------------------------------");
        for (FeastMenu fm : FeastMenuList.feastMenus) {
            System.out.println("Code       : " + fm.getMenuCode());
            System.out.println("Name       : " + fm.getName());
            System.out.println("Price      : " + FeastMenuList.formatPrice(fm.getPrice()));
            System.out.println("Ingredients: \n" + FeastMenuList.formatIngredients(fm.getIngredients()));
            System.out.println("-------------------------------------------------------------------------------------");
        }
    }

}
