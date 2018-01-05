package com.example.zullGateway.feign;

import com.example.zullGateway.vo.ProductVO;
import org.springframework.stereotype.Service;

/**
 * Created by ricardo on 28/12/17.
 */
@Service
public class ProductClientFallbackImpl implements ProductClient{

    @Override
    public ProductVO[] searchProducts() {
        return new ProductVO[]{ new ProductVO("default","default")};
    }
}
