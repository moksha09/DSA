package org.example.system_design.design_patterns.structural.observer;

public class Main {

    public static void main(String[] args){
        StockMarket stockMarket = new StockMarket();

        MobileAlertObserver mobileAlertObserver = new MobileAlertObserver(150);
        AnalyticsDashboardObserver analyticsDashboardObserver = new AnalyticsDashboardObserver();
        TradingBotObserver tradingBotObserver = new TradingBotObserver(120);

        stockMarket.registerObserver(mobileAlertObserver);
        stockMarket.registerObserver(analyticsDashboardObserver);
        stockMarket.registerObserver(tradingBotObserver);

        // 1) Multi-Observer Notification: Create a StockMarket instance for "AAPL", register all three observers,
        // and push 2–3 price updates (e.g., $180.0, $205.0, $145.0). Verify that all registered observers react accordingly.
        stockMarket.setStockData("AAPL", 180, 2);
        stockMarket.setStockData("AAPL", 205, 1);
        stockMarket.setStockData("AAPL", 145, 3);
        System.out.println();

        // 2) Dynamic Unregistration: Unregister the MobileAlertObserver dynamically using removeObserver().
        //   Push another price update ($210.0) and verify that the mobile alert does not trigger,
        //   while the Analytics Dashboard and Trading Bot still process the update.

        stockMarket.removeObserver(mobileAlertObserver);
        stockMarket.setStockData("AAPL", 210.0, 1);
    }
}
