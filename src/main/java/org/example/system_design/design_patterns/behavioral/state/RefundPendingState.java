package org.example.system_design.design_patterns.behavioral.state;

public class RefundPendingState implements OrderState{

    @Override
    public boolean onRefundSuccess(Order order){
        System.out.println("Refund was successful");
        order.setCurrentState(new RefundedState());
        return true;
    }
}
