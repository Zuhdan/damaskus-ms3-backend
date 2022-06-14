/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damaskus.ms3.relawan.domain;

import java.util.Date;
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
@Table(name = "RELAWAN")
public class Relawan {
    @Id
    @GeneratedValue(generator = "trx_relawan_gen")
    @SequenceGenerator(name="trx_relawan_gen", sequenceName = "trx_relawan_seq")   
    private Integer id;
    private String  jabatan;
    private String  nik;
    private String  nama;
    private Date    tanggalLahir;
    private String  jenisKelamin;
    private String  alamat;
    private String  kelurahan;
    private String  kecamatan;
    private String  photoKtpUrl;

    public Relawan() {
    }
    
    
    public Relawan(Integer id, String jabatan, String nik, String nama, Date tanggalLahir, String jenisKelamin, String alamat, String kelurahan, String kecamatan, String photoKtpUrl) {
        this.id = id;
        this.jabatan = jabatan;
        this.nik = nik;
        this.nama = nama;
        this.tanggalLahir = tanggalLahir;
        this.jenisKelamin = jenisKelamin;
        this.alamat = alamat;
        this.kelurahan = kelurahan;
        this.kecamatan = kecamatan;
        this.photoKtpUrl = photoKtpUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Date getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(Date tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getKelurahan() {
        return kelurahan;
    }

    public void setKelurahan(String kelurahan) {
        this.kelurahan = kelurahan;
    }

    public String getKecamatan() {
        return kecamatan;
    }

    public void setKecamatan(String kecamatan) {
        this.kecamatan = kecamatan;
    }

    public String getPhotoKtpUrl() {
        return photoKtpUrl;
    }

    public void setPhotoKtpUrl(String photoKtpUrl) {
        this.photoKtpUrl = photoKtpUrl;
    }
    
    
    
    
}
