/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damaskus.ms3.relawan.assembler;

import com.damaskus.ms3.relawan.common.CommonEncryption;
import com.damaskus.ms3.relawan.domain.User;
import com.damaskus.ms3.relawan.dto.UserDTO;
import com.damaskus.ms3.relawan.util.ObjectAssembler;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import org.springframework.beans.factory.annotation.Value;

/**
 *
 * @author eksad-samsul
 */
public class UserAssembler implements ObjectAssembler<User, UserDTO> {
    @Value("${encryption.chiper}")
    private String chiper;
    
    @Override
    public UserDTO toDTO(User domainObject) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserID(domainObject.getUserID());
        userDTO.setUserName(domainObject.getUserName());
        userDTO.setPassword(getPassword(domainObject.getPassword(), "dec"));
        userDTO.setEmail(domainObject.getEmail());
        return userDTO;
    }
    
    @Override
    public User toDomain(UserDTO dtoObject) {
        User user = new User();
        user.setUserID(dtoObject.getUserID());
        user.setUserName(dtoObject.getUserName());
        user.setPassword(dtoObject.getPassword());
        user.setPassword(getPassword(dtoObject.getPassword(), "enc"));
        user.setEmail(dtoObject.getEmail());
        return user;
    }
    
    public String getPassword(String password, String mode){
        String passwordKey = password;
        if(mode.equals("enc")){
            try {  
            passwordKey = new CommonEncryption().encrypt(password, chiper);
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(UserAssembler.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvalidKeyException ex) {
                Logger.getLogger(UserAssembler.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(UserAssembler.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoSuchPaddingException ex) {
                Logger.getLogger(UserAssembler.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvalidAlgorithmParameterException ex) {
                Logger.getLogger(UserAssembler.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalBlockSizeException ex) {
                Logger.getLogger(UserAssembler.class.getName()).log(Level.SEVERE, null, ex);
            } catch (BadPaddingException ex) {
                Logger.getLogger(UserAssembler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            try {
                passwordKey = new CommonEncryption().decrypt(password, "332211");
            } catch (GeneralSecurityException ex) {
                Logger.getLogger(UserAssembler.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(UserAssembler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return passwordKey;
    }
    
}
