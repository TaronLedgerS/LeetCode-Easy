package com.LeetCode.Easy7;

public class P492_ConstructtheRectangle {
    public int[] constructRectangle(int area) {
        int w = (int)Math.sqrt(area);
        while (area%w!=0) w--;
        return new int[]{area/w, w};
    }

    public static void main(String[] args) {
        System.out.println(new P492_ConstructtheRectangle().constructRectangle(4));

    }
}
