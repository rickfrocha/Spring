package com.example.zullGateway.feign;

import org.springframework.stereotype.Service;

/**
 * Created by ricardo on 28/12/17.
 */
@Service
public class CategoryClientFallbackImpl implements CategoryClient{
    @Override
    public String[] searchCategories() {
        return new String[]{"default"};
    }
}
