package br.com.wgalvao.springbootleandrocosta.utils;

import static java.lang.Math.sqrt;

import br.com.wgalvao.springbootleandrocosta.exceptions.UnsuportedMathOperationException;

public class MathUtil {

    public static Double addition(Double numberOne, Double numberTwo) throws Exception {
        return numberOne + numberTwo;
    }

    public static Double subtraction(Double numberOne, Double numberTwo) throws Exception {
        return numberOne - numberTwo;
    }

    public static Double multiplication(Double numberOne, Double numberTwo) throws Exception {
        return numberOne * numberTwo;
    }

    public static Double division(Double numberOne, Double numberTwo) throws Exception {
        return numberOne / numberTwo;
    }

    public static Double average(Double numberOne, Double numberTwo) throws Exception {
        return (numberOne + numberTwo) / 2;
    }

    public static Double extractSquareRoot(Double number) throws Exception {
        return sqrt(number);
    }

    public static double StringToDouble(String strNumber, boolean zeroNotAllowed) {
        strNumber = strNumber.replaceAll(",", ".");
        boolean isNumber = strNumber.matches("[-+]?[0-9]*\\.?[0-9]+");
        double doubleNumber = 0d;
        if (isNumber) {
            doubleNumber = Double.parseDouble(strNumber);
            if (zeroNotAllowed && doubleNumber == 0d)
                throw new UnsuportedMathOperationException("divisor greater than zero required");
        } else {
            throw new UnsuportedMathOperationException("required numeric value");
        }
        return doubleNumber;
    }
}
