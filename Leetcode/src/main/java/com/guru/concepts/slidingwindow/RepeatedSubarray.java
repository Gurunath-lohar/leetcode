package com.guru.concepts.slidingwindow;

public class RepeatedSubarray {
	public static void main(String[] args) {
		RepeatedSubarray rs = new RepeatedSubarray();
		int[] nums1 = new int[] {70,39,25,40,7};
		int[] nums2 = new int[] {52,20,67,5,31};
		System.out.println(rs.findLength(nums1, nums2));
	}
	
	public int findLength(int[] nums1, int[] nums2) {
        if(nums1.length == 0 || nums2.length == 0) {
            return 0;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(",");
        for(int i : nums2) {
            sb2.append(i+",");
        }
        String s2 = sb2.toString().trim();
        StringBuilder sb1 = new StringBuilder();
        sb1.append(",");
        int j=0, max=0, count=0;
        while(j<nums1.length) {
        	String s = nums1[j]+",";
            sb1.append(s);
            int k = s2.indexOf(sb1.toString());
            if(k < 0) {
                sb1.delete(0,sb1.length());
                sb1.append(",");
                count = 0;
                if(s2.indexOf(","+s) >= 0) {
                    sb1.append(s);
                    count = 1;
                }
            }
            else {
                count++;
            }
            max = Math.max(max, count);
            j++;
        }

        return max;
    }

}
