package com.LeetCode.Easy12;

public class P836_RectangleOverlap {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return !(rec1[2] <= rec2[0] ||   // left
                rec1[3] <= rec2[1] ||   // bottom
                rec1[0] >= rec2[2] ||   // right
                rec1[1] >= rec2[3]);    // top
    }
    public static void main(String[] args) {
        System.out.println(
                new P836_RectangleOverlap().isRectangleOverlap(new int[]{0,0,1,1},new int[]{1,0,2,1})
        );
    }
}
