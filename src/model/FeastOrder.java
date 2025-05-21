/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ADMIN
 */
public class FeastOrder {

    private String customerCode;
    private String setMenuCode;
    private String eventDate;
    private int tableNumber;
    private int orderID;
    private String setPrice;
    private String totalCost;

    public FeastOrder() {
    }

    public FeastOrder(String customerCode, String setMenuCode, String eventDate, int tableNumber, int orderID, String setPrice, String totalCost) {
        this.customerCode = customerCode;
        this.setMenuCode = setMenuCode;
        this.eventDate = eventDate;
        this.tableNumber = tableNumber;
        this.orderID = orderID;
        this.setPrice = setPrice;
        this.totalCost = totalCost;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getSetMenuCode() {
        return setMenuCode;
    }

    public void setSetMenuCode(String setMenuCode) {
        this.setMenuCode = setMenuCode;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getSetPrice() {
        return setPrice;
    }

    public void setSetPrice(String setPrice) {
        this.setPrice = setPrice;
    }

    public String getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(String totalCost) {
        this.totalCost = totalCost;
    }

    @Override
    public String toString() {
        return String.format("| %-5s | %-12s | %-11s | %-8s | %-10s | %-7s | %-10s |",
                getCustomerCode(), getEventDate(), getOrderID(), getSetMenuCode(), getSetPrice(), getTableNumber(), getTotalCost());
    }

}
