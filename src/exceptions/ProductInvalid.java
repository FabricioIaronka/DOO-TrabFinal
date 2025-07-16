/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package exceptions;

/**
 *
 * @author fabri
 */
public class ProductInvalid extends Exception {
    public ProductInvalid() {
    }
    
    public ProductInvalid(String msg) {
        super(msg);
    }
}
