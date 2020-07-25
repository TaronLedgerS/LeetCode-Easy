package com.LeetCode.Easy16;

public class P1108_DefangingIPAddress {

    public String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder();
        for (char c : address.toCharArray()) {
            if (c=='.')
                sb.append("[.]");
            else
                sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new P1108_DefangingIPAddress().defangIPaddr("255.100.50.0"));
    }
}
