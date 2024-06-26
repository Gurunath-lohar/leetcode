package com.guru.concepts.twopointers;

public class VersionCompare {
	public static void main(String[] args) {
		VersionCompare vc = new VersionCompare();
		System.out.println(vc.compareVersion("1", "1.1"));
		
	}

	private int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int i=0, j=0;
        while(i<v1.length && j<v2.length) {
            if(Integer.parseInt(v1[i]) > Integer.parseInt(v2[j])) {
                return 1;
            }
            else if(Integer.parseInt(v1[i]) < Integer.parseInt(v2[j])) {
                return -1;
            }
            i++;
            j++;
        }
        while(i<v1.length) {
            if(Integer.parseInt(v1[i]) > 0) {
                return 1;
            }
            i++;
        }
        while(j<v2.length) {
            if(Integer.parseInt(v2[j]) > 0) {
                return -1;
            }
            j++;
        }

        return 0;
    }
}
