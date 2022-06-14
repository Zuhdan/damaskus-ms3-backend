/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damaskus.ms3.relawan.assembler;

import com.damaskus.ms3.relawan.domain.Relawan;
import com.damaskus.ms3.relawan.dto.RelawanDTO;
import com.damaskus.ms3.relawan.util.ObjectAssembler;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author eksad-samsul
 */

public class RelawanAssembler implements ObjectAssembler<Relawan, RelawanDTO>  {

    @Override
    public RelawanDTO toDTO(Relawan domainObject) {
        RelawanDTO dto = new RelawanDTO();
        dto.setJabatan(domainObject.getJabatan());
        dto.setNama(domainObject.getNama());
        dto.setNik(domainObject.getNik());
        dto.setJenisKelamin(domainObject.getJenisKelamin());
        dto.setTanggalLahir(domainObject.getTanggalLahir());
        dto.setAlamat(domainObject.getAlamat());
        dto.setKecamatan(domainObject.getKecamatan());
        dto.setKelurahan(domainObject.getKelurahan());   
        dto.setPhotoKtpUrl(domainObject.getPhotoKtpUrl());
        return dto;
         //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Relawan toDomain(RelawanDTO dtoObject) {
        Relawan relawan = new Relawan();
        relawan.setJabatan(dtoObject.getJabatan());
        relawan.setNama(dtoObject.getNama());
        relawan.setNik(dtoObject.getNik());
        relawan.setJenisKelamin(dtoObject.getJenisKelamin());
        relawan.setTanggalLahir(dtoObject.getTanggalLahir());
        relawan.setAlamat(dtoObject.getAlamat());
        relawan.setKecamatan(dtoObject.getKecamatan());
        relawan.setKelurahan(dtoObject.getKelurahan());   
        relawan.setPhotoKtpUrl(dtoObject.getPhotoKtpUrl());
        return relawan;
    //To change body of generated methods, choose Tools | Templates.
    }
    public List<RelawanDTO> toDTOs(List<Relawan> arg0) {
        List<RelawanDTO> res = new ArrayList<>();
        arg0.stream().forEach((o) -> {
            res.add(toDTO(o));
        });
        return res;
    }
    
    public Set<Relawan> toDomains(List<RelawanDTO> arg0) {
        Set<Relawan> res = new HashSet<>();
        arg0.stream().forEach((o) -> {
            res.add(toDomain(o));
        });
        return res;
    }
        
}
