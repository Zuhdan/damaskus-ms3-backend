/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dans.test.recruitment.common;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author eksad-samsul
 */
public class RestTemplateExc {
    
 public static ResponseEntity restServiceExchange(String url, String uri, HttpMethod httpMethod, HttpEntity request, Class c, Object... varargs) {
        return new RestTemplate().exchange(url + uri, httpMethod, request, c, varargs);
    }
}
