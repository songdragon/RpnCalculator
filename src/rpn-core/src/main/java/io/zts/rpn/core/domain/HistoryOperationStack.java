package io.zts.rpn.core.domain;

import io.zts.rpn.core.operator.RpnOperator;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * History Operation Stack is responsible for storing historical operations details.
 *
 * @author songdragon@zts.io
 */
public class HistoryOperationStack {

    private Stack<Operation> historyStack=new Stack<>();

    /**
     * get latest operation
     * @return null or Operation if exists
     */
    public Operation pop(){
        try {
            return historyStack.pop();
        }
        catch (EmptyStackException e){
            return null;
        }
    }

    public void push(Operation operation){
        if(operation==null){
            return;
        }

        historyStack.push(operation);
    }

    public void recordOperation(RpnOperator op, RpnNumber ... numbers){

    }

    public void clear(){
        this.historyStack.clear();
    }
}
