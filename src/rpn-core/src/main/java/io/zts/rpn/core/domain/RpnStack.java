package io.zts.rpn.core.domain;

import java.util.Stack;

/**
 * RPN numbers stack.
 *
 * @author songdragon@zts.io
 */
public class RpnStack {

    protected Stack<RpnNumber> stack=new Stack<>();

    public void push(RpnNumber number){
        stack.push(number);
    }

    public RpnNumber pop(){
        return stack.pop();
    }

    public void clear(){
        stack.clear();
    }

    public String toString(){
        StringBuilder displayStrBuilder=new StringBuilder("stack:");
        for(RpnNumber number: stack){
            displayStrBuilder.append(" ");
            displayStrBuilder.append(number);
        }
        return displayStrBuilder.toString();
    }
}
