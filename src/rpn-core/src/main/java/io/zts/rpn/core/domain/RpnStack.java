package io.zts.rpn.core.domain;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * RPN numbers stack.
 *
 * @author songdragon@zts.io
 */
public class RpnStack {

    protected Stack<RpnOperand> stack=new Stack<>();

    int stackPos=0;

    public void push(RpnOperand number){
        stack.push(number);
        stackPos++;
    }

    public RpnOperand pop(){
        try {
            stackPos++;
            return stack.pop();
        }
        catch (EmptyStackException e){
            return null;
        }
    }

    public void clear(){
        stack.clear();
        stackPos=0;
    }

    public String toString(){
        StringBuilder displayStrBuilder=new StringBuilder("stack:");
        for(RpnOperand number: stack){
            displayStrBuilder.append(" ");
            displayStrBuilder.append(number);
        }
        return displayStrBuilder.toString();
    }

    public int getStackPos(){
        return stackPos;
    }

    public Stack<RpnOperand> getStack(){
        return stack;
    }
}
