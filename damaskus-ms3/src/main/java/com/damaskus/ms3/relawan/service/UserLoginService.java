/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dans.test.recruitment.service;


import com.dans.test.recruitment.common.CommonEncryption;
import com.dans.test.recruitment.domain.UserLogin;
import com.dans.test.recruitment.dto.RequestUserLoginDTO;
import com.dans.test.recruitment.dto.ResponseUserLoginDTO;
import com.dans.test.recruitment.repository.UserLoginRepository;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserLoginService {
    
    @Autowired
    UserLoginRepository userRepository;
    
    public ResponseEntity<ResponseUserLoginDTO> login(RequestUserLoginDTO req) {
        ResponseUserLoginDTO res = new ResponseUserLoginDTO().denied();
        try {
            String passwordEncrypted = new CommonEncryption().encrypt(req.getPassword(), "332211");
            System.out.println("password === "+passwordEncrypted);
            UserLogin userLogin = userRepository.getUserLogin(req.getUsername(), passwordEncrypted);
            if(userLogin != null) {
                res = new ResponseUserLoginDTO().success();
            }
        } catch (Exception e) {
            res = new ResponseUserLoginDTO().fail();
        }
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }
    
}
