package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Solution5658{
	static HashSet<String> hs;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		StringTokenizer token;
		int TC = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= TC; test_case++) {
			token=new StringTokenizer(br.readLine());
			int N=Integer.parseInt(token.nextToken());
			int K=Integer.parseInt(token.nextToken());
			int size=N/4;
			hs=new HashSet<>();
			List<Integer> list=new ArrayList<>();
			StringBuilder pass=new StringBuilder();
			String str=br.readLine();
			for(int i=0;i<str.length();i++) {
				pass.append(str.charAt(i));
			}
			for(int i=0;i<size;i++) {
				int cnt=0;
				for(int j=0;j<4;j++) {
					String tmp=pass.substring(cnt, cnt+size);
					if(!hs.contains(tmp)) {
						hs.add(tmp);
						list.add(changeDec(tmp));
					}
					cnt+=size;
				}
				rotate(pass);
			}
			Collections.sort(list, new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					return  Integer.compare(o1, o2)*-1;
				}
				
			});
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(test_case).append(" ").append(list.get(K-1)).append("\n");
			bw.write(sb.toString());
		}

		bw.flush();
		bw.close();
	}
	static void rotate(StringBuilder sb) {
		char tmp=sb.charAt(0);
		sb.deleteCharAt(0);
		sb.append(tmp);
	}
	static int changeDec(String str) {
		int size=str.length()-1;
		int dec=0;
		for(int i=0;i<str.length();i++) {
			char tmp=str.charAt(i);
			int num=0;
			if(tmp=='A') {
				num=10;
			}
			else if(tmp=='B') {
				num=11;
			}
			else if(tmp=='C') {
				num=12;
			}
			else if(tmp=='D') {
				num=13;
			}
			else if(tmp=='E') {
				num=14;
			}
			else if(tmp=='F') {
				num=15;
			}
			else
				num=tmp-'0';
			dec+=Math.pow(16, size)*num;
			size--;
		}
		return dec;
	}
}