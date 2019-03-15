import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution6692{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		StringTokenizer token;
		int TC = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= TC; test_case++) {
			int N=Integer.parseInt(br.readLine());
			double ans=0;
			for(int i=0;i<N;i++) {
				token=new StringTokenizer(br.readLine());
				double p1=Double.parseDouble(token.nextToken());
				double x1=Double.parseDouble(token.nextToken());
				ans+=(p1*x1);
			}
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(test_case).append(" ").append(String.format("%.6f", ans)).append("\n");
			bw.write(sb.toString());
		}

		bw.flush();
		bw.close();
	}

}