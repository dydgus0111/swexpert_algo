package d3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution5601 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		StringTokenizer token;
		int TC = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= TC; test_case++) {
			StringBuilder sb = new StringBuilder();
			StringBuilder sb1 = new StringBuilder();
			int num = Integer.parseInt(br.readLine());
			for (int i = 0; i < num; i++) {
				sb1.append("1/").append(num).append(" ");
			}
			sb.append("#").append(test_case).append(" ").append(sb1.toString()).append("\n");
			bw.write(sb.toString());
		}
		bw.flush();
		bw.close();
	}

}