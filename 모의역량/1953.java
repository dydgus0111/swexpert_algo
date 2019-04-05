import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution1953 {
	//1. 탈주범(현재위치, 방향,이동횟수)객체 만들기
	//2. 방향을 통해서 다음 위치로 이동가능 한지 확인 가능한 함수
	//	이동 가능한 방향
	//	1 : 상,하,좌,우
	//	2 : 상, 하
	//	3 : 좌,우
	//	4 : 하, 좌
	//	5 : 좌, 상
	//	6 : 우, 상
	//	7 : 우, 하
	//3. bfs를 통해 탈주범 이동 시키기
	//=>현재 이동한 값을 들고다니기
	static class Escaper{
		int x;
		int y;
		int d;
		int cnt;
		int pipe;
		public Escaper(int x, int y, int d, int cnt,int pipe) {
			this.x=x;
			this.y=y;
			this.d=d;
			this.cnt=cnt;
			this.pipe=pipe;
		}
	}
	static int dx[]= {-1,1,0,0};
	static int dy[]= {0,0,-1,1};
	static int map[][];
	static int N;
	static int M;
	static int R;
	static int C;
	static int L;
	static Escaper esc;
	static int ans;
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException {
		int TC=Integer.parseInt(br.readLine());
		for(int test_case=1;test_case<=TC;test_case++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			R=Integer.parseInt(st.nextToken());
			C=Integer.parseInt(st.nextToken());
			L=Integer.parseInt(st.nextToken());
			map=new int[N][M];
			ans=0;
			for(int i=0;i<N;i++) {
				st=new StringTokenizer(br.readLine());
				for(int j=0;j<M;j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			esc=new Escaper(R, C, -1, 0,map[R][C]);
			bfs(new boolean[N][M],R,C);
			System.out.println("#"+test_case+" "+ans);
		}
	}
	static void print(boolean tmp[][]) {
		for(int i=0;i<N;i++) {
			System.out.println(Arrays.toString(tmp[i]));
		}
	}
	static int checkTrue(boolean tmp[][]) {
		int cnt=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(tmp[i][j])
					cnt++;
			}
		}
		return cnt;
	}
	//	구조물에 따라 탈주범의 방향이 바뀜
	//	이동 가능한 방향
	//	1 : 상,하,좌,우
	//	4 : 하, 좌
	//	5 : 좌, 상
	//	6 : 우, 상
	//	7 : 우, 하
	//0상,1하,2좌,3우
	static boolean isMove(int kind,Escaper esc) {
		if(kind==1) {
			return true;
		}
		else if(kind==2) {
			if(esc.d==0||esc.d==1) 
				return true;
			else
				return false;
		}
		else if(kind==3) {
			if(esc.d==2||esc.d==3) 
				return true;
			else
				return false;
		}
		else if(kind==4) {
			if(esc.d==1||esc.d==2) {
				if(esc.d==1)
					esc.d=3;
				else
					esc.d=0;
				return true;
			}
			else
				return false;
		}
		else if(kind==5) {
			if(esc.d==0||esc.d==2) {
				if(esc.d==0)
					esc.d=3;
				else
					esc.d=1;
				return true;
			}
			else
				return false;
		}
		else if(kind==6) {
			if(esc.d==0||esc.d==3) {
				if(esc.d==0)
					esc.d=2;
				else
					esc.d=1;
				return true;
			}
			else
				return false;
		}
		else if(kind==7) {
			if(esc.d==1||esc.d==3) {
				if(esc.d==1)
					esc.d=2;
				else
					esc.d=0;
				return true;
			}
			else
				return false;
		}
		return false;
	}
	static boolean isRange(int x, int y) {
		return x>=0&&x<N&&y>=0&&y<M;
	}
	static void bfs(boolean[][] visited,int x, int y) {
		Queue<Escaper> queue=new LinkedList<>();
		visited[x][y]=true;
		if(map[x][y]==1) {
			queue.add(esc);
		}
		else if(map[x][y]==2) {
			queue.add(new Escaper(x, y, 0, 0, map[x][y]));
			queue.add(new Escaper(x, y, 1, 0, map[x][y]));
		}
		else if(map[x][y]==3) {
			queue.add(new Escaper(x, y, 2, 0, map[x][y]));
			queue.add(new Escaper(x, y, 3, 0, map[x][y]));
		}
		else if(map[x][y]==4) {
			queue.add(new Escaper(x, y, 0, 0, map[x][y]));
			queue.add(new Escaper(x, y, 3, 0, map[x][y]));
		}
		else if(map[x][y]==5) {
			queue.add(new Escaper(x, y, 1, 0, map[x][y]));
			queue.add(new Escaper(x, y, 3, 0, map[x][y]));
		}
		else if(map[x][y]==6) {
			queue.add(new Escaper(x, y, 1, 0, map[x][y]));
			queue.add(new Escaper(x, y, 2, 0, map[x][y]));
		}
		else if(map[x][y]==7) {
			queue.add(new Escaper(x, y, 0, 0, map[x][y]));
			queue.add(new Escaper(x, y, 2, 0, map[x][y]));
		}
		while(!queue.isEmpty()) {
			Escaper next=queue.poll();
			if(next.cnt==L-1)
				break;
			if(next.pipe==1) {
				for(int i=0;i<4;i++) {
					int nx=next.x+dx[i];
					int ny=next.y+dy[i];
					next.d=i;
					if(isRange(nx, ny)&&map[nx][ny]!=0) {
						if(!visited[nx][ny]) {
							if(isMove(map[nx][ny], next)) {
								visited[nx][ny]=true;
								queue.add(new Escaper(nx, ny, next.d, next.cnt+1, map[nx][ny]));
							}
						}
					}
				}
			}
			else {
				int nx=next.x+dx[next.d];
				int ny=next.y+dy[next.d];
				if(isRange(nx, ny)&&map[nx][ny]!=0) {
					if(!visited[nx][ny]) {
						if(isMove(map[nx][ny], next)) {
							visited[nx][ny]=true;;
							queue.add(new Escaper(nx, ny, next.d, next.cnt+1, map[nx][ny]));
						}
					}
				}
			}
		}
		ans=checkTrue(visited);
	}
}
