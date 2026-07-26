package org.example.system_design.design_patterns.behavioral.state;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private final String orderId;
    private final List<String> item;
    private String trackingNumber;
    private OrderState currentState;
    private boolean paymentCaptures;
    private LocalDateTime returnWindowExpiry;

    public Order(String orderId, List<String> item){
        this.orderId = orderId;
        this.item = item;
        this.currentState = new CreatedState(); // initial state
        this.paymentCaptures = false;
    }

    public void setCurrentState(OrderState orderState){
        this.currentState = orderState;
    }

    public String getOrderId() {
        return orderId;
    }

    public List<String> getItem() {
        return item;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public OrderState getCurrentState() {
        return currentState;
    }

    public boolean isPaymentCaptures() {
        return paymentCaptures;
    }

    public LocalDateTime getReturnWindowExpiry() {
        return returnWindowExpiry;
    }

    public void setPaymentCaptures(boolean paymentCaptures){
        this.paymentCaptures = paymentCaptures;
    }

    public void setTrackingNumber(String trackingNumber){
        this.trackingNumber = trackingNumber;
    }

    public void setReturnWindowExpiry(LocalDateTime dateTime){
        this.returnWindowExpiry = dateTime;
    }

    public void pay(double amount){
        this.currentState.pay(this, amount);
    }

    public void cancel(){
        this.currentState.cancel(this);
    }
    public void prepare(){
        this.currentState.prepare(this);
    }
    public void ship(String trackingNumber){
        this.currentState.ship(this, trackingNumber);
    }
    public void trackShipment(String trackingNumber){
        this.currentState.trackShipment(this, trackingNumber);
    }
    public void deliver(){
        this.currentState.deliver(this);
    }
    public void refund(){
        this.currentState.refund(this);
    }
    public void returnItem(){
        this.currentState.returnItem(this);
    }
    public boolean onRefundSuccess(){
        return this.currentState.onRefundSuccess(this);
    }
}
