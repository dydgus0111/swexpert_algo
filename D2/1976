package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution1976 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine().trim());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer token=new StringTokenizer(br.readLine());
			StringBuilder sb=new StringBuilder();
			StringBuilder ans=new StringBuilder();
			int h1=Integer.parseInt(token.nextToken());
			int m1=Integer.parseInt(token.nextToken());
			int h2=Integer.parseInt(token.nextToken());
			int m2=Integer.parseInt(token.nextToken());
			
			int ansh=0;
			int ansm=0;
			
			if(m1+m2>59) {
				ansh++;
				ansm=m1+m2-60;
			}else
				ansm=m1+m2;
			ansh+=h1+h2;
			if(ansh>12)
				ansh-=12;
			ans.append(ansh).append(" ").append(ansm);
			sb.append("#").append(test_case).append(" ").append(ans).append("\n");
			bw.write(sb.toString());
		}
		bw.flush();
		bw.close();
	}
}
