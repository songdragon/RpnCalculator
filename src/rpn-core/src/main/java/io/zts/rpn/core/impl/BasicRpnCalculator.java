package io.zts.rpn.core.impl;

import io.zts.rpn.core.RpnCalculator;
import io.zts.rpn.core.domain.HistoryOperationStack;
import io.zts.rpn.core.domain.Operation;
import io.zts.rpn.core.domain.RpnNumber;
import io.zts.rpn.core.domain.RpnStack;
import io.zts.rpn.core.exception.InsufficientParametersException;
import io.zts.rpn.core.operator.RpnOperator;
import io.zts.rpn.core.operator.impl.UndoOperator;

/**
 * Thread-safe basic RPN calculator. Stack and historical operation stack are implemented by thread local variables.
 * Therefore it will be safe when there are multi-threads.
 *
 * This basic calculator also record all opeartions in order that it is able to undo previous operations.
 */
public class BasicRpnCalculator implements RpnCalculator {

    protected ThreadLocal<RpnStack> rpnStackThreadLocal = new ThreadLocal<>();
    protected ThreadLocal<HistoryOperationStack> historyOperationStackThreadLocal = new ThreadLocal<>();

    public BasicRpnCalculator() {
        this.rpnStackThreadLocal.set(new RpnStack());
        this.historyOperationStackThreadLocal.set(new HistoryOperationStack());
    }

    @Override
    public RpnStack calculate(String str) throws InsufficientParametersException {
        if (str == null || str.isEmpty()) {
            return rpnStackThreadLocal.get();
        }

        String[] inputs = str.split(" ");
        RpnStack rpnStack = rpnStackThreadLocal.get();
        for (String input : inputs) {
            RpnOperator rpnOp = RpnOperator.parseOf(input);
            switch (rpnOp) {
                case UNKNOWN:
                    RpnNumber rpnNumber=new RpnNumber(input);
                    rpnStack.push(rpnNumber);
                    Operation operation=new Operation(RpnOperator.PUSH,rpnNumber);
                    historyOperationStackThreadLocal.get().push(operation);
                    break;
                case UNDO:
                    rpnOp.getOperator().operate(rpnStack);
                    ((UndoOperator)rpnOp.getOperator()).recoverStack(rpnStack,historyOperationStackThreadLocal.get());
                    break;
                default:
                    Operation opeartion = rpnOp.getOperator().operate(rpnStack);
                    historyOperationStackThreadLocal.get().push(opeartion);

            }
        }

        return rpnStack;
    }

    @Override
    public RpnStack getRpnStack() {
        return rpnStackThreadLocal.get();
    }
}
