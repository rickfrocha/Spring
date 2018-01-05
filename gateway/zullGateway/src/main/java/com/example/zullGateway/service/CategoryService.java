package com.example.zullGateway.service;

import com.example.zullGateway.exception.ServiceUnavaliableException;
import com.example.zullGateway.feign.CategoryClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.MalformedURLException;
import java.net.URI;

/**
 * Created by ricardo on 27/12/17.
 */
@Service
public class CategoryService {

//    @Autowired
//    private LoadBalancerClient loadBalancer;
//
//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private CategoryClient categoryClient;

    public   String[] searchCategories() throws MalformedURLException {
//        URI categoriesUri = loadBalancer.choose("categories").getUri();
//        ResponseEntity<String[]> categorieEntityVO = restTemplate.getForEntity(categoriesUri.toURL().toString() + "/categories", String[].class);
//        if(categorieEntityVO.getStatusCode().value() != 200){
//            throw new ServiceUnavaliableException();
//        }
//        return categorieEntityVO.getBody();
        return categoryClient.searchCategories();
    }


}
