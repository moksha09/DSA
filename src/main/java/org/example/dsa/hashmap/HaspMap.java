package org.example.dsa.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HaspMap {

    public static void main(String[] args){

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>(List.of(1, 2, 2, 3, 1, 4, 4));

        // frequency map -
        for (int elem: list) {
            map.put(elem, map.getOrDefault(elem, 0)+1);
        }


    }
}
