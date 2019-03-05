package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution4530{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		Pair []arr=new Pair[13];
		arr[0]=new Pair(1, 1);
		arr[1]=new Pair(10, 9);
		for(int i=2;i<arr.length;i++) {
			arr[i]=new Pair((long)Math.pow(10, i), (arr[i-1].bf+arr[i-1].ff)*9);
		}
//		for(int i=0;i<arr.length;i++) {
//			System.out.println(i+"="+arr[i].ff+" "+arr[i].bf);
//		}
		StringTokenizer token;
		int TC = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= TC; test_case++) {
			token=new StringTokenizer(br.readLine());
			long num1=Long.parseLong(token.nextToken());
			String str1=String.valueOf(Math.abs(num1));
			long num2=Long.parseLong(token.nextToken());
			String str2=String.valueOf(Math.abs(num2));
			long num=0;
			if(num1<0&&num2<0) {
				num1=Math.abs(num1);
				num2=Math.abs(num2);
			}
			if((num1>0&&num2>0)) {
				for(int j=0;j<str1.length();j++) {
					for(int i=0;i<str1.charAt(j)-'0';i++) {
						if(i==4) {
							num1-=arr[str1.length()-j-1].ff;
						}
						else {
							num1-=arr[str1.length()-j-1].bf/9;
						}
					}
				}
				for(int j=0;j<str2.length();j++) {
					for(int i=0;i<str2.charAt(j)-'0';i++) {
						if(i==4) {
							num2-=arr[str2.length()-j-1].ff;
						}
						else {
							num2-=arr[str2.length()-j-1].bf/9;
						}
					}
				}
				num=Math.abs(num2-num1);
			}
			else if((num1<0&&num2>0)||(num1>0&&num2<0)){
				num=Math.abs(num1)+num2;
				for(int j=0;j<str1.length();j++) {
					for(int i=0;i<str1.charAt(j)-'0';i++) {
						if(i==4) {
							num-=arr[str1.length()-j-1].ff;
						}
						else {
							num-=arr[str1.length()-j-1].bf/9;
						}
					}
				}
				for(int j=0;j<str2.length();j++) {
					for(int i=0;i<str2.charAt(j)-'0';i++) {
						if(i==4) {
							num-=arr[str2.length()-j-1].ff;
						}
						else {
							num-=arr[str2.length()-j-1].bf/9;
						}
					}
				}
			}
			long ans=num;
			if((num1<0&&num2>0)||(num1>0&&num2<0))
				ans--;
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(test_case).append(" ").append(ans).append("\n");
			bw.write(sb.toString());
		}
		bw.flush();
		bw.close();
	}
	static class Pair{
		long ff;//젤 앞이 4
		long bf;//젤 앞을 제외한 나머지에서 4
		public Pair(long ff, long bf) {
			this.ff=ff;
			this.bf=bf;
		}
	}
}



