/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damaskus.ms3.relawan.dto;

import java.util.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author eksad-samsul
 */
@Getter
@Setter
@NoArgsConstructor
public class RelawanDTO {
    private String  jabatan;
    private String  nik;
    private String  nama;
    private Date    tanggalLahir;
    private String  jenisKelamin;
    private String  alamat;
    private String  kelurahan;
    private String  kecamatan;
    private String  photoKtpUrl;   
}
