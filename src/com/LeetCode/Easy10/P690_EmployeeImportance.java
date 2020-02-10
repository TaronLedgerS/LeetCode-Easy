package com.LeetCode.Easy10;

import java.util.*;

public class P690_EmployeeImportance {
    public int getImportance(List<Employee> employees, int id) {
        int total = 0;
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        Queue<Employee> queue = new LinkedList<>();
        queue.offer(map.get(id));
        while (!queue.isEmpty()) {
            Employee current = queue.poll();
            total += current.importance;
            for (int subordinate : current.subordinates) {
                queue.offer(map.get(subordinate));
            }
        }
        return total;
    }
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>(Arrays.asList(
                new Employee(1,5,Arrays.asList(2,3)),
                new Employee(2,3,new ArrayList<>()),
                new Employee(3,3,new ArrayList<>())
        ));
        System.out.println(
                new P690_EmployeeImportance().getImportance(
                        employees,1
                )
        );
    }
}
