/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gt.miumg.sistemas.operativos.excepciones;

/**
 *
 * @author Wilson
 */
public class UsuarioFoundException extends Exception {
    
    public UsuarioFoundException(){
        super("El usuario con ese usuario ya existe en la base de datos, vuelva a intentarlo");
    }
    
    public UsuarioFoundException(String mensaje){
        super(mensaje);
    }
}
