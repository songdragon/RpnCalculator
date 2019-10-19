package io.zts.rpn.core.exception;

import io.zts.rpn.core.operator.RpnOperator;

/**
 * An operator will throw this exception when it cannot find a sufficient number of parameters
 *
 * @author songdragon@zts.io
 */
public class InsufficientParametersException extends Exception {

    private static final String OUTPUT_TEMPLATE = "operator <operator> (position:<pos>): insufficient parameters";

    private int position;

    private RpnOperator operator;

    public InsufficientParametersException(RpnOperator operator) {
        this.operator = operator;
    }

    public InsufficientParametersException(RpnOperator operator, int position) {
        this(operator);
        this.position=position;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return OUTPUT_TEMPLATE
                .replace("<operator>", operator.getOpStr())
                .replace("<pos>", String.valueOf(position));
    }


}
