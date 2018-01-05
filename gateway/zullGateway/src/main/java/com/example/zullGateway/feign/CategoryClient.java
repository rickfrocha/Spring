package com.example.zullGateway.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ricardo on 28/12/17.
 */
@FeignClient(name = "categories", fallback = CategoryClientFallbackImpl.class)
public interface CategoryClient {

    @RequestMapping("/categories")
    String[] searchCategories();

}
