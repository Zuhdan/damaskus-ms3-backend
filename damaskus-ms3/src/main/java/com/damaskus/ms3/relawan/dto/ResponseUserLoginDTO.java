/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damaskus.ms3.relawan.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseUserLoginDTO {
    private String message;
    private Date login_date;
    
    public ResponseUserLoginDTO success() {
        return new ResponseUserLoginDTO("Login sukses.", new Date());
    }
    
    public ResponseUserLoginDTO denied() {
        return new ResponseUserLoginDTO("User tidak dikenal.", null);
    }
    
    public ResponseUserLoginDTO fail() {
        return new ResponseUserLoginDTO("Terjadi kesalahan. Login gagal.", null);
    }
    
    
}
