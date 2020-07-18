package com.LeetCode.Easy14;

public class P999_AvailableCapturesforRook {
    final int[] next =new int[]{-1,0,1,0,-1};

    public int numRookCaptures(char[][] board) {
        //find Rook
        int[] rookPosition = new int[2];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'R') {
                    rookPosition[0] = i;
                    rookPosition[1] = j;
                    break;
                }
            }
        }

        int count = 0;

        for (int k = 0; k < next.length - 1; k++) {
            int x = rookPosition[0] + next[k];
            int y = rookPosition[1] + next[k + 1];
            while (x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] == '.') {
                x += next[k];
                y += next[k + 1];
            }
            if (!(x >= 0 && x < board.length && y >= 0 && y < board[0].length)) continue;
            if (board[x][y] =='p') count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new P999_AvailableCapturesforRook().numRookCaptures(
                new char[][]{
                        {'.', '.', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', 'p', '.', '.', '.', '.'},
                        {'.', '.', '.', 'R', '.', '.', '.', 'p'},
                        {'.', '.', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', 'p', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.', '.', '.'}}
        ));
    }
}
