package com.example.zullGateway.service;

import com.example.zullGateway.exception.ServiceUnavaliableException;
import com.example.zullGateway.feign.ProductClient;
import com.example.zullGateway.vo.ProductVO;
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
public class ProductService {

//    @Autowired
//    private RestTemplate restTemplate;
//
//    @Autowired
//    private LoadBalancerClient loadBalancer;

    @Autowired
    private ProductClient productClient;

    public ProductVO[] searchProduct() throws MalformedURLException, ServiceUnavaliableException {
//        URI productUri = loadBalancer.choose("products").getUri();
//        ResponseEntity<ProductVO[]> productEntityVO = restTemplate.getForEntity(productUri.toURL().toString() + "/products", ProductVO[].class);
//        if(productEntityVO.getStatusCode().value() != 200){
//            throw new ServiceUnavaliableException();
//        }
//        return productEntityVO.getBody();
        return productClient.searchProducts();
    }

}
