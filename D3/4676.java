import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution4676{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		StringTokenizer token;
		int TC = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= TC; test_case++) {
			StringBuilder ans=new StringBuilder();
			ans.append(br.readLine());
			int H=Integer.parseInt(br.readLine());
			token=new StringTokenizer(br.readLine());
			Integer arr[]=new Integer[H];
			for(int i=0;i<H;i++) {
				arr[i]=Integer.parseInt(token.nextToken());
			}
			Arrays.sort(arr,Collections.reverseOrder());
			for(int i=0;i<H;i++) {
				ans.insert(arr[i], "-");
			}
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(test_case).append(" ").append(ans.toString()).append("\n");
			bw.write(sb.toString());
		}
		bw.flush();
		bw.close();
	}

}