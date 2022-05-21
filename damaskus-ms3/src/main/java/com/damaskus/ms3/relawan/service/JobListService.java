/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dans.test.recruitment.service;

import com.dans.test.recruitment.dto.JobDTO;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class JobListService {

    @Value("${json.job.list}")
    private String JOB_LIST_JSON;

    @Value("${api.job.detail}")
    private String JOB_DETAIL_API;

    RestTemplate restTemplate = new RestTemplate();

    public ResponseEntity<List<JobDTO>> getJobs() {
        List<JobDTO> list = new ArrayList<>();
        ObjectMapper obm = new ObjectMapper();
        try {
            String res = restTemplate.getForObject(
                        JOB_LIST_JSON, 
                        String.class);
            JobDTO[] jobs = new Gson().fromJson(res, JobDTO[].class);
            list = Arrays.asList(jobs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    public ResponseEntity<JobDTO> getJobDetail(String id) {
        JobDTO data = null;
        List<JobDTO> list = new ArrayList<>();
        try {
            if(id != null) {
            String res = restTemplate.getForObject(
                        JOB_LIST_JSON, 
                        String.class);
            JobDTO[] jobs = new Gson().fromJson(res, JobDTO[].class);
            list = Arrays.asList(jobs);
            for(JobDTO job : jobs){
                if(job.getId().equals(id)){
                    data=job;
                }
                
            }
                
//                String res = restTemplate.getForObject(
//                        JOB_DETAIL_API, 
//                        String.class, id);
//                data = new Gson().fromJson(res, JobDTO.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.OK).body(data);
    }
    public ResponseEntity<List<Integer>> getFibonaci(int numberReq){
        List<Integer> resultFibonaci = calculateFIbonaci(numberReq);
        return  ResponseEntity.status(HttpStatus.OK).body(resultFibonaci);
    }
    public List<Integer> calculateFIbonaci(int numberReq){
        List<Integer> result=new ArrayList<>();  
       int nextNumber=1;
       int prevNumber =0;
        // req = 5
       for(int i=1;i<=numberReq;i++){
           
          // sumary =0;
        //   sumary = 0+1
        //          prevNumber=1
        //          nextNumber = 1
        //          nextNumber=sumary  = 1+1
        //    nextNumber= 2
        //    addKe List
          // 
            int sumary = prevNumber+nextNumber; //=1 // = 1+1
            prevNumber=nextNumber; //prevNumber = 1 = 1 // 2
            System.out.println("prevNumber "+prevNumber);
            nextNumber=sumary; // = 1 // = 2
            result.add(nextNumber);
        }
        return result;
    }
   
    
}
