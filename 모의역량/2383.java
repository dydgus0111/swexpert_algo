package exercise;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
//1.사람들이 이동하는 모든 경우의 수 구하기(사람 수^계단수(2))
//2.각 사람에 맞는 계단으로 다 이동 시켜서 내려보내기
//=>다 이동시키고 계단에 넣던지 빼던지 하자
public class Solution2383{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N;
	static int map[][];
	static List<People> plist;
	static List<Stair> slist;	//0번 계단, 1번 계단
	static int ans;
	public static void main(String[] args) throws IOException {
		StringTokenizer token;
		int TC = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= TC; test_case++) {
			ans=Integer.MAX_VALUE;
			N=Integer.parseInt(br.readLine());
			map=new int[N][N];
			plist=new ArrayList<>();
			slist=new ArrayList<>();
			for(int i=0;i<N;i++) {
				token=new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					int input=Integer.parseInt(token.nextToken());
					if(input==1) {
						plist.add(new People(i, j));
					}
					else if(input!=1&&input!=0) {
						slist.add(new Stair(i, j, input));
					}
				}
			}
			selectStair(new int[plist.size()], 0);
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(test_case).append(" ").append(ans).append("\n");
			bw.write(sb.toString());
		}
		bw.flush();
		bw.close();
	}
	static void selectStair(int sel[],int n) {
		if(n==plist.size()) {
			for(int i=0;i<plist.size();i++) {
				plist.get(i).stair=sel[i];
			}
			List<People> tmplist=new ArrayList<>();
			for(int i=0;i<plist.size();i++) {
				int tx=plist.get(i).x;
				int ty=plist.get(i).y;
				int ts=plist.get(i).stair;
				tmplist.add(new People(tx, ty,ts,0));
			}
			move(sel, tmplist);
			return;
		}
		for(int i=0;i<slist.size();i++) {
			sel[n]=i;
			selectStair(sel, n+1);
		}
	}
	static void calcDist(List<People> tmplist) {
		for(int i=0;i<plist.size();i++) {
			int stair=plist.get(i).stair;
			int px=plist.get(i).x;
			int py=plist.get(i).y;
			int sx=slist.get(stair).x;
			int sy=slist.get(stair).y;
			tmplist.get(i).dist=Math.abs(px-sx)+Math.abs(py-sy);
		}
	}
	static void move(int select[],List<People> tmplist) {
		int time=0;
		int cnt=0;
		calcDist(tmplist);
		
		Queue<People> stair0=new LinkedList<>();
		Queue<People> stair1=new LinkedList<>();
		Queue<People> wait0=new LinkedList<>();
		Queue<People> wait1=new LinkedList<>();
		while(cnt!=plist.size()) {
			//계단으로 이동 => 계단에 도착하면 wait로 넣기
			//계단에 들어가도 이동
			time++;
			for(int i=0;i<tmplist.size();i++) {
				if(tmplist.get(i).status==3)
					continue;
				if(tmplist.get(i).dist!=0&&tmplist.get(i).status==0) {
					tmplist.get(i).dist--;
				}
				else if(tmplist.get(i).dist==0&&tmplist.get(i).status==0){
					if(tmplist.get(i).stair==0) {
						wait0.add(tmplist.get(i));
						tmplist.get(i).status=1;
					}
					else {
						wait1.add(tmplist.get(i));
						tmplist.get(i).status=1;
					}
				}
				else if(tmplist.get(i).status==2) {
					tmplist.get(i).dist--;
				}
			}
			//계단에 있던 애가 밑에 도착하면 꺼내기
			while(!stair0.isEmpty()) {
				if(stair0.peek().dist==slist.get(0).time*-1) {
					stair0.peek().status=3;
					stair0.poll();
					cnt++;
				}
				else
					break;
			}
			while(!stair1.isEmpty()) {
				if(stair1.peek().dist==slist.get(1).time*-1) {
					stair1.peek().status=3;
					stair1.poll();
					cnt++;
				}
				else
					break;
			}
			//wait에 있는 애들 계단에 넣기
			while(!wait0.isEmpty()) {
				if(stair0.size()<3) {
					wait0.peek().status=2;
					stair0.add(wait0.poll());
				}
				else
					break;
			}
			while(!wait1.isEmpty()) {
				if(stair1.size()<3) {
					wait1.peek().status=2;
					stair1.add(wait1.poll());
				}
				else
					break;
			}
		}
		if(ans>time)
			ans=time;
	}
	static class People{
		int x;
		int y;
		int status;	//0은 계단으로 가는중, 1은 대기중, 2는 계단, 3은 나감
		int stair;
		int dist;
		public People(int x, int y) {
			this.x=x;
			this.y=y;
		}
		public People(int x, int y,int stair,int status) {
			this.x=x;
			this.y=y;
			this.stair=stair;
			this.status=status;
		}
	}
	static class Stair{
		int x;
		int y;
		int time;
		public Stair(int x, int y, int time) {
			this.x=x;
			this.y=y;
			this.time=time;
		}
	}
}