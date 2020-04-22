package ru.yamangulov.testtasks.factorialUtils;

import java.math.BigInteger;

public class FactorialUtil {
    // отказ от рекурсии - сознательный, чтобы не плодить переменные, особенно для больших чисел
    private static BigInteger factorial(int m) {
        BigInteger factorial = BigInteger.ONE;
        for (int i = 1; i <= m; ++i) factorial = factorial.multiply(BigInteger.valueOf(i));
        return factorial;
    }

    // оптимизированное вычисление m! / r! без лишних циклов умножения вначале, как если бы вычислялись сначала оба факториала, а потом они делились строго по формуле
    private static BigInteger factorialExtended(int m, int r) {
        BigInteger factorial = BigInteger.ONE;
        for (int i = r + 1; i <= m; ++i) factorial = factorial.multiply(BigInteger.valueOf(i));
        return factorial;
    }

    public static BigInteger formula(int m, int r) {
        return factorialExtended(m, r).divide(factorial(m - r));
    }
}
