package org.example.dsa.sorting.problems.assignment.easy;

import java.util.Arrays;

public class AvgSalaryExcludingMinAndMaxSalary1491 {

    public double average(int[] salary) {
        Arrays.sort(salary);
        double sum = 0;

        for(int i=1;i<salary.length-1; i++){
            sum = sum+salary[i];
        }

        return sum/(salary.length-2);
    }

    public static void main(String[] args){

    }
}
