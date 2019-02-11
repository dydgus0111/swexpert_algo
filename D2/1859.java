package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution1859 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine().trim());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringBuilder sb = new StringBuilder();
			int N=Integer.parseInt(br.readLine().trim());
			String str=br.readLine();
			StringTokenizer token=new StringTokenizer(str);
			long []arr=new long[N];
			for(int i=0;i<N;i++) {
				arr[i]=Long.parseLong(token.nextToken());
			}
			long max=arr[N-1];
			long ans=0;
			for(int i=N-2;i>=0;i--) {
				if(arr[i]<max) {
					ans+=max-arr[i];
				}else
					max=arr[i];
			}
			
			sb.append("#").append(test_case).append(" ").append(ans).append("\n");
			bw.write(sb.toString());
		}
		bw.flush();
		bw.close();
	}
}
