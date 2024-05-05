package com.guru.concepts.slidingwindow;

public class LongestRepeatedSemiString {
	public static void main(String[] args) {
		int i=0, j=0, max=0, duplicates=1;
		String s ="5555";
        StringBuilder sb = new StringBuilder();
        while(i<s.length()) {
            j=i;
            sb = new StringBuilder();
            duplicates=1;
            while(j<s.length()) {
                if(sb.length() > 0 && sb.charAt(sb.length()-1) == s.charAt(j)) {
                    duplicates *=2;
                    if(duplicates%4 == 0) {
                        break;
                    }
                }
                sb.append(s.charAt(j));
                j++;
            }
            max = Math.max(sb.length(), max);
            i++;
        }
        System.out.println(max);
	}

}
