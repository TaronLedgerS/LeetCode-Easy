package com.LeetCode.Easy2;

import java.util.ArrayList;
import java.util.List;

public class P118_PascalTriangleTest {
    public static  void main(String[] args){
        PascalTriangle temp = new PascalTriangle();
        int a = 5;
        System.out.println(temp.generate(a).toString());
    }
}
class PascalTriangle {
     List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        if (numRows == 0) {
            return triangle;
        }
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);
        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle.get(rowNum-1);
            //边界都为1
            row.add(1);
            for (int j = 1; j < rowNum; j++) {
                row.add(prevRow.get(j-1) + prevRow.get(j));
            }
            //边界都为1
            row.add(1);
            triangle.add(row);
        }
        return triangle;
    }
}
