import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution1952{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		StringTokenizer token;
		int TC = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= TC; test_case++) {
			StringBuilder sb = new StringBuilder();
			int price[] =new int[4];//0: 1일, 1:1달, 2:3달, 3:1년
			int month[]=new int[13];
			int dp[]=new int[13];
			int dpM[]=new int[13];
			token=new StringTokenizer(br.readLine());
			for(int i=0;i<4;i++) {
				price[i]=Integer.parseInt(token.nextToken());
			}
			token=new StringTokenizer(br.readLine());
			for(int i=1;i<13;i++) {
				month[i]=Integer.parseInt(token.nextToken());
				dp[i]=price[3];
			}
			//1일 이용권, 1달 이용권 중 작은값 넣기
			for(int i=1;i<13;i++) {
				dpM[i]=Math.min(month[i]*price[0],price[1]);
			}
			//3달 이용권
			for(int i=1;i<13;i++) {
				dp[i]=dp[i-1]+dpM[i];
				if(i>=3) {
					if(dp[i-3]+price[2]<dp[i])
						dp[i]=dp[i-3]+price[2];
				}
			}
			int ans=0;
			//1년 이용권
			if(price[3]<dp[12])
				ans=price[3];
			else
				ans=dp[12];
			sb.append("#").append(test_case).append(" ").append(ans).append("\n");
			bw.write(sb.toString());
		}
		bw.flush();
		bw.close();
	}
}