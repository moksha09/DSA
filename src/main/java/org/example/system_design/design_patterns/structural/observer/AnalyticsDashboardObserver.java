package org.example.system_design.design_patterns.structural.observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnalyticsDashboardObserver implements StockMarketObserver{

    private final Map<String, List<Double>> stockPrices = new HashMap<>();
    @Override
    public void update(StockMarket stockMarket) {
        List<Double> prices = stockPrices.computeIfAbsent(stockMarket.getStockSymbol(), k -> new ArrayList<>());
        prices.add(stockMarket.getPrice());
        stockPrices.put(stockMarket.getStockSymbol(), prices);

        double highestPrice = 0;
        double average = 0;
        for(Double price : prices){
            highestPrice = Math.max(highestPrice, price);
            average += price;
        }
        average = average/prices.size();

        System.out.println("Highest price of stock - " + stockMarket.getStockSymbol() +" is - " + highestPrice
                            + " and average price = " + average);

    }
}
