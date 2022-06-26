package com.cg.service;

import com.cg.model.Product;

import java.util.List;

public interface IProductService extends IGeneralService<Product> {
    List<Product> findAll();

    Product findById(int productId);

}
