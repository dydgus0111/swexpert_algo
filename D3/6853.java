package d3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution6853{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int x1;
	static int y1;
	static int x2;
	static int y2;
	static int ans1;
	static int ans2;
	static int ans3;
	public static void main(String[] args) throws IOException {
		StringTokenizer token;
		int TC = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= TC; test_case++) {
			//1. 점이 직사각형 내부에 있는
			//2. 점이 직사각형 네 변중 하나의 위에 있는
			//3. 점이 직사각형 외부에 있는
			token=new StringTokenizer(br.readLine());
			x1=Integer.parseInt(token.nextToken());
			y1=Integer.parseInt(token.nextToken());
			x2=Integer.parseInt(token.nextToken());
			y2=Integer.parseInt(token.nextToken());
			ans1=0; //점이 직사각형 내부에
			ans2=0; //점이 직사각형 변 위에
			ans3=0; //점이 직사각형 밖에
			token=new StringTokenizer(br.readLine());
			int n=Integer.parseInt(token.nextToken());
			for(int i=0;i<n;i++) {
				token=new StringTokenizer(br.readLine());
				int x=Integer.parseInt(token.nextToken());
				int y=Integer.parseInt(token.nextToken());
				isRange(x, y);
			}
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(test_case).append(" ").append(ans1).append(" ").append(ans2).append(" ").append(ans3).append("\n");
			bw.write(sb.toString());
		}

		bw.flush();
		bw.close();
	}
	static void isRange(int x, int y) {
		if(x>x1&&x<x2&&y>y1&&y<y2)
			ans1++;
		else if(x<x1||x>x2||y<y1||y>y2)
			ans3++;
		else if(x==x1||x==x2||y==y1||y==y2)
			ans2++;
	}
}
