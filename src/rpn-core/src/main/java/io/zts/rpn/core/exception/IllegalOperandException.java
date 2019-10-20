package io.zts.rpn.core.exception;

public class IllegalOperandException extends RuntimeException {

    private String illegalOperand;

    public IllegalOperandException (String operand){
        this.illegalOperand=operand;
    }

    public String toString(){
        return "IllegalOperand: "+illegalOperand;
    }
}
