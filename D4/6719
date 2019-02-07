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

public class Solution6719 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T=Integer.parseInt(br.readLine());
		for(int test_case=1;test_case<=T;test_case++) {
			String str=br.readLine();
			StringTokenizer token=new StringTokenizer(str);
			StringBuilder sb=new StringBuilder();
			int N=Integer.parseInt(token.nextToken());
			List<Integer> list=new ArrayList<>();
			int K=Integer.parseInt(token.nextToken());
			str=br.readLine();
			token=new StringTokenizer(str);
			for(int i=0;i<N;i++) {
				list.add(Integer.parseInt(token.nextToken()));
			}
			Collections.sort(list);
			float ans=0;
			for(int i=list.size()-K;i<list.size();i++) {
				ans=(ans+list.get(i))/2;
			}
			sb.append("#").append(test_case).append(" ").append(ans).append("\n");
			bw.write(sb.toString());
		}
		bw.flush();
		bw.close();
	}
}
