package org.example.dsa.sets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Sets {
    public static void main(String[] args){
        List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        int target = 3;
        System.out.println(list.contains(target));

        // using set - searching for element is most efficient in set
        // look ups - O(1) on average
        Set<Integer> set = new HashSet<>(list);
        System.out.println(set.contains(target));




    }
}
