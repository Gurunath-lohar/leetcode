package com.guru.general;

public class SearchInMatrix {
	public static void main(String[] args) {
		SearchInMatrix sim = new SearchInMatrix();
		int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
		int target = 34;
		System.out.println(sim.searchMatrix(matrix, target));
	}
	
	private boolean searchMatrix(int[][] matrix, int target) {
        // find row
        int row = 0;
        for(int i=0;i<matrix.length;i++) {
            if(target == matrix[i][0] ) {
                return true;
            }
            else if(target > matrix[i][0]) {
                row = i;
            }
            else {
                break;
            }
        }
        
        return binarySearch(matrix, row, target, 0, matrix[0].length-1);
    }
    
    private boolean binarySearch(int[][] matrix, int row, int target, int start, int end) {
    	boolean result = false;
        if(start < end) {
            if(matrix[row][start] == target) {
            	result = true;
            }
            else {
            	int mid = (start+end)/2;
                if(target == matrix[row][mid]) {
                	result = true;
                }
                else if(target < matrix[row][mid]) {
                	result = binarySearch(matrix, row, target, start, mid);
                }
                else {
                	result = binarySearch(matrix, row, target, mid+1, end);
                }
            }
            
        }
        
        return result;
    }
}
