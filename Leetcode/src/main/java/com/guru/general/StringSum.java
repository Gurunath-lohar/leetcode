package com.guru.general;

/*
 * find sum of String integers without converting to int
 * 
 */
public class StringSum {
	public static void main(String[] args) {
		StringSum ss = new StringSum();
		String num1 = "12";
		String num2 = "8";
		System.out.println(ss.multiply(num1, num2));
	}

	public String multiply(String num1, String num2) {
        int[] sum = new int[num1.length()+num2.length()];
        int pos = sum.length;
        int c = 0;
        int skip = 0;
        for(int i=num1.length()-1;i>=0;i--) {
            pos = sum.length - skip-1;
            c = 0;
            for(int j=num2.length()-1;j>=0;j--) {
                int p = (num1.charAt(i)-'0') * (num2.charAt(j)-'0') + c +sum[pos];
                int d = p%10;
                c = p/10;
                sum[pos] = d;
                --pos;
            }
            while(pos >=0) {
                sum[pos] = c%10;
                c = c/10;
                if(c == 0) {
                    break;
                }
                --pos;
            }
            skip++;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i<sum.length) {
        	if(sum[i] > 0) {
        		break;
        	}
        	i++;
        }
        while(i<sum.length) {
        	sb.append(sum[i]+"");
        	i++;
        }
        
        return sb.toString();     
    }
}
