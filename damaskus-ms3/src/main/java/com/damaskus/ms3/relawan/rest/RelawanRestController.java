/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damaskus.ms3.relawan.rest;

import com.damaskus.ms3.relawan.common.ResponseDTO;
import com.damaskus.ms3.relawan.dto.RelawanDTO;
import com.damaskus.ms3.relawan.dto.UserDTO;
import com.damaskus.ms3.relawan.service.RelawanService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author eksad-samsul
 */
@RestController
public class RelawanRestController {
 @Autowired
 RelawanService relawanServie;
 
 @RequestMapping(value = "/api/post.relawan",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO> postUser(@RequestBody RelawanDTO relawan) {
         relawanServie.postRelawan(relawan);
         return ResponseEntity.status(HttpStatus.FOUND).body(new ResponseDTO());
    }
   @RequestMapping(value = "/get.relawan.by.nik/{nik}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RelawanDTO> getSalesOrderByWoID(@PathVariable("nik") String nik) {   
         return  relawanServie.findRelawanByNik(nik);            
    } 
}
