package com.guru.concepts.matrix;

public class IslandsCount {
	public static void main(String[] args) {
		IslandsCount sr = new IslandsCount();
		int count = 0;
		int[][] board = {{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}};
		for(int i=0 ; i<board.length ; i++) {
            for(int j=0 ; j<board[i].length ; j++) {
            	count += sr.capture(board, i, j);
            }
        }
		System.out.println(count);
	}

	private int capture(int[][] board, int row, int col) {
        if(row >= 0 && col >= 0 && row < board.length && col < board[row].length) {
            if(board[row][col] == 0 || 
            (row == 0 || col == board[row].length-1 || row == board.length-1 || col == 0)) {
                return 0;
            }
            int tmp = board[row][col];
            board[row][col] = 0;
            int count = 1 + capture(board, row, col-1) + capture(board, row, col+1) +
                        capture(board, row-1, col) + capture(board, row+1, col);
            
            return count;
        }

        return 0;
    }
}
