package com.guru.concepts.matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	public static void main(String[] args) {
		int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		SpiralMatrix sm = new SpiralMatrix();
		List<Integer> ls = sm.spiralOrder(matrix);
		ls.stream().forEach(System.out::print);
	}
	
	private List<Integer> spiralOrder(int[][] matrix) {
		int right = matrix[0].length-1;
        int down = matrix.length-1;
        int left = 0;
        int top = 1;
        int i = 0, j = 0;
        boolean moreRow = false;
        boolean moreCol = false;
        int msize = matrix[0].length * matrix.length;
        List<Integer> ls = new ArrayList<>();
        while(ls.size() < msize) {
            while(j <= right) {
                ls.add(matrix[i][j]);
                j++;
            }
            j--;
            ++i;
            --right;
            while(i <= down) {
                ls.add(matrix[i][j]);
                i++;
                moreRow = true;
            }
            i--;
            j--;
            --down;
            while(j >= left && moreRow) {
                ls.add(matrix[i][j]);
                j--;
                moreCol = true;
            }
            j++;
            i--;
            left++;
            while(i >= top && moreCol) {
                ls.add(matrix[i][j]);
                i--;
            }
            i++;
            j++;
            top++;
            moreRow = false;
            moreCol = false;
        }

        return ls;
    }

}
