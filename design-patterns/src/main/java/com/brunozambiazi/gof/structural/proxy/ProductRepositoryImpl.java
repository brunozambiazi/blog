package com.brunozambiazi.gof.structural.proxy;

/**
 * Real Subject implementation
 */
public class ProductRepositoryImpl implements ProductRepository {

    @Override
    public Product findById(Long id) {
        Product product = new Product();
        product.setId(id);
        return product;
    }
}
