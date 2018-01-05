package com.example.zullGateway;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by ricardo on 27/12/17.
 */
@Configuration
public class GeneralConfig {

    //@Bean
    //public RestTemplate restTemplate(){
    //    return new RestTemplate();
    //}


}
