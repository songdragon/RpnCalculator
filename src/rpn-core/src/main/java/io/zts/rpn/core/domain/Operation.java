package io.zts.rpn.core.domain;

import io.zts.rpn.core.operator.Operator;
import io.zts.rpn.core.operator.RpnOperator;

import java.util.ArrayList;
import java.util.List;

/**
 * One operator execution record
 *
 * @author songdragon@zts.io
 */
public class Operation {

    private Operator operator;

    /**
     * keep in order when numbers push into stack
     */
    private List<RpnOperand> numbers;

    public Operation(){

    }

    public Operation(RpnOperator operator, List<RpnOperand> numbers){
        this.operator=operator.getOperator();
        this.numbers=numbers;
    }

    public Operation(RpnOperator operator, RpnOperand... numbers){
        this.operator=operator.getOperator();
        this.numbers=new ArrayList<>();
        for(RpnOperand num:numbers){
            this.numbers.add(num);
        }
    }

    public Operator getOperator() {
        return operator;
    }


    public List<RpnOperand> getNumbers() {
        return numbers;
    }


}
