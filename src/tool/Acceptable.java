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

    public static final String CUSTOMERID_VALID = "^[CGK][0-9]{4}$";

    public static final String NAME_VALID = "^.{2,25}$";

    public static final String PHONE_VALID = "^(03|05|07|08|09)\\d{8}$";

    public static final String EMAIL_VALID = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,7}$";

    public static final String MENUCODE_VALID = "PW00[1-6]";
;
}
