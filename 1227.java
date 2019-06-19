package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution1227 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static int map[][]=new int[100][100];
	static int dx[]= {-1,1,0,0};
	static int dy[]= {0,0,-1,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		for(int tc=1;tc<=10;tc++) {
			br.readLine();
			ans=0;
			int sx=0;
			int sy=0;
			for(int i=0;i<100;i++) {
				String str=br.readLine();
				for(int j=0;j<100;j++) {
					map[i][j]=str.charAt(j)-'0';
					if(str.charAt(j)-'0'==2) {
						sx=i;
						sy=j;
					}
				}
			}
			bfs(sx, sy, new boolean[100][100]);
			StringBuilder sb=new StringBuilder();
			sb.append("#").append(tc).append(" ").append(ans);
			System.out.println(sb.toString());
		}
	}
	static class pair{
		int x;
		int y;
		public pair(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}
	static boolean isRange(int x, int y) {
		return x>=0&&x<100&&y>=0&&y<100;
	}
	static int ans;
	static void bfs(int sx,int sy,boolean check[][]) {
		Queue<pair> queue=new LinkedList<pair>();
		queue.add(new pair(sx, sy));
		boolean flag=false;
		while(!queue.isEmpty()) {
			pair next=queue.poll();
			for(int i=0;i<4;i++) {
				int nx=next.x+dx[i];
				int ny=next.y+dy[i];
				if(isRange(nx, ny)&&!check[nx][ny]) {
					if(map[nx][ny]==0) {
						check[nx][ny]=true;
						queue.add(new pair(nx, ny));
					}
					else if(map[nx][ny]==3) {
						flag=true;
					}
				}
				if(flag)
					break;
			}
			if(flag)
				break;
		}
		if(flag)
			ans=1;
	}
}
