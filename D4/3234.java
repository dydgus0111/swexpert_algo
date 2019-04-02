import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
//추 permu+왼쪽인지 오른쪽인지
//왼쪽 오른쪽 무게 비교
public class Solution3234{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int ans;
	public static void main(String[] args) throws IOException {
		//오른쪽 <= 왼쪽
		StringTokenizer token;
		int TC = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= TC; test_case++) {
			int N=Integer.parseInt(br.readLine());
			int W[]=new int[N];
			ans=0;
			token=new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				W[i]=Integer.parseInt(token.nextToken());
			}
			permu(W, 0);
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(test_case).append(" ").append(ans).append("\n");
			bw.write(sb.toString());
		}

		bw.flush();
		bw.close();
	}
	static void powerset(int[] W,int left, int right,int idx) {
		if(W.length==idx) {
			if(left>=right)
				ans++;
			return;
		}
		if(left<right)
			return;
		powerset(W, left+W[idx],right,idx+1);
		powerset(W, left,right+W[idx],idx+1);
	}
	static void permu(int[] W, int n) {
		if(n==W.length) {
			powerset(W, 0,0,0);
			return;
		}
		for(int i=n;i<W.length;i++) {
			swap(W, i, n);
			permu(W, n+1);
			swap(W, i, n);
		}
	}
	static void swap(int[] arr, int a, int b) {
		int tmp=arr[a];
		arr[a]=arr[b];
		arr[b]=tmp;
	}
}