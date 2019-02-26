package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution1234{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		for (int test_case = 1; test_case <= 10; test_case++) {
			StringTokenizer token=new StringTokenizer(br.readLine());
			token.nextToken();
			String str=token.nextToken();
			List<Character> list=new ArrayList<>();
			for(int i=0;i<str.length();i++) {
				list.add(str.charAt(i));
			}
			for(int i=0;i<list.size()-1;i++) {
				if(list.get(i)==list.get(i+1)) {
					list.remove(i);
					list.remove(i);
					i-=2;
					if(i<0)
						i=-1;
				}
			}
			StringBuilder ans=new StringBuilder();
			for(int i=0;i<list.size();i++) {
				ans.append(list.get(i));
			}
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(test_case).append(" ").append(ans).append("\n");
			bw.write(sb.toString());
		}

		bw.flush();
		bw.close();
	}

}