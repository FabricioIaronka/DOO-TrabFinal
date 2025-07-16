/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package exceptions;

/**
 *
 * @author fabri
 */
public class ClientInvalid extends Exception {

    /**
     * Creates a new instance of <code>ClientInvalid</code> without detail
     * message.
     */
    public ClientInvalid() {
    }

    /**
     * Constructs an instance of <code>ClientInvalid</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public ClientInvalid(String msg) {
        super(msg);
    }
}
