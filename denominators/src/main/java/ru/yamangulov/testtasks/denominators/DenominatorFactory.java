package ru.yamangulov.testtasks.denominators;

public class DenominatorFactory {

    public Denominator createDenominatorImpl (int number) {
        Denominator denominator;
        if (number % 2 == 0 && number % 7 != 0) {
            denominator = new DenominatorImplForTwo();
        } else if (number % 2 != 0 && number % 7 == 0) {
            denominator = new DenominatorImplForSeven();
        } else if (number % 2 == 0 && number % 7 == 0) {
            denominator = new DenominatorImplForTwoSeven();
        } else {
            denominator = new DenominatorBasicImpl(number);
        }
        return denominator;
    }

}
