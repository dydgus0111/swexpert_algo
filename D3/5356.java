package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution5356{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		int TC = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= TC; test_case++) {
			StringBuilder str1=new StringBuilder();
			StringBuilder str2=new StringBuilder();
			StringBuilder str3=new StringBuilder();
			StringBuilder str4=new StringBuilder();
			StringBuilder str5=new StringBuilder();
			str1.append(br.readLine());
			str2.append(br.readLine());
			str3.append(br.readLine());
			str4.append(br.readLine());
			str5.append(br.readLine());
			int max=Math.max(str1.length(), str2.length());
			max=Math.max(max, str3.length());
			max=Math.max(max, str4.length());
			max=Math.max(max, str5.length());
			StringBuilder ans=new StringBuilder();
			for(int i=0;i<max;i++) {
				if(str1.length()>i)
					ans.append(str1.charAt(i));
				if(str2.length()>i)
					ans.append(str2.charAt(i));
				if(str3.length()>i)
					ans.append(str3.charAt(i));
				if(str4.length()>i)
					ans.append(str4.charAt(i));
				if(str5.length()>i)
					ans.append(str5.charAt(i));
			}
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(test_case).append(" ").append(ans.toString()).append("\n");
			bw.write(sb.toString());
		}

		bw.flush();
		bw.close();
	}

}