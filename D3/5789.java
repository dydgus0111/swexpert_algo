package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution5789{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		StringTokenizer token;
		int TC = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= TC; test_case++) {
			token=new StringTokenizer(br.readLine());
			int N=Integer.parseInt(token.nextToken());
			int Q=Integer.parseInt(token.nextToken());
			int arr[]=new int[N+1];
			for(int i=1;i<=Q;i++) {
				token=new StringTokenizer(br.readLine());
				int L=Integer.parseInt(token.nextToken());
				int R=Integer.parseInt(token.nextToken());
				for(int j=L;j<=R;j++) {
					arr[j]=i;
				}
			}
			StringBuilder sb = new StringBuilder();
			StringBuilder ans=new StringBuilder();
			for(int i=1;i<arr.length;i++) {
				ans.append(arr[i]+" ");
			}
			sb.append("#").append(test_case).append(" ").append(ans.toString()).append("\n");
			bw.write(sb.toString());
		}

		bw.flush();
		bw.close();
	}

}