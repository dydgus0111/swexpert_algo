package d3;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution1873{	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int []dx= {-1,1,0,0};//0:U, 1:D, 2:L, 3:R
	static int []dy= {0,0,-1,1};
	static char []dt= {'^','v','<','>'};
	static int tankx=0;
	static int tanky=0;
	static char[][] makemap(char [][]arr,char op,int H,int W){
		switch(op){
		case 'U':{
			if(tankx+dx[0]>=0) {
				if(checkfield(arr, tankx+dx[0], tanky+dy[0])) {
					arr[tankx][tanky]='.';
					tankx+=dx[0];
					tanky+=dy[0];
					arr[tankx][tanky]=dt[0];
				}else
					arr[tankx][tanky]=dt[0];
			}else
				arr[tankx][tanky]=dt[0];
			break;
		}
		case 'D':{
			if(tankx+dx[1]<H) {
				if(checkfield(arr, tankx+dx[1], tanky+dy[1])) {
					arr[tankx][tanky]='.';
					tankx+=dx[1];
					tanky+=dy[1];
					arr[tankx][tanky]=dt[1];
				}else
					arr[tankx][tanky]=dt[1];
			}else
				arr[tankx][tanky]=dt[1];
			break;
		}
		case 'L':{
			if(tanky+dy[2]>=0) {
				if(checkfield(arr, tankx+dx[2], tanky+dy[2])) {
					arr[tankx][tanky]='.';
					tankx+=dx[2];
					tanky+=dy[2];
					arr[tankx][tanky]=dt[2];
				}else
					arr[tankx][tanky]=dt[2];
			}else
				arr[tankx][tanky]=dt[2];
			break;
		}
		case 'R':{
			if(tanky+dy[3]<W) {
				if(checkfield(arr, tankx+dx[3], tanky+dy[3])) {
					arr[tankx][tanky]='.';
					tankx+=dx[3];
					tanky+=dy[3];
					arr[tankx][tanky]=dt[3];
				}else
					arr[tankx][tanky]=dt[3];
			}else
				arr[tankx][tanky]=dt[3];
			break;
		}
		case 'S':{
			shot(arr,H,W);
			break;
		}
		default:
			break;
		}
		return arr;
	}
	static boolean checkfield(char [][]arr,int cx,int cy) {
		if(arr[cx][cy]=='.') {
			return true;
		}else
			return false;
	}
	static void shot(char [][]arr,int H, int W) {
		if(arr[tankx][tanky]=='^') {
			int temp=tankx+dx[0];
			if(temp>=0) {
				while(true) {
					if(arr[temp][tanky]=='*') {
						arr[temp][tanky]='.';
						break;
					}else if(arr[temp][tanky]=='#') {
						break;
					}else {
						temp+=dx[0];
						if(temp<0)
							break;
					}
				}
			}
		}
		else if(arr[tankx][tanky]=='v') {
			int temp=tankx+dx[1];
			if(temp<H) {
				while(true) {
					if(arr[temp][tanky]=='*') {
						arr[temp][tanky]='.';
						break;
					}else if(arr[temp][tanky]=='#') {
						break;
					}else {
						temp+=dx[1];
						if(temp>=H)
							break;
					}
				}
			}
		}
		else if(arr[tankx][tanky]=='<') {
			int temp=tanky+dy[2];
			if(temp>=0) {
				while(true) {
					if(arr[tankx][temp]=='*') {
						arr[tankx][temp]='.';
						break;
					}else if(arr[tankx][temp]=='#') {
						break;
					}else {
						temp+=dy[2];
						if(temp<0)
							break;
					}
				}
			}
		}
		else if(arr[tankx][tanky]=='>') {
			int temp=tanky+dy[3];
			if(temp<W) {
				while(true) {
					if(arr[tankx][temp]=='*') {
						arr[tankx][temp]='.';
						break;
					}else if(arr[tankx][temp]=='#') {
						break;
					}else {
						temp+=dy[3];
						if(temp>=W)
							break;
					}
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		StringTokenizer token;
		int TC = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= TC; test_case++) {
			token=new StringTokenizer(br.readLine());
			int H=Integer.parseInt(token.nextToken());
			int W=Integer.parseInt(token.nextToken());
			char [][]map = new char[H][W];
			for(int i=0;i<H;i++) {
				String str=br.readLine();
				for(int j=0;j<W;j++) {
					char temp=str.charAt(j);
					map[i][j]=temp;
					if(temp=='^'||temp=='v'||temp=='<'||temp=='>') {
						tankx=i;
						tanky=j;
					}
				}
			}
			String str=br.readLine();
			str=br.readLine();
			int N=str.length();
			for(int i=0;i<N;i++) {
				char op=str.charAt(i);
				map=makemap(map,op,H,W);
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(test_case).append(" ");
			bw.write(sb.toString());
			for(int i=0;i<H;i++) {
				for(int j=0;j<W;j++) {
					bw.write(map[i][j]);
				}
				bw.write("\n");
			}
		}

		bw.flush();
		bw.close();
	}

}
