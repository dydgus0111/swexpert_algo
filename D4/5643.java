import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution5643{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N;
	static int map[][];
	static List<Student> list;
	public static void main(String[] args) throws IOException {
		StringTokenizer token;
		int TC = Integer.parseInt(br.readLine().trim());
		for (int test_case = 1; test_case <= TC; test_case++) {
			N=Integer.parseInt(br.readLine().trim());
			int M=Integer.parseInt(br.readLine().trim());
			map=new int[N+1][N+1];
			list=new ArrayList<>();
			boolean check[]=new boolean[N+1];
			for(int i=0;i<=N;i++) {
				list.add(new Student(0, 0));
			}
			for(int i=0;i<M;i++) {
				token=new StringTokenizer(br.readLine().trim());
				int a=Integer.parseInt(token.nextToken());
				int b=Integer.parseInt(token.nextToken());
				map[a][b]=1;
			}
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=N;j++) {
					if(map[i][j]==1&&!check[i]) {
						check[i]=true;
						bfs(new boolean[N+1], i);
					}
				}
			}
			int ans=0;
			for(int i=1;i<list.size();i++) {
				int sum=list.get(i).tallcnt+list.get(i).shortcnt;
				if(sum==N-1)
					ans++;
			}
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(test_case).append(" ").append(ans).append("\n");
			bw.write(sb.toString());
		}
		bw.flush();
		bw.close();
	}
	static void bfs(boolean[] check,int start) {
		Queue<Integer> queue=new LinkedList<>();
		queue.add(start);
		while(!queue.isEmpty()) {
			int next=queue.poll();
			check[next]=true;
			for(int i=1;i<map[next].length;i++) {
				if(!check[i]&&map[next][i]==1) {
					check[i]=true;
					queue.add(i);
					list.get(start).tallcnt++;
					list.get(i).shortcnt++;
				}
			}
		}
	}
	static class Student{
		int tallcnt;
		int shortcnt;
		public Student(int t, int s) {
			this.tallcnt=t;
			this.shortcnt=s;
		}
	}
}
