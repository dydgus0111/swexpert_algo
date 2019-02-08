package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution1954 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine().trim());
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine().trim());
			int arr[][] = new int[N][N];
			int dx = 0;
			int dy = -1;
			int cnt = 1;
			if (N == 1)
				arr[0][0] = 1;
			if (N != 1) {
				while (cnt != N * N + 1) {
					dy++;
					while (dy != N && arr[dx][dy] == 0) {
						arr[dx][dy] = cnt;
						cnt++;
						dy++;
						if (dy == N) {
							dy--;
							break;
						}
						if (arr[dx][dy] != 0)
							dy--;
					}
					dx++;
					while (dx != N && arr[dx][dy] == 0) {
						arr[dx][dy] = cnt;
						cnt++;
						dx++;
						if (dx == N) {
							dx--;
							break;
						}
						if (arr[dx][dy] != 0)
							dx--;
					}
					dy--;
					while (dy >= 0 && arr[dx][dy] == 0) {
						arr[dx][dy] = cnt;
						cnt++;
						dy--;
						if (dy == -1) {
							dy++;
							break;
						}
						if (arr[dx][dy] != 0)
							dy++;
					}
					dx--;
					while (dx >= 0 && arr[dx][dy] == 0) {
						arr[dx][dy] = cnt;
						cnt++;
						dx--;
						if (dx == -1) {
							dx++;
							break;
						}
						if (arr[dx][dy] != 0)
							dx++;
					}
				}
			}
			System.out.println("#" + test_case);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}
