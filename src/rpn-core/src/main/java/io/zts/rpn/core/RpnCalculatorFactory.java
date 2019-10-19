package io.zts.rpn.core;

import io.zts.rpn.core.impl.BasicRpnCalculator;

public class RpnCalculatorFactory {

    private static BasicRpnCalculator basicRpnCalculator=null;

    public static RpnCalculator getBasicInstance(){
        if(basicRpnCalculator==null){
            synchronized (RpnCalculatorFactory.class){
                if(basicRpnCalculator==null){
                    basicRpnCalculator=new BasicRpnCalculator();
                }
            }
        }

        return basicRpnCalculator;
    }
}
