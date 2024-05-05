package com.guru.concepts.twopointers;

public class SearchInRotatedArray {
	public static void main(String[] args) {
		SearchInRotatedArray sira = new SearchInRotatedArray();
		int[] nums = {1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1};
		int target = 2;
		System.out.println(sira.search(nums, target));
	}
	
	private boolean search(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        while(left<=right) {
            int mid = (left+right)/2;
            if(nums[mid] == target || nums[left] == target || nums[right] == target) {
                return true;
            }
            // check if left half is sorted
            if(nums[left] < nums[mid]) {
                // is target falls within left side
                if(target > nums[left] && target < nums[mid]) {
                    right = mid-1;
                }
                //else search on the right side
                else {
                    left = mid+1;
                }
            }
            // chk if target is on the right range
            else if(nums[mid] < nums[right]){
                if(target > nums[mid] && target < nums[right]) {
                    left = mid+1;
                }
                else {
                    right = mid-1;
                }
            }
            else if(nums[left] == nums[mid]) {
            	left++;
            }
            else {
            	right++;
            }
        }

        return false;
    }

}
