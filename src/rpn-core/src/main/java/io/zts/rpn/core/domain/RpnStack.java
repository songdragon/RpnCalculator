package io.zts.rpn.core.domain;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * RPN numbers stack.
 *
 * @author songdragon@zts.io
 */
public class RpnStack {

    protected Stack<RpnNumber> stack=new Stack<>();

    int stackPos=0;

    public void push(RpnNumber number){
        stack.push(number);
        stackPos++;
    }

    public RpnNumber pop(){
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
        for(RpnNumber number: stack){
            displayStrBuilder.append(" ");
            displayStrBuilder.append(number);
        }
        return displayStrBuilder.toString();
    }

    public int getStackPos(){
        return stackPos;
    }

    public Stack<RpnNumber> getStack(){
        return stack;
    }
}
