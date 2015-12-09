package com.brunozambiazi.gof.structural.proxy;

import java.util.UUID;

public class Product {

    private final String hash = UUID.randomUUID().toString();

    private Long id;

    public String getHash() {
        return hash;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
