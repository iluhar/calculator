package com.hillel.iriazanov.calc.actions;

public class Divide implements Action {

    @Override
    public double act(double first, double second) {
        return first / second;
    }

}
