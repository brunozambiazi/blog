package com.brunozambiazi.gof.structural.proxy;

/**
 * Subject interface
 */
public interface ProductRepository {

    Product findById(Long id);
}
