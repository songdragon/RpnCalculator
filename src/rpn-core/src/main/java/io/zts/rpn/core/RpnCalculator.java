package io.zts.rpn.core;

import io.zts.rpn.core.domain.RpnStack;
import io.zts.rpn.core.exception.InsufficientParametersException;

public interface RpnCalculator {

    public RpnStack calculate(String str) throws InsufficientParametersException;

    public RpnStack getRpnStack();
}
