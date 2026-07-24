package org.example.system_design.design_patterns.structural.observer;

public interface StockMarketSubject {
    void registerObserver(StockMarketObserver observer);
    void removeObserver(StockMarketObserver observer);
    void notifyObserver();
}
