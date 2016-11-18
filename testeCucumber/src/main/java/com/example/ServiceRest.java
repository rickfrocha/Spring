package com.example;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ricardo on 30/08/16.
 */
@RestController
public class ServiceRest {

    @RequestMapping("/ping")
    public String ping(){
        return "pong";
    }
}
