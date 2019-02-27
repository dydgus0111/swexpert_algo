package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution1926 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws Exception {
		int num = Integer.parseInt(br.readLine().trim());
		StringBuilder sb=new StringBuilder();
		for (int i = 1; i <= num; i++) {
			if (i <= 10) {
				if (i % 3 == 0)
					sb.append("-").append(" ");
				else
					sb.append(i).append(" ");
			} else if (i > 10 && i < 100) {
				if (i%10!=0&&(i % 10) % 3 == 0) {
					sb.append("-");
					int temp=i;
					temp /= 10;
					if (temp % 3 == 0) {
						sb.append("-").append(" ");
					} else {
						sb.append(" ");
					}
				} else {
					int temp=i;
					temp/=10;
					if(temp%3==0) {
						sb.append("-").append(" ");
					}else
						sb.append(i).append(" ");
				}
			} 
			if (i >= 100 && i <= 1000) {
				int []arr=new int[3];
				int temp=i;
				arr[2]=temp/100;
				temp%=100;
				if(temp<10) {
					arr[1]=0;					
					temp%=10;
					arr[0]=temp;
				}else {
					arr[1]=temp/10;
					arr[0]=temp%10;
				}
				boolean flag=false;
				if(arr[0]!=0&&arr[0]%3==0) {
					sb.append("-");
					flag=false;
				}else
					flag=true;
				if(arr[1]!=0&&arr[1]%3==0) {
					sb.append("-");
					flag=false;
				}else if(!flag)
					flag&=false;
				if(arr[2]!=0&&arr[2]%3==0) {
					sb.append("-");
					flag=false;
				}else if(!flag)
					flag&=true;
				if(flag)
					sb.append(i).append(" ");
				else
					sb.append(" ");
			}
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
