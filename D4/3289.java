import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution3289{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		StringTokenizer token;
		int TC = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= TC; test_case++) {
			token=new StringTokenizer(br.readLine());
			int n=Integer.parseInt(token.nextToken());
			int m=Integer.parseInt(token.nextToken());
			parent=new int[n+1];
			rank=new int[n+1];
			for(int i=1;i<=n;i++) {
				makeSet(i);
				rank[i]=1;
			}
			StringBuilder ans=new StringBuilder();
			for(int i=0;i<m;i++) {
				token=new StringTokenizer(br.readLine());
				int op=Integer.parseInt(token.nextToken());
				int a=Integer.parseInt(token.nextToken());
				int b=Integer.parseInt(token.nextToken());
				if(op==0) {
					union(a, b);
				}
				else {
					if(findSet(a)==findSet(b))
						ans.append("1");
					else
						ans.append("0");
				}
			}
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(test_case).append(" ").append(ans.toString()).append("\n");
			bw.write(sb.toString());
		}

		bw.flush();
		bw.close();
	}
	static int[] parent;
	static int[] rank;
	static void makeSet(int x) {
		parent[x]=x;
	}
	static int findSet(int x) {
		if(parent[x]==x)
			return x;
		parent[x]=findSet(parent[x]);
		return parent[x];
	}
	static void union(int x,int y) {
		int px=findSet(x);
		int py=findSet(y);
		if(rank[px]>rank[py]) {
			parent[py]=px;
		}
		else {
			parent[px]=py;
			if(rank[px]==rank[py]) {
				rank[py]++;
			}
		}
	}
}