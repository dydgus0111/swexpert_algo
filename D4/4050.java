import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Solution4050{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		StringTokenizer token;
		int TC = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= TC; test_case++) {
			int N=Integer.parseInt(br.readLine());
			List<Integer> list=new ArrayList<>();
			token=new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				list.add(Integer.parseInt(token.nextToken()));
			}
			int sum=0;
			Collections.sort(list, new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					return Integer.compare(o1, o2)*-1;
				}
			});
			int idx=0;
			boolean flag=true;
			while(true) {
				if(list.size()-idx<3) {
					flag=false;
					break;
				}
				sum+=list.get(idx)+list.get(idx+1);
				idx+=3;
				if(idx>=list.size())
					break;
			}
			if(!flag) {
				for(int i=idx;i<list.size();i++) {
					sum+=list.get(i);
				}
			}
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(test_case).append(" ").append(sum).append("\n");
			bw.write(sb.toString());
		}
		bw.flush();
		bw.close();
	}

}
