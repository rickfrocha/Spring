package com.example.zullGateway.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by ricardo on 27/12/17.
 */
public class CombineProductAndCategoryVO {

    @JsonProperty("products")
    private Collection<ProductVO> productListVo;

    @JsonProperty("categories")
    private Collection<String> categoryList;

    public CombineProductAndCategoryVO(ProductVO[] productArray, String[] categoryArray) {
        this.productListVo = Arrays.asList(productArray);
        this.categoryList = Arrays.asList(categoryArray);
    }


    public Collection<ProductVO> getProductListVo() {
        return productListVo;
    }

    public void setProductListVo(Collection<ProductVO> productListVo) {
        this.productListVo = productListVo;
    }

    public Collection<String> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(Collection<String> categoryList) {
        this.categoryList = categoryList;
    }
}
