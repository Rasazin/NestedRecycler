package com.menglang.nestedrecyclerview.model;

import java.util.List;

public class Category {
    private String categoryTitle;
    private List<Product> productList;

    public Category(String categoryTitle, List<Product> productList) {
        this.categoryTitle = categoryTitle;
        this.productList = productList;
    }

    public String getCategoryTitle() { return categoryTitle; }
    public List<Product> getProductList() { return productList; }
}
