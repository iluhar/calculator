package com.hillel.iriazanov.calc.actions;

public class Plus implements Action {

    @Override
    public double act(double first, double second) {
        return first + second;
    }

}