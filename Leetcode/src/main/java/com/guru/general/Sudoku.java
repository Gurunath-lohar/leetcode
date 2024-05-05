package com.guru.general;

import java.util.HashSet;
import java.util.Set;

public class Sudoku {
	public static void main(String[] args) {
		String[][] board = {{"5","3",".",".","7",".",".",".","."},{"6",".",".","1","9","5",".",".","."},{".","9","8",".",".",".",".","6","."},{"8",".",".",".","6",".",".",".","3"},{"4",".",".","8",".","3",".",".","1"},{"7",".",".",".","2",".",".",".","6"},{".","6",".",".",".",".","2","8","."},{".",".",".","4","1","9",".",".","5"},{".",".",".",".","8",".",".","7","9"}};
		Sudoku sk = new Sudoku();
		System.out.println(sk.isValidSudoku(board));
	}
	
	public boolean isValidSudoku(String[][] board) {
        Set<String> ss = new HashSet<>();
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[i].length;j++) {
                String key = board[i][j]+"";
                if(key.equals(".")) {
                    continue;
                }
                if(!ss.add(i+" row "+key) ||
                   !ss.add(j+" col "+key) ||
                   !ss.add(i/3+" row "+key+" col "+j/3)) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
