/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.io.Serializable;

/**
 *
 * @author ADMIN
 */
public class FeastMenu implements Serializable,Comparable<FeastMenu> {

    private String menuCode;
    private String name;
    private String price;
    private String ingredients;

    public FeastMenu() {
    }

    public FeastMenu(String menuCode, String name, String price, String ingredients) {
        this.menuCode = menuCode;
        this.name = name;
        this.price = price;
        this.ingredients = ingredients;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s", menuCode, name, price, ingredients);
    }

    @Override
    public int compareTo(FeastMenu other) {
        return Double.compare(Double.valueOf(this.getPrice()), Double.valueOf(other.getPrice()));
    }

}
