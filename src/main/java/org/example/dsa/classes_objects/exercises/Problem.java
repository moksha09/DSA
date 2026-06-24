package org.example.dsa.classes_objects.exercises;

public class Problem {
    // gives compile time error correct it -
//    String s;
//    static class Inner {
//        void testMethod() {
//            s = "Set from Inner";
//        }
//    }
    String s;
     class Inner {
        void testMethod() {
            s = "Set from Inner";
        }
    }
}
