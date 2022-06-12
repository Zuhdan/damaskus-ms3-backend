/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damaskus.ms3.relawan.service;

import com.damaskus.ms3.relawan.assembler.UserAssembler;
import com.damaskus.ms3.relawan.common.CommonEncryption;
import com.damaskus.ms3.relawan.common.ResponseDTO;
import com.damaskus.ms3.relawan.common.ResponseStatus;
import com.damaskus.ms3.relawan.domain.User;
import com.damaskus.ms3.relawan.dto.RequestUserLoginDTO;
import com.damaskus.ms3.relawan.dto.ResponseUserLoginDTO;
import com.damaskus.ms3.relawan.dto.UserDTO;
import com.damaskus.ms3.relawan.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author eksad-samsul
 */
@Service
public class UserService {
   @Autowired
   UserRepository userRepository;
    
    public ResponseEntity<ResponseUserLoginDTO> login(RequestUserLoginDTO req) {
        ResponseUserLoginDTO res = new ResponseUserLoginDTO().denied();
        try {
            String passwordEncrypted = new CommonEncryption().encrypt(req.getPassword(), "332211");
            System.out.println("password === "+passwordEncrypted);
            User userLogin = userRepository.getUserByUsernamAndPassword(req.getUsername(), passwordEncrypted);
            if(userLogin != null) {
                res = new ResponseUserLoginDTO().success();
            }
        } catch (Exception e) {
            res = new ResponseUserLoginDTO().fail();
        }
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }
    public ResponseEntity<ResponseDTO> postUser(UserDTO userDTO){
        try{
            if(userDTO!=null){
                userRepository.save(new UserAssembler().toDomain(userDTO));
            }
            else{
                return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseDTO().failedRespose(String.valueOf(HttpStatus.NOT_FOUND.value()), "Invalid Request"));
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseDTO().failedRespose(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()), ex.getMessage()));
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseDTO().failedRespose(String.valueOf(HttpStatus.FOUND.value()), "Sucess"));
        
    }
}
