package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution2117{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int map[][];
	static int N;
	static int M;
	static int profit[];
	public static void main(String[] args) throws IOException {
		StringTokenizer token;
		int TC = Integer.parseInt(br.readLine());
		profit=new int[23];
		for(int i=1;i<=22;i++) {
			profit[i]=calcK(i);
		}
		for (int test_case = 1; test_case <= TC; test_case++) {
			token=new StringTokenizer(br.readLine());
			N=Integer.parseInt(token.nextToken());
			M=Integer.parseInt(token.nextToken());
			map=new int[N][N];
			anssum=Integer.MIN_VALUE;
			ans=0;
			for(int i=0;i<N;i++) {
				token=new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					map[i][j]=Integer.parseInt(token.nextToken());
				}
			}
			for(int i=1;i<23;i++) {
				for(int j=0;j<N;j++) {
					for(int k=0;k<N;k++) {
						manageRange(j, k, i,profit[i]);
					}
				}
			}
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(test_case).append(" ").append(ans).append("\n");
			bw.write(sb.toString());
		}
		bw.flush();
		bw.close();
	}
	static int calcK(int K) {
		return K*K+(K-1)*(K-1);
	}
	static boolean isRange(int x, int y) {
		return x>=0&&x<N&&y>=0&&y<N;
	}
	static int anssum;
	static int ans;
	static void manageRange(int x,int y,int K,int profit) {
		int sx=x-(K-1);
		int sy=y;
		int sum=0;
		int homecnt=0;
		for(int i=1;i<=K;i++) {
			for(int j=0;j<2*i-1;j++) {
				if(!isRange(sx, sy+j))
					continue;
				else {
					if(map[sx][sy+j]==1) {
						sum+=M;
						homecnt++;
					}
				}
			}
			sx++;
			sy--;
		}
		sy++;
		for(int i=1;i<K;i++) {
			sy++;
			for(int j=0;j<2*K-(2*i+1);j++){
				if(!isRange(sx, sy+j))
					continue;
				else {
					if(map[sx][sy+j]==1) {
						sum+=M;
						homecnt++;
					}
				}
			}
			sx++;
		}
		if((sum-profit)>=0) {
			if(ans<homecnt)
				ans=homecnt;
		}
	}
}
