package ru.yamangulov.testtasks.denominators;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class DenominatorBasicImpl implements Denominator {
    private int number;

    @Override
    public void printNumber() {
        System.out.println(number);
    }
}
