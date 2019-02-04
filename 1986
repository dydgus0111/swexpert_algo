import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out)); 
	public static void main(String[] args) throws Exception{
		int T=Integer.parseInt(br.readLine());
		for(int test_case=1;test_case<=T;test_case++) {
			StringBuilder sb=new StringBuilder();
			int num=Integer.parseInt(br.readLine());
			int sum=0;
			for(int i=1;i<=num;i++) {
				if(i%2==1) {
					sum+=i;
				}else
					sum-=i;
			}
			sb.append("#").append(test_case).append(" ").append(sum).append("\n");
			bw.write(sb.toString());
		}
		bw.flush();
		bw.close();
	}
}