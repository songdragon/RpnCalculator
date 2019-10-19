package io.zts.rpn.calculator.shell;

import io.zts.rpn.core.RpnCalculator;
import io.zts.rpn.core.RpnCalculatorFactory;
import io.zts.rpn.core.exception.InsufficientParametersException;

import java.util.Scanner;

/**
 * Command-line entrance
 */
public class ShellMain {

    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);

        RpnCalculator calculator= RpnCalculatorFactory.getBasicInstance();

        while(scanner.hasNext()){
            String input=scanner.nextLine();
            try {
                calculator.calculate(input);
                System.out.println(calculator.getRpnStack());

            } catch (InsufficientParametersException e) {
                System.out.println(e);
                System.out.println(calculator.getRpnStack());
            }
        }
    }
}
