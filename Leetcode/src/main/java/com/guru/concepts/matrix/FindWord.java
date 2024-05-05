package com.guru.concepts.matrix;

import java.util.Arrays;

public class FindWord {
	public static void main(String[] args) {
		FindWord fw = new FindWord();
		char[][] board = {{'A','B','C','E'},
				          {'S','F','C','S'},
				          {'A','D','E','E'}};
		System.out.println(fw.exist(board, "ABCCED"));
	}
	
	private boolean exist(char[][] board, String word) {
        boolean found = false;
        boolean [][] visited = new boolean[board.length][board[0].length];
        for(int i=0 ; i<board.length ; i++) {
            for(int j=0 ; j<board[0].length ; j++) {
                found = find(board, i, j, word, 1, visited, new StringBuilder());
                if(found) {
                    return found;
                }
            }
        }

        return false;
    }

    private boolean find(char[][] board, int i, int j, String word, int count, boolean[][] visited, StringBuilder sb) {
        if(i<0 || j<0 || i >= board.length || 
        j >= board[0].length || 
        !word.contains(""+board[i][j]) || 
        visited[i][j]
        ) {
            return false;
        }
        sb.append(board[i][j]);
        if(word.contains(""+board[i][j]) && sb.length() == word.length() && containsAll(word, sb)) {
            return true;
        }
        else {
            visited[i][j] = true;
            boolean found =  find(board, i, j-1, word, count+1, visited, sb) ||  /* left */
                find(board, i, j+1, word, count+1, visited, sb) || /* right */
                find(board, i+1, j, word, count+1, visited, sb); // bottom
            visited[i][j] = false;
            sb.deleteCharAt(sb.length()-1);
            return found;
        }
    }
    
    private boolean containsAll(String word, StringBuilder sb) {
    	char[] a = word.toCharArray();
    	char[] b = sb.toString().toCharArray();
    	Arrays.sort(a);
    	Arrays.sort(b);
    	String w = String.valueOf(a);
    	String w2 = String.valueOf(b);
    	return w.equals(w2);
    }

}
