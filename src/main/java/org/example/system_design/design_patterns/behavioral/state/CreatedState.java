package org.example.system_design.design_patterns.behavioral.state;

public class CreatedState implements OrderState {

    @Override
    public void pay(Order order, double amount) {
        order.setPaymentCaptures(true);
        System.out.println("Payment of amount " + amount + "for order - " + order.getOrderId() + " is completed.");
        order.setCurrentState(new PaidState());
    }

    @Override
    public void cancel(Order order){
        System.out.println("Order - "+ order.getOrderId() + " is cancelled");
        order.setCurrentState(new CancelledUnpaidState());
    }
}
