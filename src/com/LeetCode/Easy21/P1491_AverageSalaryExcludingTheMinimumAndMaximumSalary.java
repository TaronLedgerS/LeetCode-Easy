package com.LeetCode.Easy21;

public class P1491_AverageSalaryExcludingTheMinimumAndMaximumSalary {
    public double average(int[] salary) {
        double min = salary[0], max = salary[0], sum = 0;
        for(int s : salary){
            min = Math.min(s, min);
            max = Math.max(s, max);
            sum += s;
        }
        return (sum - min - max) / (salary.length-2);
    }
}
