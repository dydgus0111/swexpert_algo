import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution3143{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		StringTokenizer token;
		int TC = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= TC; test_case++) {
			token=new StringTokenizer(br.readLine());
			StringBuilder A=new StringBuilder(token.nextToken());
			StringBuilder B=new StringBuilder(token.nextToken());
			int ans=0;
			int bleng=B.length();
			for(int i=0;i<A.length();i++) {
				if(i+bleng<=A.length()) {
					if(A.substring(i,i+bleng).equals(B.substring(0, bleng))) {
						ans++;
						i+=bleng-1;
					}
					else
						ans++;
				}
				else {
					ans++;
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
