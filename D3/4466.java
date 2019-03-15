import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution4466{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		StringTokenizer token;
		int TC = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= TC; test_case++) {
			token=new StringTokenizer(br.readLine());
			int N=Integer.parseInt(token.nextToken());
			int K=Integer.parseInt(token.nextToken());
			Integer arr[]=new Integer[N];
			token=new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				arr[i]=Integer.parseInt(token.nextToken());
			}
			int sum=0;
			Arrays.sort(arr,Collections.reverseOrder());
			for(int i=0;i<K;i++) {
				sum+=arr[i];
			}
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(test_case).append(" ").append(sum).append("\n");
			bw.write(sb.toString());
		}

		bw.flush();
		bw.close();
	}

}