import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution4796{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		int TC = sc.nextInt();
		for (int test_case = 1; test_case <= TC; test_case++) {
			int N=sc.nextInt();
			int num[]=new int[N];
			int d[]=new int[N];
			for(int i=0;i<N;i++) {
				num[i]=sc.nextInt();
			}
			int mincnt=0;
			d[0]=0;
			boolean flag=true;
			for(int i=1;i<N;i++) {
				if(flag) {
					if(num[i-1]<num[i]) {
						mincnt++;
						d[i]=d[i-1];
					}
					else {
						if(mincnt>0) {
							flag=false;
							d[i]=d[i-1]+mincnt;
						}
						else {
							d[i]=d[i-1];
						}
					}
				}
				else {
					if(num[i-1]>num[i]) {
						d[i]=d[i-1]+mincnt;
					}
					else{
						d[i]=d[i-1];
						mincnt=1;
						flag=true;
					}
				}
			}
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(test_case).append(" ").append(d[N-1]).append("\n");
			bw.write(sb.toString());
		}
		bw.flush();
		bw.close();
	}

}