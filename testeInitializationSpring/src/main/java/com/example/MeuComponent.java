package com.example;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by ricardo on 01/09/16.
 */
@Component
public class MeuComponent {

    @PostConstruct
    public void init(){
        System.out.println("######################### MeuComponent.init");
    }
}
