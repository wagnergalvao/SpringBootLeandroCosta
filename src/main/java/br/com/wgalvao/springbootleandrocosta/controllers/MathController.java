package br.com.wgalvao.springbootleandrocosta.controllers;

import static br.com.wgalvao.springbootleandrocosta.utils.MathUtil.StringToDouble;
import static br.com.wgalvao.springbootleandrocosta.utils.MathUtil.addition;
import static br.com.wgalvao.springbootleandrocosta.utils.MathUtil.average;
import static br.com.wgalvao.springbootleandrocosta.utils.MathUtil.division;
import static br.com.wgalvao.springbootleandrocosta.utils.MathUtil.extractSquareRoot;
import static br.com.wgalvao.springbootleandrocosta.utils.MathUtil.multiplication;
import static br.com.wgalvao.springbootleandrocosta.utils.MathUtil.subtraction;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

    // private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(@PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo) throws Exception {

        return addition(StringToDouble(numberOne, false), StringToDouble(numberTwo, false));
    }

    @RequestMapping(value = "/subtract/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double subtract(@PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo) throws Exception {

        return subtraction(StringToDouble(numberOne, false), StringToDouble(numberTwo, false));
    }

    @RequestMapping(value = "/multiplies/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double multiplies(@PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo) throws Exception {

        return multiplication(StringToDouble(numberOne, false), StringToDouble(numberTwo, false));
    }

    @RequestMapping(value = "/divide/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double divide(@PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo) throws Exception {

        return division(StringToDouble(numberOne, false), StringToDouble(numberTwo, true));
    }

    @RequestMapping(value = "/mean/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double mean(@PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo) throws Exception {

        return average(StringToDouble(numberOne, false), StringToDouble(numberTwo, false));
    }

    @RequestMapping(value = "/squareRoot/{number}", method = RequestMethod.GET)
    public Double squareRoot(@PathVariable(value = "number") String number)
            throws Exception {

        return extractSquareRoot(StringToDouble(number, false));
    }
}
