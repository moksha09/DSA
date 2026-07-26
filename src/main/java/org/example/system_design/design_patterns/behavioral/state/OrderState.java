package org.example.system_design.design_patterns.behavioral.state;

public interface OrderState {

    default void pay(Order order, double amount){
        throw new IllegalStateException("Payment not allowed in current state");
    }
    default void cancel(Order order){
        throw new IllegalStateException("Cannot cancel in current state");
    }
    default void prepare(Order order){
        throw new IllegalStateException("Cannot prepare int current state");
    }
    default void ship(Order order, String trackingNumber){
        throw new IllegalStateException("Cannot ship in current state");
    }
    default void trackShipment(Order order, String trackingNumber){
        throw new IllegalStateException("Cannot track shipment in current state");
    }
    default void deliver(Order order){
        throw new IllegalStateException("Cannot deliver in current state");
    }
    default void refund(Order order){
        throw new IllegalStateException("Cannot perform refund in current state");
    }
    default void returnItem(Order order){
        throw new IllegalStateException("Cannot return item in current state");
    }
    default boolean onRefundSuccess(Order order){
        throw new IllegalStateException("Cannot check refund status in current state");
    }

}
