package com.guru.recursion;

import java.util.HashSet;
import java.util.Set;

public class CountPermutations {
	public static void main(String[] args) {
		CountPermutations cp = new CountPermutations();
		System.out.println(cp.numTilePossibilities("AAB"));
	}
	
	public int numTilePossibilities(String tiles) {
        Set<String> perms = new HashSet<>();
        permutation(tiles, new StringBuilder(), perms);

        return perms.size();
    }

    private void permutation(String tiles, StringBuilder sb, Set<String> perms) {
        if(tiles == null || tiles.isEmpty()) {
        	perms.add(sb.toString());
            return;
        }
        if(sb.length() > 0) {
        	perms.add(sb.toString());
        }
        for(int i=0 ; i<tiles.length() ;i++) {
            sb.append(tiles.charAt(i));
            permutation(tiles.substring(0,i) + tiles.substring(i+1,tiles.length()) , sb, perms);
            sb.deleteCharAt(sb.length()-1);
        }
    }

}
