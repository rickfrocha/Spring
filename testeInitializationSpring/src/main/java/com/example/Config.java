package com.example;

/**
 * Created by ricardo on 01/09/16.
 */

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
@EnableAutoConfiguration
public class Config {

    @PostConstruct
    public void init(){
        System.out.println(">>>>>>>>>>>>>>>>> Config.init");
    }
}
