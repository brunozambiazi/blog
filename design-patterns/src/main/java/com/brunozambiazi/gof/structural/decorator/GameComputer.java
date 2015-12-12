package com.brunozambiazi.gof.structural.decorator;

/**
 * Concrete Decorator implementation
 */
public class GameComputer extends PowerfulComputer {

    public GameComputer(final Computer originalComputer) {
        super(originalComputer);
    }

    @Override
    public int extraMemory() {
        return 2;
    }
}
