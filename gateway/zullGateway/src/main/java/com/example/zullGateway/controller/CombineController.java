package com.example.zullGateway.controller;

import com.example.zullGateway.service.CategoryService;
import com.example.zullGateway.service.ProductService;
import com.example.zullGateway.vo.CombineProductAndCategoryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.MalformedURLException;

/**
 * Created by ricardo on 27/12/17.
 */
@RestController
public class CombineController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/api/combine/productAndCategory")
    public CombineProductAndCategoryVO combineProductAndCategory() throws MalformedURLException {
        return new CombineProductAndCategoryVO(productService.searchProduct(),//
                categoryService.searchCategories());
    }
}
