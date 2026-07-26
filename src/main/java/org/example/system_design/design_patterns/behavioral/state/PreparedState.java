package org.example.system_design.design_patterns.behavioral.state;

import java.util.random.RandomGenerator;

public class PreparedState implements OrderState{

    @Override
    public void ship(Order order, String trackingNumber){
        System.out.println("Order - " + order.getOrderId() + "is shipped with trackingId = " + trackingNumber);
        order.setTrackingNumber(trackingNumber);
        order.setCurrentState(new DispatchedState());
    }
}
