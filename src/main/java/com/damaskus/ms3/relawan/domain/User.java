/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damaskus.ms3.relawan.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author eksad-samsul
 */
@Entity
@Table(name = "USER")
public class User {
    @Id
    @GeneratedValue(generator = "trx_user_gen")
    @SequenceGenerator(name="trx_user_gen", sequenceName = "trx_user_seq")
    private Integer id;
    
    private String userID;
    
    private String userName;
    
    private String password;
    
    private String email; 

    public User() {
    }

    public User(Integer id, String userID, String userName, String password, String email) {
        this.id = id;
        this.userID = userID;
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
}
