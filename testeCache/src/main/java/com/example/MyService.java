package com.example;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Created by ricardo on 29/09/16.
 */
@Component
public class MyService {

    @Cacheable("abc")
    public boolean execSlowMethod() throws InterruptedException {
        System.out.println("Iniciando metodo lento");
        TimeUnit.SECONDS.sleep(10);
        System.out.println("Finalizando metodo lento");
        return false;
    }
}
