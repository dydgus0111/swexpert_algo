package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution1959 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringBuilder sb = new StringBuilder();
			String str = br.readLine();
			StringTokenizer token = new StringTokenizer(str);
			int a = Integer.parseInt(token.nextToken());
			int b = Integer.parseInt(token.nextToken());

			int[] arrA = new int[a];
			int[] arrB = new int[b];
			str = br.readLine();
			token = new StringTokenizer(str);
			for (int i = 0; i < a; i++) {
				arrA[i] = Integer.parseInt(token.nextToken());
			}
			str = br.readLine();
			token = new StringTokenizer(str);
			for (int i = 0; i < b; i++) {
				arrB[i] = Integer.parseInt(token.nextToken());
			}
			int cnt = 0;
			int max = 0;
			if (arrA.length < arrB.length) {
				while (arrA.length - 1 + cnt < arrB.length) {
					int sum = 0;
					for (int i = 0; i < arrA.length; i++) {
						sum += arrA[i] * arrB[i + cnt];
					}
					if (max < sum)
						max = sum;
					cnt++;
				}
			}else {
				while (arrB.length - 1 + cnt < arrA.length) {
					int sum = 0;
					for (int i = 0; i < arrB.length; i++) {
						sum += arrB[i] * arrA[i + cnt];
					}
					if (max < sum)
						max = sum;
					cnt++;
				}
			}
			sb.append("#").append(test_case).append(" ").append(max).append("\n");
			bw.write(sb.toString());
		}
		bw.flush();
		bw.close();
	}
}
