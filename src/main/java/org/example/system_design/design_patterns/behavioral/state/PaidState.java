package org.example.system_design.design_patterns.behavioral.state;

public class PaidState implements OrderState{

    @Override
    public void prepare(Order order){
        System.out.println("Order - "+ order.getOrderId() + " is prepared");
        order.setCurrentState(new PreparedState());
    }

    @Override
    public void cancel(Order order){
        System.out.println("Canceling order - "+ order.getOrderId());
        order.setCurrentState(new CancelledPaidState());
    }
}
