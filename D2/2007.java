package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution2007 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine().trim());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringBuilder sb = new StringBuilder();
			StringBuilder sb1 = new StringBuilder();
			String str = br.readLine();
			boolean flag=true;
			for(int i=0;i<str.length();i++) {
				flag=true;
				sb.append(str.charAt(i));
				for(int j=0;j<sb.length();j++) {
					if(sb.charAt(j)==str.charAt(j+sb.length())) {
						flag&=true;
					}else
						flag&=false;
				}
				if(flag)
					break;
			}
			
			sb1.append("#").append(test_case).append(" ").append(sb.length()).append("\n");
			bw.write(sb1.toString());
		}
		bw.flush();
		bw.close();
	}
}
