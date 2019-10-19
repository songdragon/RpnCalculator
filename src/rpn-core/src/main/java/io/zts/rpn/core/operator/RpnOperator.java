package io.zts.rpn.core.operator;

import io.zts.rpn.core.operator.impl.*;

public enum RpnOperator {


    ADDITION(new AdditionOperator(),"+"),
    SUBTRACTION(new SubtractionOperator(),"-"),
    MULTIPLICATION(new MultiplicationOperator(),"*"),
    DIVISION(new DivisionOperator(),"/"),
    SQRT(new SqrtOperator(),"sqrt"),
    CLEAR(new ClearOperator(),"clear"),
    UNDO(new UndoOperator(),"undo"),
    UNKNOWN(null,"")
    ;

    private Operator operator;
    private String opStr;

    RpnOperator(Operator op, String opStr){
        this.operator=op;
        this.opStr=opStr;
    }

    public Operator getOperator(){
        return this.operator;
    }

    public RpnOperator parseOf(String op){
        for(RpnOperator operator: RpnOperator.values()){
            if(operator.opStr.equals(op)){
                return operator;
            }
        }
        return UNKNOWN;
    }

}
