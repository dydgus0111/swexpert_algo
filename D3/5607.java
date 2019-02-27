package solution;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution5607 {
	static long[] factorial=new long[1000001];
	static int div=1234567891;
	static long power(long base,long exponent) {
		long temp;
		if(exponent==0)
			return 1;
		temp=power(base, exponent/2)%div;
		if(exponent%2==0)
			return (temp*temp%div)%div;
		else {
			if(exponent>0)
				return (base*temp%div*temp%div)%div;
			else
				return ((temp*temp%div)/base)%div;
		}
	}
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T=Integer.parseInt(br.readLine());
		factorial[0]=1;
		for(int i=1;i<factorial.length;i++) {
			factorial[i]=(i*factorial[i-1])%div;
		}
		for(int test_case=1;test_case<=T;test_case++) {
			String str=br.readLine();
			StringTokenizer token=new StringTokenizer(str);
			int N=Integer.parseInt(token.nextToken());
			int R=Integer.parseInt(token.nextToken());
			StringBuilder sb=new StringBuilder();
			long ans=factorial[N]*power(factorial[N-R]*factorial[R]%div, div-2)%div;
			sb.append("#").append(test_case).append(" ").append(ans).append("\n");
			bw.write(sb.toString());
		}
		bw.flush();
		bw.close();
	}
}
