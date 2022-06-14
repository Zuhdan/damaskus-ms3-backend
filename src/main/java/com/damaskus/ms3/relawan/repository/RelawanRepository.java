/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damaskus.ms3.relawan.repository;

import com.damaskus.ms3.relawan.common.RepositoryHelper;
import com.damaskus.ms3.relawan.domain.Relawan;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author eksad-samsul
 */
public interface RelawanRepository extends RepositoryHelper<Relawan>  {
  
@Override
List<Relawan> findAll(); 

Relawan findOneByNik(String nik);

}
