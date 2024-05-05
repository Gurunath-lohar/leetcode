package com.guru.concepts.slidingwindow;

public class DeleteCharsLeftAndRight2 {
	public static void main(String[] args) {
		DeleteCharsLeftAndRight2 dcl = new DeleteCharsLeftAndRight2();
		String s = "caccbbba";
		int k = 1;
		System.out.println(dcl.takeCharacters(s, k));
	}
	
	private int takeCharacters(String s, int k) {
        int[] charCount = new int[3], removed = new int[3];
        int i=0, j=0;
        if(k==0) {
            return 0;
        }
        for ( i = 0; i < s.length(); i++) {
            charCount[s.charAt(i)-'a']++;
        }
        if (charCount[0] < k || charCount[1] < k || charCount[2] < k) {
            return -1;
        } 
        i=0;
        while(i<s.length()) {
            removed[s.charAt(i)-'a']++;
            if(charCount[0] - removed[0] >= k && 
            charCount[1] - removed[1] >= k &&
            charCount[2] - removed[2] >= k){
                j++;
            }
            else {
                removed[s.charAt(i-j)-'a']--;
            }
            i++;
        }

        return s.length()-j;
    }

}
