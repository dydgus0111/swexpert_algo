import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;
//1. 입력된 숫자가 누를 수 있는 숫자들로만 이루어질 경우 그 자릿수+1이 답.
//
public class Solution1808{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int[] d;
	static boolean[] num;
	public static void main(String[] args) throws IOException {
		StringTokenizer token;
		int TC = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= TC; test_case++) {
			token=new StringTokenizer(br.readLine());
			d=new int[1000001];
			num=new boolean[10];
			ans=Integer.MAX_VALUE;
			for(int i=0;i<10;i++) {
				if(Integer.parseInt(token.nextToken())==1)
					num[i]=true;
			}
			token=new StringTokenizer(br.readLine());
			String str=token.nextToken();
			int N=Integer.parseInt(str);
			boolean flag=true;
			if(isPush(N))
				ans=str.length()+1;
			else {
				recur(N,0);
			}
			if(ans==Integer.MAX_VALUE)
				ans=-1;
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(test_case).append(" ").append(ans).append("\n");
			bw.write(sb.toString());
		}

		bw.flush();
		bw.close();
	}
	static List<Integer> divisor(int n){
		List<Integer> list=new ArrayList<>();
		for(int i=1;i<=n;i++) {
			if(n%i==0) {
				list.add(i);
			}
		}
		return list;
	}
	static boolean isPush(int n) {
		String str=String.valueOf(n);
		int cnt=0;
		for(int i=0;i<str.length();i++) {
			for(int j=0;j<10;j++) {
				if(!num[n%10]) {
					n/=10;
					break;
				}
				else {
					cnt++;
					n/=10;
					break;
				}
			}
		}
		if(cnt==str.length())
			return true;
		else
			return false;
	}
	static int ans=Integer.MAX_VALUE;
	static void recur(int num,int cnt) {
		List<Integer> list=new ArrayList<>();
		list=divisor(num);
		for(int i=0;i<list.size();i++) {
			if(list.get(i)==1)
				continue;
			if(isPush(list.get(i))) {
				int tmp=cnt;
				tmp+=String.valueOf(list.get(i)).length();
				if(isPush(num/list.get(i))) {
					tmp+=String.valueOf(num/list.get(i)).length()+1;
					if(ans>tmp+1) {
						ans=tmp+1;
					}
				}
				else
					recur(num/list.get(i), tmp+1);
			}
		}
	}
}
