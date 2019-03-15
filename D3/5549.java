import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution5549{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		StringTokenizer token;
		int TC = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= TC; test_case++) {
			StringBuilder sb=new StringBuilder();
			sb.append(br.readLine());
			
			String ans="";
			if((sb.charAt(sb.length()-1)-'0')%2==0)
				ans="Even";
			else if((sb.charAt(sb.length()-1)-'0')%2==1)
				ans="Odd";
			StringBuilder sb1 = new StringBuilder();
			sb1.append("#").append(test_case).append(" ").append(ans).append("\n");
			bw.write(sb1.toString());
		}

		bw.flush();
		bw.close();
	}
}