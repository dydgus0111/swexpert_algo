import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
//1
//4 10
//5 10
//4 40
//6 30
//3 50

public class Solution3282{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		StringTokenizer token;
		int TC = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= TC; test_case++) {
			StringBuilder sb = new StringBuilder();
			token=new StringTokenizer(br.readLine());
			int N=Integer.parseInt(token.nextToken());
			int K=Integer.parseInt(token.nextToken());
			List<Bag> list=new ArrayList<>();
			for(int i=0;i<N;i++) {
				token=new StringTokenizer(br.readLine());
				int v=Integer.parseInt(token.nextToken());
				int c=Integer.parseInt(token.nextToken());
				list.add(new Bag(v, c));
			}
			int[][] d=new int[list.size()+1][K+1];
			
			for(int i=1;i<K+1;i++) {
				if(i-list.get(0).v<0) {
					d[0][i]=0;
				}
				else
					d[0][i]=list.get(0).c;
			}
			for(int i=1;i<list.size();i++) {
				for(int j=1;j<K+1;j++) {
					if(j-list.get(i).v<0) {
						d[i][j]=d[i-1][j];
					}
					else
						d[i][j]=Math.max(d[i-1][j], d[i-1][j-list.get(i).v]+list.get(i).c);
				}
			}
			sb.append("#").append(test_case).append(" ").append(d[N-1][K]).append("\n");
			bw.write(sb.toString());
		}

		bw.flush();
		bw.close();
	}
	static class Bag{
		int v;//부피
		int c;//가치
		public Bag(int v, int c) {
			this.v=v;
			this.c=c;
		}
	}
}