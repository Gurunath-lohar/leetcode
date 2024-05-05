package com.guru.refresh.string;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
	public static void main(String[] args) {
		GenerateParenthesis gp = new GenerateParenthesis();
		int n = 3;
		List<String> p = gp.generateParenthesis(n);
		p.stream().forEach(System.out::println);
	}
	
	private List<String> generateParenthesis(int n) {
        List<String> parenthesis = new ArrayList<>();
        generate(parenthesis, n, 0, 0, "");

        return parenthesis;
    }

    private void generate(List<String> parenthesis, int n, int left, int right, String s) {
        if(left == n && right == n) {
            parenthesis.add(s);
        }
        if(left < n) {
            generate(parenthesis, n, left+1, right, s+"(");
        }
        if(right < left) {
            generate(parenthesis, n, left, right+1, s+")");
        }
    }

}
/*

@MiRaje2
fav food : mera


*/