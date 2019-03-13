import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution7208{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int[] color;
	static int[][] map;
	static class Pair{
		int a;
		int b;
		public Pair(int a, int b) {
			this.a=a;
			this.b=b;
		}
	}
	static List<Pair> list;
	public static void main(String[] args) throws IOException {
		StringTokenizer token;
		int TC = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= TC; test_case++) {
			token=new StringTokenizer(br.readLine());
			int N=Integer.parseInt(token.nextToken());
			color=new int[N];
			map=new int[N][N];
			list=new ArrayList<>();
			int ans=0;
			token=new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				color[i]=Integer.parseInt(token.nextToken())-1;
			}
			for(int i=0;i<N;i++) {
				token=new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					int tmp=Integer.parseInt(token.nextToken());
					if(tmp==1){
						list.add(new Pair(i, j));
					}
					map[i][j]=tmp;
				}
			}
			for(int i=0;i<list.size();i++) {
				boolean tmp[]=new boolean[N];
				if(color[list.get(i).a]==color[list.get(i).b]) {
					tmp[color[list.get(i).a]]=true;
					for(int j=0;j<list.size();j++) {
						if(list.get(j).a==list.get(i).b) {
							tmp[color[list.get(j).b]]=true;
						}
					}
					for(int j=0;j<tmp.length;j++) {
						if(tmp[j])
							continue;
						else {
							color[list.get(i).b]=j;
							ans++;
							break;
						}
					}
				}
			}
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(test_case).append(" ").append(ans).append("\n");
			bw.write(sb.toString());
		}

		bw.flush();
		bw.close();
	}

}
