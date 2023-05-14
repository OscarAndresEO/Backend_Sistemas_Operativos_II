/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gt.miumg.sistemas.operativos.Entity;

/**
 *
 * @author Wilson
 */
public class JwtResponse {
    
    private String token;

    public JwtResponse(String token) {
        this.token = token;
    }

    public JwtResponse() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    
    
    
}
