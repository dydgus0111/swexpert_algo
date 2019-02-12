package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution3431 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		StringTokenizer token;
		int TC = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= TC; test_case++) {
			String str = br.readLine();
			token = new StringTokenizer(str);
			int L = 0, U = 0, X = 0;
			int ans = 0;
			L = Integer.parseInt(token.nextToken());
			U = Integer.parseInt(token.nextToken());
			X = Integer.parseInt(token.nextToken());
			if (X >= L && X <= U) {
				ans = 0;
			} else if (X > U) {
				ans = -1;
			} else if (X < L) {
				ans = L - X;
			}
			sb.append("#").append(test_case).append(" ").append(ans).append(" ").append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
