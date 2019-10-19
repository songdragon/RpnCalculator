package io.zts.rpn.core.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Number in RPN Calculator
 *
 * @author songdragon@zts.io
 */
public class RpnNumber {

    private static final int MAX_DISPLAY_PRECISION=10;

    private BigDecimal number;

    public RpnNumber(){

    }

    public RpnNumber(String num){
        this.number=new BigDecimal(num);
    }

    public BigDecimal getNumber() {
        return number;
    }

    public void setNumber(BigDecimal number) {
        this.number = number;
    }

    /**
     * Dispalyed to 10 decimal places or less if no loss of precision
     * @return empty string if number is null
     *         else is number in plaint string no more than 10 decimal places
     */
    public String toString(){

        if(number==null){
            return "";
        }

        BigDecimal displayNum=new BigDecimal(number.toPlainString());
        if(displayNum.scale()>MAX_DISPLAY_PRECISION) {
            displayNum=displayNum.setScale(MAX_DISPLAY_PRECISION, RoundingMode.DOWN);
        }
        return displayNum.toPlainString();
    }
}
