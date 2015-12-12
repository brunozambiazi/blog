package com.brunozambiazi.gof.structural.decorator;

/**
 * Concrete Component implementation
 */
public class BasicComputer implements Computer {

    @Override
    public int memory() {
        return 1;
    }
}
