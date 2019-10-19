package io.zts.rpn.core.operator;

import io.zts.rpn.core.domain.Operation;
import io.zts.rpn.core.domain.RpnStack;
import io.zts.rpn.core.exception.InsufficientParametersException;

/**
 * Behavior of an operator in RPN
 *
 * @author songdragon@zts.io
 */
public interface Operator {

    public Operation operate(RpnStack stack) throws InsufficientParametersException;
}
