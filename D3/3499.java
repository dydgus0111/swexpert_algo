import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution3499{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		StringTokenizer token;
		int TC = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= TC; test_case++) {
			int N=Integer.parseInt(br.readLine());
			String arr[]=new String[N];
			token=new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				arr[i]=token.nextToken();
			}
			StringBuilder ans=new StringBuilder();
			if(N%2==0) {
				String one[]=new String[N/2];
				String two[]=new String[N/2];
				for(int i=0;i<N/2;i++) {
					one[i]=arr[i];
				}
				int cnt=0;
				for(int i=N/2;i<N;i++) {
					two[cnt]=arr[i];
					cnt++;
				}
				for(int i=0;i<N/2;i++) {
					ans.append(one[i]+" ");
					ans.append(two[i]+" ");
				}
			}
			else {
				String one[]=new String[N/2+1];
				String two[]=new String[N/2];
				for(int i=0;i<N/2+1;i++) {
					one[i]=arr[i];
				}
				int cnt=0;
				for(int i=N/2+1;i<N;i++) {
					two[cnt]=arr[i];
					cnt++;
				}
				for(int i=0;i<N/2;i++) {
					ans.append(one[i]+" ");
					ans.append(two[i]+" ");
				}
				ans.append(one[one.length-1]);
			}
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(test_case).append(" ").append(ans).append("\n");
			bw.write(sb.toString());
		}

		bw.flush();
		bw.close();
	}

}