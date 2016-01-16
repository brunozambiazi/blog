package com.brunozambiazi.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecondService {

    @Autowired
    private FirstService firstService;

    public boolean isEverythingOk() {
        return firstService.doSomething();
    }

}
