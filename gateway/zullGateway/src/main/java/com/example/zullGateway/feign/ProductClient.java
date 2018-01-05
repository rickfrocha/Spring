package com.example.zullGateway.feign;

import com.example.zullGateway.vo.ProductVO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ricardo on 28/12/17.
 */
@FeignClient(name = "products", fallback = ProductClientFallbackImpl.class)
public interface ProductClient {

    @RequestMapping("/products")
    ProductVO[] searchProducts();
}
