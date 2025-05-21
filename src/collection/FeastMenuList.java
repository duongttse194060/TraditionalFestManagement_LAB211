/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package collection;

import java.util.Scanner;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Collections;
import model.FeastMenu;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author ADMIN
 */
public class FeastMenuList {

    public static ArrayList<FeastMenu> feastMenus = new ArrayList<>();

    public static FeastMenu dataToObject(String line) {
        String[] parts = line.split(",", 4);
        if (parts.length < 4) {
            return null;
        }
        return new FeastMenu(
                parts[0].trim(),
                parts[1].trim(),
                parts[2].trim(),
                parts[3].trim()
        );
    }

    public static ArrayList<FeastMenu> readFile() {
        feastMenus.clear();
        String path = "src/data/FeastMenu.csv";
        try ( BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                FeastMenu feastMenu = dataToObject(line);
                if (feastMenu != null) {
                    feastMenus.add(feastMenu);
                }
            }
            System.out.println("Load data from FeastMenu.csv successfully. ");
        } catch (FileNotFoundException e) {
            System.out.println("Cannot find file FeastMenu.csv successfully. ");
        } catch (IOException e) {
            System.out.println("Cannot read data from FeastMenu.csv. Please check it. ");
        }
        Collections.sort(feastMenus);
        return feastMenus;
    }

    public static void displayMenu() {
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("List of Set Menus for ordering party:");
        System.out.println("-------------------------------------------------------------------------------------");
        for (FeastMenu fm : feastMenus) {
            System.out.println("Code       : " + fm.getMenuCode());
            System.out.println("Name       : " + fm.getName());
            System.out.println("Price      : " + formatPrice(fm.getPrice()));
            System.out.println("Ingredients: \n" + formatIngredients(fm.getIngredients()));
            System.out.println("-------------------------------------------------------------------------------------");
        }
    }

    public static String formatPrice(String str) {
        try {
            double price = Double.parseDouble(str);
            return String.format("%,.0f", price);
        } catch (NumberFormatException e) {
            return str;
        }
    }

    public static String formatIngredients(String str) {
        if (str == null) {
            return "";
        }
        if (str.startsWith("\"")) {
            str = str.substring(1);
        }
        if (str.endsWith("\"")) {
            str = str.substring(0, str.length() - 1);
        }
        return str.replace("#+", "\n+");
    }

    public static FeastMenu findFeastMenuByCode(String str) {
        for (FeastMenu fm : feastMenus) {
            if (str.equalsIgnoreCase(fm.getMenuCode())) {
                return fm;
            }
        }
        return null;
    }
}
