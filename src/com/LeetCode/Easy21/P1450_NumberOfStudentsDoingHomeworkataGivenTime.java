package com.LeetCode.Easy21;

public class P1450_NumberOfStudentsDoingHomeworkataGivenTime {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int res = 0;
        for (int i = 0; i < startTime.length; ++i) {
            res += startTime[i] <= queryTime && queryTime <= endTime[i] ? 1 : 0;
        }
        return res;
    }
}
