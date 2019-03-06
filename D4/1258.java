package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution1258 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static int[][] map;
	static int[][] visit;
	static int[] dx= {-1,1,0,0};//상,하,좌,우
	static int[] dy= {0,0,-1,1};
	static int N;
	public static void main(String[] args) throws IOException {
		StringTokenizer token=new StringTokenizer(br.readLine());
		int TC=Integer.parseInt(token.nextToken());
		for(int test_case=1;test_case<=TC;test_case++) {
			token=new StringTokenizer(br.readLine());
			N=Integer.parseInt(token.nextToken());
			map=new int[N][N];
			visit=new int[N][N];
			list=new ArrayList<>();
			for(int i=0;i<N;i++) {
				token=new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					map[i][j]=Integer.parseInt(token.nextToken());
				}
			}
			int cnt=1;
			int x=0;
			int y=0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(visit[i][j]==0&&map[i][j]!=0) {
						x=i;
						y=j;
						bfs(x,y,cnt);
						sizeCheck(x, y, cnt);
						cnt++;
					}
				}
			}
//			Collections.sort(list, new Comparator<Matrix>() {
//				@Override
//				public int compare(Matrix o1, Matrix o2) {
//					if(o1.size>o2.size)
//						return 1;
//					else if(o1.size<o2.size)
//						return -1;
//					else if(o1.size==o2.size) {
//						if(o1.col>o2.col)
//							return -1;
//						else 
//							return 1;
//					}
//					else 
//						return 0;
//				}
//			});
			list.sort(null);
			StringBuilder sb=new StringBuilder();
			sb.append("#").append(test_case).append(" ").append(list.size()).append(" ");
			for(int i=0;i<list.size();i++) {
				sb.append(list.get(i).row).append(" ").append(list.get(i).col).append(" ");
			}
			bw.write(sb.toString()+"\n");
		}
		bw.flush();
		bw.close();
	}
	static class Pair{
		int x;
		int y;
		public Pair(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}
	static boolean isRange(int x, int y) {
		return x>=0&&x<N&&y>=0&&y<N;
	}
	static class Matrix implements Comparable<Matrix>{
		int row;
		int col;
		int size;
		public Matrix(int row, int col) {
			this.row=row;
			this.col=col;
			this.size=row*col;
		}
		public String toString() {
			return row+" "+col+" "+size;
		}
		@Override
		public int compareTo(Matrix o) {
			if(size==o.size)
				return row-o.row;
			else
				return size-o.size;
		}
	}
	static List<Matrix> list;
	static void sizeCheck(int x, int y, int cnt) {
		int rowcnt=0;
		int colcnt=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(visit[i][j]==cnt) {
					colcnt++;
				}
			}
			if(colcnt>0)
				break;
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(visit[j][i]==cnt) {
					rowcnt++;
				}
			}
			if(rowcnt>0)
				break;
		}
		list.add(new Matrix(rowcnt, colcnt));
	}
	static void bfs(int x, int y,int cnt) {
		Queue<Pair> queue=new LinkedList<>();
		queue.add(new Pair(x, y));
		visit[x][y]=cnt;
		map[x][y]=0;
		while(!queue.isEmpty()) {
			Pair next=queue.poll();
			for(int i=0;i<4;i++) {
				int nx=next.x+dx[i];
				int ny=next.y+dy[i];
				if(isRange(nx, ny)) {
					if(visit[nx][ny]==0&&map[nx][ny]!=0) {
						visit[nx][ny]=cnt;
						map[nx][ny]=0;
						queue.add(new Pair(nx, ny));
					}
				}
			}
		}
	}
}
