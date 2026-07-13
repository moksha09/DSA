package org.example.dsa.hashmap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;

public class HashMapMain {

    public static void main(String[] args){
        String name = "Rahul";
        int nameHash = name.hashCode();
        System.out.println(nameHash);

        // if its an integer upto a range it will give you the same number as its hascode -
        Integer a = 123456;
        int aHash = a.hashCode();
        System.out.println(aHash);

        HashMap<String, Integer> map = new HashMap<>();
        map.put("Kunal", 89);
        map.put("Moksha", 99);
        map.put("Rahul", 94);

        System.out.println(map.get("Moksha"));
        System.out.println(map.getOrDefault("Goutami", 78));

        System.out.println(map.containsKey("Moksha"));


        HashSet<Integer> set = new HashSet<>();  // no duplicates and constant time retrieval
        set.add(56);
        set.add(56);
        set.add(67);
        set.add(68);
        set.add(69);
        set.add(61);

        System.out.println(set);

        // TreeMap - // inserted in sorted order
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("Kunal", 89);
        treeMap.put("Moksha", 99);
        treeMap.put("Rahul", 94);

        System.out.println(treeMap);


        // HashMap impl demo -
        HashMapImplementation map1 = new HashMapImplementation();
        map1.put("Mango", "King of fruits");
        map1.put("Apple", "Good for eyes");
        map1.put("Litchi", "Vitamin C");

        System.out.println(map1.get("Mango"));

        // HashMap impl using LL -

        HashMapUsingLL<String, String> map2 = new HashMapUsingLL<>();
        map2.put("Mango", "King of fruits");
        map2.put("Apple", "Good for eyes");
        map2.put("Litchi", "Vitamin C");

        System.out.println(map2);

    }
}
