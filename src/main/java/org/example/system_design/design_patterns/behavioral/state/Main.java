package org.example.system_design.design_patterns.behavioral.state;

import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args){
        List<String> item = new ArrayList<>();
        item.add("PS-5");
        item.add("Laptop");
        Order order = new Order("Order123", item);

        order.pay(100);
        order.cancel();;

    }


}
