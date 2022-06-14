/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damaskus.ms3.relawan.service;

import com.damaskus.ms3.relawan.assembler.RelawanAssembler;
import com.damaskus.ms3.relawan.assembler.UserAssembler;
import com.damaskus.ms3.relawan.common.CommonEncryption;
import com.damaskus.ms3.relawan.common.ResponseDTO;
import com.damaskus.ms3.relawan.domain.Relawan;
import com.damaskus.ms3.relawan.domain.User;
import com.damaskus.ms3.relawan.dto.RelawanDTO;
import com.damaskus.ms3.relawan.dto.RequestUserLoginDTO;
import com.damaskus.ms3.relawan.dto.ResponseUserLoginDTO;
import com.damaskus.ms3.relawan.dto.UserDTO;
import com.damaskus.ms3.relawan.repository.RelawanRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author eksad-samsul
 */
@Service
public class RelawanService {
 @Autowired
 RelawanRepository relawanRepository;
 
    public ResponseEntity<List<RelawanDTO>> findAllRelawan() {
           List<RelawanDTO> res = new ArrayList<>();
           try {
               List<Relawan> relawanList = relawanRepository.findAll();
               if(!relawanList.isEmpty()) {
                   res = new RelawanAssembler().toDTOs(relawanList);
               }
           } catch (Exception e) {
               res = new ArrayList<>();
           }
           return ResponseEntity.status(HttpStatus.OK).body(res);
    }
    public ResponseEntity<RelawanDTO> findRelawanByNik(String nik) {
           RelawanDTO res = new RelawanDTO();
           try {
               Relawan relawan = relawanRepository.findOneByNik(nik);
               if(relawan!=null) {
                   res = new RelawanAssembler().toDTO(relawan);
               }
           } catch (Exception e) {
               e.printStackTrace();
               res = new RelawanDTO();    
           }
           return ResponseEntity.status(HttpStatus.OK).body(res);
    }
    public ResponseEntity<ResponseDTO> postRelawan(RelawanDTO relawanData){
           try{
               if(relawanData!=null){
                   relawanRepository.save(new RelawanAssembler().toDomain(relawanData));
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
