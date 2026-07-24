package org.example.system_design.design_patterns.structural.observer;

public class TradingBotObserver implements StockMarketObserver{

    private final double buyThreshold;

    public TradingBotObserver(double buyThreshold){
        this.buyThreshold = buyThreshold;
    }
    @Override
    public void update(StockMarket stockMarket) {
        if(stockMarket.getPrice() < buyThreshold){
            System.out.println("[AUTO-TRADE] Buying 100 shares of " + stockMarket.getStockSymbol() + " at " + stockMarket.getPrice());
            // Observers should never modify the state of the Subject directly inside their update() callback
//          stockMarket.setStockData(stockMarket.getStockSymbol(), stockMarket.getPrice(),100);
        }
    }
}
