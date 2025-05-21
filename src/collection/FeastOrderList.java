/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package collection;

import java.util.ArrayList;
import tool.Inputter;
import model.FeastOrder;
import model.FeastMenu;

/**
 *
 * @author ADMIN
 */
public class FeastOrderList {

    public static ArrayList<FeastOrder> feastOrders = new ArrayList<>();

    public static void addOrder() {
        System.out.println("Place a new feast order: ");
        while (true) {
            String customerCode = Inputter.findCustomerCode();
            FeastMenuList.displayMenu();
            String menuCode = Inputter.findMenuCode();
            FeastMenu order = FeastMenuList.findFeastMenuByCode(menuCode);
        }
    }

}
