import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= TC; test_case++) {
			int N,K;
			StringBuilder sb = new StringBuilder();
			StringBuilder ans=new StringBuilder();
			st=new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			K=Integer.parseInt(st.nextToken());
			int arr[][]=new int[K+1][N+1];
			for(int i=1;i<=N;i++) {
				if(i%2==1) {
					for(int j=(i-1)*K+1,cnt=1;j<=i*K;j++,cnt++) {
						arr[cnt][i]=j;
					}
				}
				else {
					for(int j=i*K,cnt=1;j>=(i-1)*K+1;j--,cnt++) {
						arr[cnt][i]=j;
					}
				}
			}
			for(int i=1;i<=K;i++) {
				int sum=0;
				for(int j=1;j<=N;j++) {
					sum+=arr[i][j];
				}
				ans.append(sum).append(" ");
			}
			sb.append("#").append(test_case).append(" ").append(ans.toString()).append("\n");
			bw.write(sb.toString());
		}

		bw.flush();
		bw.close();
	}

}
