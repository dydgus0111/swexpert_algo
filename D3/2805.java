import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution2805{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		StringTokenizer token;
		int TC = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= TC; test_case++) {
			token=new StringTokenizer(br.readLine());
			int N=Integer.parseInt(token.nextToken());
			int map[][]=new int[N][N];
			for(int i=0;i<N;i++) {
				String str=br.readLine();
				for(int j=0;j<N;j++) {
					map[i][j]=str.charAt(j)-'0';
				}
			}
			int start=N/2;
			int end=N/2;
			int sum=0;
			for(int i=0;i<=N/2;i++) {
				for(int j=start;j<=end;j++) {
					sum+=map[i][j];
				}
				start--;
				end++;
			}
			start++;
			start++;
			end--;
			end--;
			for(int i=N/2+1;i<N;i++) {
				for(int j=start;j<=end;j++) {
					sum+=map[i][j];
				}
				start++;
				end--;
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(test_case).append(" ").append(sum).append("\n");
			bw.write(sb.toString());
		}

		bw.flush();
		bw.close();
	}

}
