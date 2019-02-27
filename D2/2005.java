package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution2005 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int [][]pas=new int[10][11];
	
	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine().trim());
		pas[0][0]=1;
		pas[1][0]=1;
		pas[1][1]=1;
		for(int i=2;i<10;i++) {
			pas[i][0]=1;
			pas[i][i]=0;
			for(int j=1;j<=i;j++) {
				pas[i][j]=pas[i-1][j-1]+pas[i-1][j];
			}
		}
		for (int test_case = 1; test_case <= T; test_case++) {
			String str=br.readLine();
			StringTokenizer token=new StringTokenizer(str);
			int num=Integer.parseInt(token.nextToken());
			bw.append("#"+test_case+"\n");
			for(int i=0;i<num;i++) {
				int cnt=0;
				StringBuilder sb=new StringBuilder();
				while(pas[i][cnt]!=0) {
					sb.append(pas[i][cnt]).append(" ");
					cnt++;
				}
				bw.write(sb.toString()+"\n");
			}
		}
		bw.flush();
		bw.close();
	}
}
