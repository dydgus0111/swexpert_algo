package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution7088{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		StringTokenizer token;
		int TC = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= TC; test_case++) {
			token=new StringTokenizer(br.readLine());
			int N=Integer.parseInt(token.nextToken());
			int Q=Integer.parseInt(token.nextToken());
			int arr[][]=new int[N+1][3];
			for(int i=1;i<=N;i++) {
				token=new StringTokenizer(br.readLine());
				int n=Integer.parseInt(token.nextToken());
				arr[i][n-1]++;
			}
			for(int i=1;i<=N;i++) {
				for(int j=0;j<3;j++) {
					arr[i][j]+=arr[i-1][j];
				}
			}
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(test_case).append(" ");
			System.out.println(sb.toString());
			StringBuilder ans=new StringBuilder();
			for(int i=0;i<Q;i++) {
				token=new StringTokenizer(br.readLine());
				int start=Integer.parseInt(token.nextToken());
				int end=Integer.parseInt(token.nextToken());
				for(int j=0;j<3;j++) {
					ans.append(arr[end][j]-arr[start-1][j]).append(" ");
				}
				ans.append("\n");
			}
			System.out.print(ans.toString());
		}
	}
}
