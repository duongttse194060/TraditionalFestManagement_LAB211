/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tool;

/**
 *
 * @author ADMIN
 */
import java.util.UUID;
import menu.Menu;
import java.util.Scanner;

public class Inputter {

    public static int choice;

    public static boolean isValid(String input, String pattern) {
        return input.matches(pattern);
    }

    public static String getCustomerId() {
        Menu.chooseEvent();
        String firstLetter = "";
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Enter your choice (1-3)");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    firstLetter = "C";
                    break;
                case 2:
                    firstLetter = "G";
                    break;
                case 3:
                    firstLetter = "K";
                    break;
                default:
                    System.out.println("Your choice is invalid, please try again.");
                    continue;
            }
            break;
        }

        String id = UUID.randomUUID().toString().replaceAll("^[0-9]", "").substring(0, 4);
        return firstLetter + id;
    }

    public static String inputName() {
        String name = "";
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter name: ");
            name = sc.nextLine();
            if (isValid(name, Acceptable.NAME_VALID)) {
                break;
            } else {
                System.out.println("Your name is invalid, please try again.");
            }
        }
        return name;
    }

    public static String inputPhoneNumber() {
        String phoneNumber = "";
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter phone number: ");
            phoneNumber = sc.nextLine();
            if (isValid(phoneNumber, Acceptable.PHONE_VALID)) {
                break;
            } else {
                System.out.println("Your phone number is invalid, please try again.");
            }
        }
        return phoneNumber;
    }

    public static String inputEmail() {
        String email = "";
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter email: ");
            email = sc.nextLine();
            if (isValid(email, Acceptable.EMAIL_VALID)) {
                break;
            } else {
                System.out.println("Your email is invalid, please try again.");
            }
        }
        return email;
    }
}
