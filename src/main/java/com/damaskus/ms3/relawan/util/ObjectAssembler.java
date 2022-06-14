/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damaskus.ms3.relawan.util;

/**
 *
 * @author eksad-samsul
 */
public interface ObjectAssembler<A,B> {
    B toDTO(A domainObject);
    A toDomain(B dtoObject);
    
}
