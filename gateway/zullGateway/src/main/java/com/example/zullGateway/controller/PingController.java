package com.example.zullGateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ricardo on 27/12/17.
 */
@RestController
public class PingController {

    @GetMapping("/api/ping")
    public String ping(){
        return "pong";
    }

}
