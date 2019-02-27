package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution2001 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine().trim());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer token=new StringTokenizer(br.readLine());
			StringBuilder sb=new StringBuilder();
			int N=Integer.parseInt(token.nextToken());
			int M=Integer.parseInt(token.nextToken());
			int [][]arr=new int[N][N];
			for(int i=0;i<N;i++) {
				token=new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					arr[i][j]=Integer.parseInt(token.nextToken());
				}
			}
			int max=0;
			for(int i=0;i<=N-M;i++) {
				for(int j=0;j<=N-M;j++) {
					int dx=i;
					int dy=j;
					int cnt=0;
					int sum=0;
					for(int k=0;k<M*M;k++) {
						sum+=arr[dx][dy];
						cnt++;
						if(cnt==M) {
							dx=i;
							dy++;
							cnt=0;
						}else {
							dx++;
						}
					}
					if(sum>max)
						max=sum;
				}
			}
			sb.append("#").append(test_case).append(" ").append(max).append("\n");
			bw.write(sb.toString());
		}
		bw.flush();
		bw.close();
	}
}
