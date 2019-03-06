import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution3233{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		StringTokenizer token;
		int TC = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= TC; test_case++) {
			//정삼각형 넓이=(루트3*한변의길이 제곱)/4
			token=new StringTokenizer(br.readLine());
			int A=Integer.parseInt(token.nextToken());
			int B=Integer.parseInt(token.nextToken());
			double Asize=(Math.sqrt(3)*A*A)/4;
			double Bsize=(Math.sqrt(3)*B*B)/4;
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(test_case).append(" ").append(Math.round(Asize/Bsize)).append("\n");
			bw.write(sb.toString());
		}
		bw.flush();
		bw.close();
	}

}