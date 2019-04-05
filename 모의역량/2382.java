package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution2382_ {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static int N;//맵의 크기
	static int M;//격리시간
	static int K;//미생물 군집 수
	static int dx[]= {0,-1,1,0,0};//1상,2하,3좌,4우
	static int dy[]= {0,0,0,-1,1};
	static class Micro{
		int x;
		int y;
		int cnt;
		int d;
		boolean isSame;
		public Micro(int x, int y, int cnt, int d) {
			this.x=x;
			this.y=y;
			this.cnt=cnt;
			this.d=d;
		}
		public String toString() {
			return x+" "+y+" "+cnt+" "+d;
		}
	}
	static List<Micro> mlist;
	//시간마다 미생물 이동시키기
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T=Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			K=Integer.parseInt(st.nextToken());
			mlist=new ArrayList<Micro>();
			for(int i=0;i<K;i++) {
				st=new StringTokenizer(br.readLine());
				int x=Integer.parseInt(st.nextToken());
				int y=Integer.parseInt(st.nextToken());
				int cnt=Integer.parseInt(st.nextToken());
				int d=Integer.parseInt(st.nextToken());
				mlist.add(new Micro(x, y, cnt, d));
			}
			for(int i=0;i<M;i++) {
				moveMicro();
				sumMicro();
			}
			int ans=0;
			for(int i=0;i<mlist.size();i++) {
				ans+=mlist.get(i).cnt;
			}
			System.out.println("#"+tc+" "+ans);
		}
	}
	static boolean isRange(int x, int y) {
		return x>0&&x<N-1&&y>0&&y<N-1;
	}
	static void moveMicro() {
		for(int i=0;i<mlist.size();i++) {
				Micro tmp=mlist.get(i);
				if(tmp.cnt>0) {
					int nx=tmp.x+dx[tmp.d];
					int ny=tmp.y+dy[tmp.d];
					mlist.get(i).x=nx;
					mlist.get(i).y=ny;
					//범위 밖으로 나가면 방향반대로, 미생물 수/2
					if(!isRange(nx, ny)) {
						mlist.get(i).cnt/=2;
						if(mlist.get(i).d==1)
							mlist.get(i).d=2;
						else if(mlist.get(i).d==2)
							mlist.get(i).d=1;
						else if(mlist.get(i).d==3)
							mlist.get(i).d=4;
						else if(mlist.get(i).d==4)
							mlist.get(i).d=3;
					}
			}
		}
	}
	static void sumMicro() {
		for(int i=0;i<mlist.size();i++) {
			Micro a=mlist.get(i);
			boolean flag=false;
			int max=a.cnt;
			int maxidx=i;
			for(int j=0;j<mlist.size();j++) {
				Micro b=mlist.get(j);
				if(a.x==b.x&&a.y==b.y) {
					if(a.cnt==b.cnt)
						continue;
					else {
						mlist.get(j).isSame=true;
						if(max<mlist.get(j).cnt) {
							max=mlist.get(j).cnt;
							maxidx=j;
						}
						flag=true;
					}
				}
			}
			if(flag) {
				mlist.get(i).isSame=true;
				for(int j=0;j<mlist.size();j++) {
					if(j==maxidx)
						continue;
					if(mlist.get(j).isSame) {
						mlist.get(maxidx).cnt+=mlist.get(j).cnt;
						mlist.get(j).cnt=0;
						mlist.get(j).isSame=false;
					}
				}
				mlist.get(maxidx).isSame=false;
			}
		}
	}
}