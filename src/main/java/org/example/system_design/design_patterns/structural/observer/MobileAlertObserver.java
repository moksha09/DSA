package org.example.system_design.design_patterns.structural.observer;

public class MobileAlertObserver implements StockMarketObserver {

    private double threshold;

    public MobileAlertObserver(double threshold){
        this.threshold = threshold;
    }
    @Override
    public void update(StockMarket stock) {
        if(stock.getPrice() > threshold){
            System.out.println("ALERT - " + stock.getStockSymbol() + " crossed threshold! Current price: "+ stock.getPrice());
        }
    }
}
