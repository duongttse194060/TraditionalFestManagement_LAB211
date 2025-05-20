/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tool;

/**
 *
 * @author ADMIN
 */
public interface Acceptable {

    public final String NAME_VALID = "^.{2,25}$";

    public final String PHONE_VALID = "^(03|05|07|08|09)\\d{8}$";

    public final String EMAIL_VALID = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,7}$";
}
