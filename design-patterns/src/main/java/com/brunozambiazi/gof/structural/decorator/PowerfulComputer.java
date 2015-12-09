package com.brunozambiazi.gof.structural.decorator;

public abstract class PowerfulComputer implements Computer {

    private final Computer originalComputer;


    protected PowerfulComputer(final Computer originalComputer) {
        this.originalComputer = originalComputer;
    }

    @Override
    public int memory() {
        return getOriginalComputer().memory() + extraMemory();
    }

    public abstract int extraMemory();

    protected Computer getOriginalComputer() {
        return originalComputer;
    }
}
