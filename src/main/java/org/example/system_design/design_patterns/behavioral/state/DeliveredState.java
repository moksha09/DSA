package org.example.system_design.design_patterns.behavioral.state;

import java.time.LocalDateTime;

public class DeliveredState implements OrderState{

    @Override
    public void returnItem(Order order){
        if(LocalDateTime.now().isBefore(order.getReturnWindowExpiry())){
            // return done =
            System.out.println("Item - " + order.getItem().toString() + " of order = " + order.getOrderId() + "has been returned");
            order.setCurrentState(new ReturnedState());
        }else{
            System.out.println("Cannot return. Item has crossed the return delivery window.");
        }
    }
}
