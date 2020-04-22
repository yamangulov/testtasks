package ru.yamangulov.testtasks;

import ru.yamangulov.testtasks.denominators.Denominator;
import ru.yamangulov.testtasks.denominators.DenominatorFactory;

public class Main {
    public static void main(String[] args) {
        DenominatorFactory denominatorFactory = new DenominatorFactory();
        for (int i = 1; i <= 100; i++) {
            Denominator denominator = denominatorFactory.createDenominatorImpl(i);
            denominator.printNumber();
        }
    }
}
