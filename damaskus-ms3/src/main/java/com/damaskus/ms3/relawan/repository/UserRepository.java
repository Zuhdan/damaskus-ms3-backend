/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damaskus.ms3.relawan.repository;

import com.damaskus.ms3.relawan.common.RepositoryHelper;
import com.damaskus.ms3.relawan.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author eksad-samsul
 */
@Repository
public interface UserRepository extends RepositoryHelper<User> {
  @Query("Select u From User u Where u.username = ?1 And u.password = ?2 ")
  User getUserByUsernamAndPassword(String username, String password);  
}
