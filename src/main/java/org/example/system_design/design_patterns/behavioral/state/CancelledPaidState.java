package org.example.system_design.design_patterns.behavioral.state;

public class CancelledPaidState implements OrderState {

    @Override
    public void refund(Order order){
        System.out.println("Refund initiation for order - " +order.getOrderId()+" has started");
        order.setCurrentState(new RefundPendingState());
    }
}
