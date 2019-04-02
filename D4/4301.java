import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution4301{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		StringTokenizer token;
		int TC = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= TC; test_case++) {
			token=new StringTokenizer(br.readLine());
			int N=Integer.parseInt(token.nextToken());
			int M=Integer.parseInt(token.nextToken());
			int map[][]=new int[M][N];
			int ans=0;
			boolean flagrow=true;
			int flagcnt=0;
			for(int i=0;i<M;i++) {
				boolean flagcol=true;
				int cnt=0;
				if(flagrow) {
					for(int j=0;j<N;j++) {
						if(flagcol) {
							if(cnt==2) {
								cnt=0;
								flagcol=false;
							}
							else {
								cnt++;
								map[i][j]=1;
							}
						}
						else {
							flagcol=true;
						}
					}
					flagcnt++;
					if(flagcnt==2) {
						flagcnt=0;
						flagrow=false;
					}
				}
				else {
					flagcol=false;
					for(int j=1;j<N;j++) {
						if(flagcol) {
							if(cnt==2) {
								cnt=0;
								flagcol=false;
							}
							else {
								cnt++;
								map[i][j]=1;
							}
						}
						else {
							flagcol=true;
						}
					}
					flagcnt++;
					if(flagcnt==2) {
						flagcnt=0;
						flagrow=true;
					}
				}
			}
			for(int i=0;i<M;i++) {
				for(int j=0;j<N;j++) {
					if(map[i][j]==1)
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