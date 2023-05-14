/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gt.miumg.sistemas.operativos.Entity;

import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author Wilson
 */
public class Authority implements GrantedAuthority{
    
    private String authority;

    public Authority(String authority) {
        this.authority = authority;
    }
    
    

    @Override
    public String getAuthority() {
        return this.authority;
    }
    
}
