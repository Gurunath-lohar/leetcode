package com.guru.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NextPermutation {
	public static void main(String[] args) {
		NextPermutation np = new NextPermutation();
		int[] a = {2,1,3};
		np.nextPermutation(a);
	}
	
	private void nextPermutation(int[] nums) {
        int[] a = Arrays.copyOf(nums, nums.length);
        Arrays.sort(a);
        String p = Arrays.stream(nums).boxed().map(s->s+"").collect(Collectors.joining(""));
        List<String> ls = new ArrayList<String>();
        findPermutation(a, ls, new StringBuilder());
        String next = null;
        for(int i=0;i<ls.size();i++) {
            if(ls.get(i).equals(p)) {
            	if((i+1) < ls.size())
                next = ls.get(i+1);
                break;
            }
        }
        System.out.println(next);
    }
    
    private void findPermutation(int[] a, List<String> ls, StringBuilder sb) {
        if(a.length == 0) {
            ls.add(sb.toString());
        }
        else {
            for(int i=0;i<a.length;i++) {
                sb.append(a[i]);
                int[] b = new int[a.length-1];
                int k = 0;
                for(int j=0;j<a.length;j++)
                {
                    if(j==i) {
                        continue;
                    }
                    b[k] = a[j];
                    k++;
                }
                findPermutation(b, ls, sb);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
}
