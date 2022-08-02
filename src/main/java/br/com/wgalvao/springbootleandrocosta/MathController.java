package br.com.wgalvao.springbootleandrocosta;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.wgalvao.springbootleandrocosta.exceptions.UnsuportedMathOperationException;

@RestController
public class MathController {

    // private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(@PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if (isNumeric(numberOne) && isNumeric(numberTwo)) {
            return covertToDouble(numberOne) + covertToDouble(numberTwo);
        }
        throw new UnsuportedMathOperationException("required numeric value");
    }

    @RequestMapping(value = "/subtraction/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double subtraction(@PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if (isNumeric(numberOne) && isNumeric(numberTwo)) {
            return covertToDouble(numberOne) - covertToDouble(numberTwo);
        }
        throw new UnsuportedMathOperationException("required numeric value");
    }

    @RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double multiplication(@PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if (isNumeric(numberOne) && isNumeric(numberTwo)) {
            return covertToDouble(numberOne) * covertToDouble(numberTwo);
        }
        throw new UnsuportedMathOperationException("required numeric value");
    }

    @RequestMapping(value = "/division/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double division(@PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if (isNumeric(numberOne) && isNumeric(numberTwo)) {
            if (covertToDouble(numberTwo) > 0) {
                return covertToDouble(numberOne) / covertToDouble(numberTwo);
            }
            throw new UnsuportedMathOperationException("divisor greater than zero required");
        }
        throw new UnsuportedMathOperationException("required numeric value");
    }

    @RequestMapping(value = "/average/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double average(@PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if (isNumeric(numberOne) && isNumeric(numberTwo)) {
            return (covertToDouble(numberOne) + covertToDouble(numberTwo)) / 2;
        }
        throw new UnsuportedMathOperationException("required numeric value");
    }

    @RequestMapping(value = "/squareRoot/{number}", method = RequestMethod.GET)
    public Double squareRoot(@PathVariable(value = "number") String number)
            throws Exception {
        if (isNumeric(number)) {
            return Math.sqrt(covertToDouble(number));
        }
        throw new UnsuportedMathOperationException("required numeric value");
    }

    private Double covertToDouble(String strNumber) {
        if (strNumber == null)
            return 0d;
        String number = strNumber.replaceAll(",", ".");
        if (isNumeric(number))
            return Double.parseDouble(number);
        return 0d;
    }

    private boolean isNumeric(String strNumber) {
        if (strNumber == null)
            return false;
        String number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
