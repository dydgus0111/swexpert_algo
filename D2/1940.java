package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution1940 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine().trim());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringBuilder sb = new StringBuilder();
			int ans=0;
			int acc=0;
			int N=Integer.parseInt(br.readLine().trim());
			for(int i=0;i<N;i++) {
				String str = br.readLine();
				StringTokenizer token = new StringTokenizer(str);
				int com=Integer.parseInt(token.nextToken());
				int inputAcc=0;
				if(com!=0)
					inputAcc=Integer.parseInt(token.nextToken());
				if(com==1) {
					acc+=inputAcc;
					ans+=acc;
				}else if(com==2) {
					if(acc>=inputAcc)
						acc-=inputAcc;
					ans+=acc;
				}else {
					ans+=acc;
				}
			}
			
			sb.append("#").append(test_case).append(" ").append(ans).append("\n");
			bw.write(sb.toString());
		}
		bw.flush();
		bw.close();
	}
}
