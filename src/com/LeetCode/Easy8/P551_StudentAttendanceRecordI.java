package com.LeetCode.Easy8;

public class P551_StudentAttendanceRecordI {
    public boolean checkRecord(String s) {
        //.匹配除"\r\n"之外的任何单个字符
        //[xyz]字符集
        //?零次或一次匹配前面的字符或子表达式，如10? 有1、10
        //+一次或多次匹配前面的字符或子表达式，如10+ 有10、100、1000等等
        //*零次或多次匹配前面的字符或子表达式，如10* 有1、10、100、1000等等
        return !s.matches("[PAL]*LLL[PAL]*|[PAL]*A[PAL]*A[PAL]*");
    }
    public static void main(String[] args) {
        System.out.println(
                new P551_StudentAttendanceRecordI().checkRecord("PPALLL")
        );
    }
}
