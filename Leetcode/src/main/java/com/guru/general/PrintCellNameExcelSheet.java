package com.guru.general;

public class PrintCellNameExcelSheet {

	public static void main(String[] args) {
		int n = 79;
		int start = 96;
		StringBuilder sb = new StringBuilder();
		
		if(n > 0 && n <=26) {
			sb.append((char)(n+start));
		}
		else if(n > 26){
			while(n > 26) {
				int i = n/26;
				if(n%26 == 0) {
					sb.append((char)(start + i-1));
				}
				else {
					sb.append((char)(start + i));
				}
				n = n - (26*i);
			}
			if(n == 0) {
				sb.append((char)(start + 26));
			}
			else {
				sb.append((char)(start + n));
			}
		}
		
		System.out.println(sb.toString());
	}
}
