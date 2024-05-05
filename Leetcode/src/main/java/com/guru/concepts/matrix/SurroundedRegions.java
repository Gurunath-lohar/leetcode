package com.guru.concepts.matrix;

public class SurroundedRegions {
	public static void main(String[] args) {
		SurroundedRegions sr = new SurroundedRegions();
		char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
		for(int i=0 ; i<board.length ; i++) {
            for(int j=0 ; j<board[i].length ; j++) {
                sr.capture(board, i, j);
            }
        }
		for(int m=0 ; m<board.length ; m++) {
			for(int n=0 ; n<board[m].length ; n++) {
				System.out.println(board[m][n]);
			}
		}
	}

	private boolean capture(char[][] board, int row, int col) {
        if(row >= 0 && col >= 0 && row < board.length && col < board[row].length) {
            if(board[row][col] == 'X') {
                return true;
            }
            char tmp = board[row][col];
            board[row][col] = 'X';
            if(capture(board, row, col-1) &&
               capture(board, row, col+1) &&
               capture(board, row-1, col) &&
               capture(board, row+1, col)) {
               return true;
            }
            board[row][col] = tmp;
        }

        return false;
    }
}
