package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution1948 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine().trim());
		int day[] = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		for (int test_case = 1; test_case <= T; test_case++) {
			StringBuilder sb = new StringBuilder();
			String str = br.readLine();
			StringTokenizer token = new StringTokenizer(str);
			int month1 = Integer.parseInt(token.nextToken());
			int day1 = Integer.parseInt(token.nextToken());
			int month2 = Integer.parseInt(token.nextToken());
			int day2 = Integer.parseInt(token.nextToken());
			int ans = day[month1] - day1 + 1;
			if (month1 != month2) {
				for (int i = month1 + 1; i < month2; i++) {
					ans += day[i];
				}
				ans += day2;
			}

			sb.append("#").append(test_case).append(" ").append(ans).append("\n");
			bw.write(sb.toString());
		}
		bw.flush();
		bw.close();
	}
}
