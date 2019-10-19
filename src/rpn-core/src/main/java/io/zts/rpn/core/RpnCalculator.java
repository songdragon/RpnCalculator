package io.zts.rpn.core;

import io.zts.rpn.core.domain.RpnStack;
import io.zts.rpn.core.exception.InsufficientParametersException;

/**
 * RpnCalculator defines operations for RPN calculation
 *
 * @author songdragon@zts.iio
 * @see
 */
public interface RpnCalculator {

    public RpnStack calculate(String str) throws InsufficientParametersException;

    public RpnStack getRpnStack();
}
