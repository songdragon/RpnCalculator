package io.zts.rpn.core.operator;

import io.zts.rpn.core.domain.HistoryOperationStack;
import io.zts.rpn.core.domain.Operation;
import io.zts.rpn.core.domain.RpnOperand;
import io.zts.rpn.core.domain.RpnStack;
import io.zts.rpn.core.exception.InsufficientParametersException;
import io.zts.rpn.core.operator.impl.UndoOperator;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class UndoOperatorTestCase {

    RpnStack stack=new RpnStack();
    UndoOperator undoOp=new UndoOperator();
    HistoryOperationStack historyOperationStack=new HistoryOperationStack();

    @Before
    public void before(){
        stack.clear();
        historyOperationStack.clear();
    }

    @Test
    public void testUndoOp() throws InsufficientParametersException {

        stack.push(new RpnOperand("3"));
        stack.push(new RpnOperand("2"));

        Operation oldOperation=new Operation(RpnOperator.SQRT,new RpnOperand("123"));
        historyOperationStack.push(oldOperation);

        Operation operation = undoOp.operate(stack);
        undoOp.recoverStack(stack,historyOperationStack);
        assertEquals("stack: 3 123", stack.toString());
        assertNull(operation);
    }

}
