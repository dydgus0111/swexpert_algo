package d3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution3456{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		//1. 2개만 같고 1개만 다른경우
		//2. 3개가 같은경우
		StringTokenizer token;
		int TC = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= TC; test_case++) {
			token=new StringTokenizer(br.readLine());
			int arr[]=new int[3];
			int ans=0;
			for(int i=0;i<3;i++) {
				arr[i]=Integer.parseInt(token.nextToken());
			}
			if(arr[0]==arr[1]&&arr[0]==arr[2]&&arr[1]==arr[2])
				ans=arr[0];
			else if(arr[0]==arr[1])
				ans=arr[2];
			else if(arr[0]==arr[2])
				ans=arr[1];
			else if(arr[1]==arr[2])
				ans=arr[0];
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(test_case).append(" ").append(ans).append("\n");
			bw.write(sb.toString());
		}

		bw.flush();
		bw.close();
	}

}
