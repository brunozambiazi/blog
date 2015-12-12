package com.brunozambiazi.gof.structural.decorator;

/**
 * Concrete Decorator implementation
 */
public class BusinessComputer extends PowerfulComputer {

    public BusinessComputer(final Computer originalComputer) {
        super(originalComputer);
    }

    @Override
    public int extraMemory() {
        return 1;
    }
}
