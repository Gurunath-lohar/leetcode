package com.guru.concepts.greedy;

import java.util.ArrayList;
import java.util.List;

public class ShortestString {
	String minString = null;
	public static void main(String[] args) {
		ShortestString ss = new ShortestString();
		System.out.println(ss.minimumString("abc", "bca", "aaa"));
	}
	
    public String minimumString(String a, String b, String c) {
        String[] s = new String[3];
        s[0] = a;
        s[1] = b;
        s[2] = c;
        List<Integer> skipIndex = new ArrayList<>();
        permutation(s, skipIndex, new ArrayList<String>());

        return minString;
    }

    private void permutation(String[] s, List<Integer> skipIndex, 
    List<String> incomingString) {
        if(s.length == skipIndex.size()) {
            String s1 = (buildString(incomingString));
            if(minString != null) {
                if(minString.length() > s1.length()) {
                    minString = s1;
                }
                else if(minString.length() == s1.length() && minString.compareTo(s1) > 0) {
                    minString = s1;
                }
            }
            else {
                minString = s1;
            }
        }
        else {
            for(int i=0 ; i<s.length ; i++) {
                if(skipIndex.contains(i)) {
                    continue;
                }
                skipIndex.add(i);
                incomingString.add(s[i]);
                permutation(s,skipIndex,incomingString);
                skipIndex.remove(skipIndex.size()-1);
                incomingString.remove(incomingString.size()-1);
            }
        }
    }

    private String buildString(List<String> strings) {
        StringBuilder sb = new StringBuilder();
        int i=0;
        for(int j=0;j<strings.size() ; j++) {
            String s = strings.get(j);
            if(sb.length() ==0) {
                sb.append(s);
            }
            else {
                i=0;
                while(i<s.length() && sb.length()-1-i >= 0) {
                    if(sb.charAt(sb.length()-1-i) == s.charAt(i)) {
                        i++;
                    }
                    else {
                        break;
                    }
                }
                if(i<s.length()) {
                    sb.append(s.substring(i));
                }
            }
        }

        return sb.toString();
    }

}
