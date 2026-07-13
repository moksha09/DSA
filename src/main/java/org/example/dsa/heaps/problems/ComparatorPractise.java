package org.example.dsa.heaps.problems;

import java.util.Comparator;

public class ComparatorPractise {

    // comparing integers
    Comparator<Integer> ascending = (a, b) -> {
        return a-b;
    };

    // comparing strings -
    String a = "Apple";
    String b = "Banana";

    int result = a.compareTo(b); // negative because apple comes before banana alphabetically

    // comparing custom objects -
    class Student {
        String name;
        int age;

        public Student(String name, int age){
            this.name = name;
            this.age = age;
        }
    }
    Student s1 = new Student("Moksha", 25);
    Student s2 = new Student("Tom", 40);
    Student s3 = new Student("Hannah", 18);
    Comparator<Student> ageComparator = (s1, s2) -> {
        return s1.age - s2.age;
    };
    Comparator<Student> nameComparator = (s1, s2) -> {
        return s1.name.compareTo(s2.name);
    };
    int youngest = ageComparator.compare(s1, s2); // negative

}
