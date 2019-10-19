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
    private List<RpnNumber> numbers;

    public Operation(){

    }

    public Operation(RpnOperator operator, List<RpnNumber> numbers){
        this.operator=operator.getOperator();
        this.numbers=numbers;
    }

    public Operation(RpnOperator operator, RpnNumber ... numbers){
        this.operator=operator.getOperator();
        this.numbers=new ArrayList<>();
        for(RpnNumber num:numbers){
            this.numbers.add(num);
        }
    }

    public Operator getOperator() {
        return operator;
    }


    public List<RpnNumber> getNumbers() {
        return numbers;
    }


}
