package com.brunozambiazi.gof.structural.proxy;

public class ProductRepositoryImpl implements ProductRepository {

    @Override
    public Product findById(Long id) {
        Product product = new Product();
        product.setId(id);
        return product;
    }
}
