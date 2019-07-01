package SWExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution7829 {
	//1. P가 1 이상이면 입력받은 수를 오름차순 정렬하고, 제일 처음과 제일 마지막 곱하기.
	//1이면 그 수 제곱하기.
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException {
		int TestCase=Integer.parseInt(br.readLine());
		for(int TC=1;TC<=TestCase;TC++) {
			int P=Integer.parseInt(br.readLine());
			int [] aliquot=new int[P];
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int i=0;i<P;i++) {
				aliquot[i]=Integer.parseInt(st.nextToken());
			}
			int ans=0;
			if(P==1)
				ans=aliquot[0]*aliquot[0];
			else {
				Arrays.sort(aliquot);
				ans=aliquot[0]*aliquot[P-1];
			}
			StringBuilder sb=new StringBuilder();
			sb.append("#").append(TC).append(" ").append(ans);
			System.out.println(sb.toString());
		}
	}
}
