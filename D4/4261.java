import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution4261{
	static char key[][]= {{},{},{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'}
	,{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		StringTokenizer token;
		int TC = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= TC; test_case++) {
			token=new StringTokenizer(br.readLine());
			String S=token.nextToken();
			ans=0;
			int N=Integer.parseInt(token.nextToken());
			token=new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				String str=token.nextToken();
				find(str, S);
			}
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(test_case).append(" ").append(ans).append("\n");
			bw.write(sb.toString());
		}

		bw.flush();
		bw.close();
	}
	static int ans;
	static void find(String str, String push) {
		int cnt=0;
		int idx=0;
		if(str.length()<push.length())
			return;
		for(int i=0;i<push.length();i++) {
			int n=push.charAt(i)-'0';
			for(int k=0;k<key[n].length;k++) {
				if(key[n][k]==str.charAt(idx)) {
					cnt++;
					break;
				}
			}
			idx++;
		}
		if(cnt==str.length())
			ans++;
	}
}
