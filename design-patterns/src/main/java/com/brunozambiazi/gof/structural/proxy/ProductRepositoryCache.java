package com.brunozambiazi.gof.structural.proxy;

import java.util.HashMap;
import java.util.Map;

public class ProductRepositoryCache implements ProductRepository {

    private final ProductRepository realRepository = new ProductRepositoryImpl();
    private final Map<Long, Product> cache = new HashMap<>();

    @Override
    public Product findById(Long id) {
        if (!cache.containsKey(id)) {
            cache.put(id, realRepository.findById(id));
        }

        return cache.get(id);
    }
}
