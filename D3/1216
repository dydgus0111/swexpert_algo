package d3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution1216 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws NumberFormatException, IOException {
		for (int test_case = 1; test_case <= 10; test_case++) {
			int num = Integer.parseInt(br.readLine());
			StringBuilder sb = new StringBuilder();
			char[][] arr = new char[100][100];
			int ans = 0;
			for (int i = 0; i < 100; i++) {
				String str = br.readLine();
				arr[i] = str.toCharArray();
			}
			int max=0;
			for (int i = 0; i < 100; i++) {	//행 확인
				for (int N = 0; N < 100; N++) {
					for (int k = 0; k <= 100 - N; k++) {
						boolean flag = true;
						int temp = k;
						int end = temp + N - 1;
						while (temp <= end) {
							if (arr[i][temp] != arr[i][end]) {
								flag = false;
							}
							end--;
							temp++;
						}
						if (flag) {
							if(N>max)
								max=N;
						}
					}
				}
			}
			for (int i = 0; i < 100; i++) {	//열 확인
				for (int N = 0; N < 100; N++) {
					for (int k = 0; k <= 100 - N; k++) {
						boolean flag = true;
						int temp = k;
						int end = temp + N - 1;
						while (temp <= end) {
							if (arr[temp][i] != arr[end][i]) {
								flag = false;
							}
							end--;
							temp++;
						}
						if (flag) {
							if(N>max)
								max=N;
						}
					}
				}
			}
			sb.append("#").append(test_case).append(" ").append(max).append("\n");
			bw.write(sb.toString());
		}
		bw.flush();
		bw.close();
	}
}
