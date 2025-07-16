/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package exceptions;

/**
 *
 * @author fabri
 */
public class LoginInvalid extends Exception {

 
    public LoginInvalid() {
    }

    
    public LoginInvalid(String msg) {
        super(msg);
    }
}
