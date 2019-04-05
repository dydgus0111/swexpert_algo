package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Solution1767 {
	//가장 자리에 있는 프로세스는 확인 안해도됨
	//dfs로 완탐
	//4방향으로 다 돌려보기. (선끼리 겹치거나 프로세스가 있음 안됨)
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static int dx[]= {0,-1,1,0,0};
	static int dy[]= {0,0,0,-1,1};
	static int map[][];
	static int N;
	static List<Point> plist;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int t=Integer.parseInt(br.readLine());
		for(int tc=1;tc<=t;tc++) {
			N=Integer.parseInt(br.readLine().trim());
			map=new int[N][N];
			plist=new ArrayList<Point>();
			ans=Integer.MAX_VALUE;
			maxlist=new ArrayList<Max>();
			for(int i=0;i<N;i++) {
				StringTokenizer st=new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					int input=Integer.parseInt(st.nextToken());
					map[i][j]=input;
					if(input==1) {
						if(i!=0&&i!=N-1&&j!=0&&j!=N-1)
							plist.add(new Point(i, j));
					}
				}
			}
			dfs(0, map);
			Collections.sort(maxlist, new Comparator<Max>() {

				@Override
				public int compare(Max o1, Max o2) {
					if(o1.pcnt==o2.pcnt) {
						return Integer.compare(o1.linecnt, o2.linecnt);
					}
					else
						return Integer.compare(o1.pcnt, o2.pcnt)*-1;
				}
			});
//			for(int i=0;i<maxlist.size();i++) {
//				System.out.println(maxlist.get(i).pcnt+" "+maxlist.get(i).linecnt);
//			}
			System.out.println("#"+tc+" "+maxlist.get(0).linecnt);
		}
	}
	static class Max{
		int pcnt;
		int linecnt;
		public Max(int pcnt, int linecnt) {
			this.pcnt=pcnt;
			this.linecnt=linecnt;
		}
	}
	static class Point{
		int x;
		int y;
		boolean use;
		public Point(int x ,int y) {
			this.x=x;
			this.y=y;
		}
	}
	static boolean isRange(int x, int y) {
		return x>=0&&x<N&&y>=0&&y<N;
	}
	static int countLine(int[][] map) {
		int cnt=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]==2)
					cnt++;
			}
		}
		return cnt;
	}
	static void print(int map[][]) {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
	static int ans;
	static List<Max> maxlist;
	static void dfs(int n,int[][] map) {
		if(n==plist.size()) {
			int cnt=0;
			for(int i=0;i<plist.size();i++) {
				if(plist.get(i).use) {
					cnt++;
				}
			}
			int linecnt=countLine(map);
			maxlist.add(new Max(cnt, linecnt));
			return;
		}
		for(int i=1;i<5;i++) {
			int nx=plist.get(n).x+dx[i];
			int ny=plist.get(n).y+dy[i];
			boolean flag=true;
			while(true) {
				if(!isRange(nx, ny)) {
					break;
				}
				if(isRange(nx, ny)&&map[nx][ny]==0) {
					nx+=dx[i];
					ny+=dy[i];
				}
				else if(isRange(nx, ny)&&map[nx][ny]!=0) {
					flag=false;
					break;
				}
			}
			if(flag) {
				int tmp[][]=new int[N][N];
				for(int j=0;j<N;j++) {
					tmp[j]=Arrays.copyOf(map[j], map[j].length);
				}
				int tx=plist.get(n).x+dx[i];
				int ty=plist.get(n).y+dy[i];
				while(isRange(tx, ty)) {
					map[tx][ty]=2;
					tx+=dx[i];
					ty+=dy[i];
				}
				plist.get(n).use=true;
				dfs(n+1,map);
				map=tmp;
			}
		}
		plist.get(n).use=false;
		dfs(n+1,map);
	}
}