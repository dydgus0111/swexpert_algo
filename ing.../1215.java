import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution1215 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws NumberFormatException, IOException {
		for(int test_case=1;test_case<=1;test_case++) {
			int N=Integer.parseInt(br.readLine());
			StringBuilder sb=new StringBuilder();
			char [][]arr=new char[8][8];
			int ans=0;
			for(int i=0;i<8;i++) {
				String str=br.readLine();
				arr[i]=str.toCharArray();
			}
			boolean flag1=true;
			boolean flag2=true;
			for(int i=0;i<8;i++) {
				for(int k=0;k<=8-N;k++) {
					for(int j=k;j<8;j++) {
						System.out.println(arr[i][j]+" "+arr[i][N-j-1]);
						System.out.println(i+" "+k+"/"+i+" "+(8-j-1));
						if(arr[i][j-N]!=arr[i][8-j-1]) {
							flag1=false;
						}
					}
				}
				System.out.println("========================");
			}
			sb.append("#").append(test_case).append(" ").append(ans).append("\n");
			bw.write(sb.toString());
		}
		bw.flush();
		bw.close();
	}
}
