package com.guru.general;

public class SequenceSearchMatrix {
	public static void main(String[] args) {
		SequenceSearchMatrix ssm = new SequenceSearchMatrix();
		char [][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		String word = "ABCCED";
		System.out.println(ssm.exist(board, word));
	}
	
	public boolean exist(char[][] board, String word) {
        boolean result = false;
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                if(board[i][j] == word.charAt(0)) {
                    StringBuilder sb = new StringBuilder();
                    result = sequence(board, word, sb, i, j);
                    if(result) {
                        break;
                    }
                }
            }
            if(result) {
                break;
            }
        }
        
        return result;
    }
    
    private boolean sequence(char[][]  board, String word, 
                             StringBuilder sb, int row, int col) {
        boolean result = false;
        if(sb.toString().equals(word)) {
            result = true;
        }
        else if(sb.length() > word.length() || !word.startsWith(sb.toString())) {
            result = false;
        }
        else if(col < 0) {
            result = false;
        }
        else if(row == board.length-1 && col == board[0].length-1) {
        	sb.append(board[row][col]);
        	result = sb.toString().equals(word);
        }
        else if(row == board.length-1) {
            sb.append(board[row][col]);
            result = sequence(board, word, sb, row, col+1);
        }
        else if(col == board[0].length-1) {
            sb.append(board[row][col]);
            result = sequence(board, word, sb, row+1, col);
        }
        else {
            sb.append(board[row][col]);
            result = sequence(board, word, sb, row, col+1) ||
                     sequence(board, word, sb, row+1, col) ||
                     sequence(board, word, sb, row, col-1);
        }
        
        return result;
    }

}
