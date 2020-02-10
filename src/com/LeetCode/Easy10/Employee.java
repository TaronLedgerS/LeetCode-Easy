package com.LeetCode.Easy10;

import java.util.List;
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;

    Employee(int m_id, int m_importance, List<Integer> m_subordinates) {
        id = m_id;
        importance = m_importance;
        subordinates = m_subordinates;
    }
};

