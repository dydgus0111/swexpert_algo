package solution;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution1966 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T=Integer.parseInt(br.readLine());
		for(int test_case=1;test_case<=T;test_case++) {
			int num=Integer.parseInt(br.readLine());
			StringBuilder sb=new StringBuilder();
			StringBuilder sb1=new StringBuilder();
			List<Integer>arr=new ArrayList<>();
			String str=br.readLine();
			StringTokenizer token=new StringTokenizer(str);
			for(int i=0;i<num;i++) {
				arr.add(Integer.parseInt(token.nextToken()));
			}
			Collections.sort(arr);
			for(int i=0;i<arr.size();i++) {
				sb1.append(arr.get(i)).append(" ");
			}
			sb.append("#").append(test_case).append(" ").append(sb1).append("\n");
			bw.write(sb.toString());
		}
		bw.flush();
		bw.close();
	}
}
