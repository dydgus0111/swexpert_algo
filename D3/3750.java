package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution3750{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		int TC = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= TC; test_case++) {
			String num=br.readLine();
			int n=0;
			for(int i=0;i<num.length();i++) {
				n+=num.charAt(i)-'0';
			}
			num=String.valueOf(n);
			while(num.length()!=1) {
				n=0;
				for(int i=0;i<num.length();i++) {
					n+=num.charAt(i)-'0';
				}
				num=String.valueOf(n);
			}
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(test_case).append(" ").append(num).append("\n");
			bw.write(sb.toString());
		}

		bw.flush();
		bw.close();
	}

}
