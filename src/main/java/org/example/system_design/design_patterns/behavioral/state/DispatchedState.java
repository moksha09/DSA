package org.example.system_design.design_patterns.behavioral.state;

import java.time.LocalDateTime;

public class DispatchedState implements OrderState{

    @Override
    public void trackShipment(Order order, String trackingNumber){
        System.out.println("Tracking shipment status for tracking number - " + trackingNumber);
    }

    @Override
    public void deliver(Order order){
        System.out.println("Order is delivered");
        LocalDateTime deliveryDate = LocalDateTime.now();
        LocalDateTime returnExpiry = deliveryDate.plusDays(15);
        order.setReturnWindowExpiry(returnExpiry);
        order.setCurrentState(new DeliveredState());
    }

}