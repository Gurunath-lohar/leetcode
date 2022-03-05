package com.guru.general;
//In progress
public class PrintCellNameExcelSheet {

	public static void main(String[] args) {
		int n = 52;
		char start = 65;
		StringBuilder sb = new StringBuilder();
		do {
			if(n < 26) {
				sb.append((char)(start + n%26));
			}
			else {
				sb.append((char)(start - 1 + n/26));
			}			
			n = n-26;
		}while(n >= 0);
		
		System.out.println(sb.toString());
	}
}
