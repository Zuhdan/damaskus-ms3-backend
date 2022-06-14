/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damaskus.ms3.relawan.rest;

import com.damaskus.ms3.relawan.common.ResponseDTO;
import com.damaskus.ms3.relawan.dto.RequestUserLoginDTO;
import com.damaskus.ms3.relawan.dto.ResponseUserLoginDTO;
import com.damaskus.ms3.relawan.dto.UserDTO;
import com.damaskus.ms3.relawan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author eksad-samsul
 */
@RestController
public class UserRestController {
  @Autowired
    UserService userService;
    
    @RequestMapping(value = "/api/post.login",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseUserLoginDTO> postLogin(@RequestBody RequestUserLoginDTO loginDTO) {
        return userService.login(loginDTO);
    } 
    @RequestMapping(value = "/api/post.user",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO> postUser(@RequestBody UserDTO userDTO) {
         return userService.postUser(userDTO);
    } 
}
