package org.example.system_design.design_patterns.behavioral.state;

public class ReturnedState implements OrderState{

    @Override
    public void refund(Order order){
        System.out.println("Refund in initiated");
        order.setCurrentState(new RefundPendingState());
    }
}
