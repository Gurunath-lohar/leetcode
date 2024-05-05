package com.guru.concepts.slidingwindow;

public class FindLongestSpecialString {
	public static void main(String[] args) {
		FindLongestSpecialString fls = new FindLongestSpecialString();
		System.out.println(fls.maximumLength("aaaa"));
		
	}
	
	private int maximumLength(String s) {
        int[] charCount = new int[26];
        int i=0, count=0, max=0;
        for(i=0 ; i<s.length() ; i++) {
            charCount[s.charAt(i)-'a']++;
        }
        for(i=0 ; i<s.length() ; i++) {
            if(charCount[s.charAt(i)-'a'] >= 3) {
                count = getMaxLen(s, s.charAt(i), charCount[s.charAt(i)-'a']);
                max = Math.max(max, count);
                charCount[s.charAt(i)-'a'] = -1;
            }
        }

        return max;
    }

    private int getMaxLen(String s, char c, int charCount) {
        int count = 1, i=2, subCount = 0, j=0, max=0;
        String sub = c+""+c, s1 = s;
        while(s.indexOf(sub) != -1) {
            while(s1 != null && !s1.isEmpty()) {
                if(s1.indexOf(sub) != -1) {
                    s1 = s1.length() > 1 ? s1.substring(s1.indexOf(sub)+1) : "";
                    subCount++;
                }
                else {
                    break;
                }
            }
            if(subCount >= 3) {
                count = Math.max(count, sub.length());
                sub = sub+c;
                s1 = s;
                subCount = 0;
            }
            else {
                break;
            }
        }

        return count;
    }

}
