/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ADMIN
 */
public class Customer implements Comparable<Customer> {
    
    private String code;
    private String name;
    private String phoneNumber;
    private String email;
    
    public Customer() {
    }
    
    public Customer(String code, String name, String phoneNumber, String email) {
        this.code = code;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
    
    public String getCode() {
        return code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    @Override
    public String toString() {
        return String.format("%-12s| %-22s| %-15s| %-15s", code, toTitleCase(name), phoneNumber, email);
    }
    
    @Override
    public int compareTo(Customer other) {
        return this.name.compareToIgnoreCase(other.name);
    }
    
    public static String toTitleCase(String str) {
        String[] array = str.split(" ");
        String result = "";
        
        for (String word : array) {
            if (word.trim().length() > 0) {
                result += (word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase() + " ");
            }
        }
        return result.trim();
    }
    
}
