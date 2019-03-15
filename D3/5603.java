import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Solution5603{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		int TC =sc.nextInt();
		for (int test_case = 1; test_case <= TC; test_case++) {
			int N=sc.nextInt();
			int arr[]=new int[N];
			int sum=0;
			for(int i=0;i<N;i++) {
				arr[i]=sc.nextInt();
				sum+=arr[i];
			}
			int ave=sum/N;
			int ans=0;
			for(int i=0;i<N;i++) {
				if(arr[i]>ave) {
					ans+=arr[i]-ave;
				}
			}
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(test_case).append(" ").append(ans).append("\n");
			bw.write(sb.toString());
		}

		bw.flush();
		bw.close();
	}

}