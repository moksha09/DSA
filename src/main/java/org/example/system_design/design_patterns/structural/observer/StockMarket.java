package org.example.system_design.design_patterns.structural.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class StockMarket implements StockMarketSubject{

    private String stockSymbol;
    private double price;
    private int volume;

    // Thread-safe list to prevent ConcurrentModificationException
    private final List<StockMarketObserver> observers = new CopyOnWriteArrayList<>();

    @Override
    public void registerObserver(StockMarketObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(StockMarketObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for(StockMarketObserver observer : observers){
            observer.update(this);
        }
    }

    public void setStockData(String stockSymbol, double price, int volume){
        this.stockSymbol = stockSymbol;
        this.price = price;
        this.volume = volume;
        notifyObserver();
    }

    public String getStockSymbol() {
        return stockSymbol;
    }

    public double getPrice() {
        return price;
    }

    public int getVolume() {
        return volume;
    }
}
