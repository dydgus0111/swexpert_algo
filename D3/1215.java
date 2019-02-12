import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution1215 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws NumberFormatException, IOException {
		for(int test_case=1;test_case<=10;test_case++) {
			int N=Integer.parseInt(br.readLine());
			StringBuilder sb=new StringBuilder();
			char [][]arr=new char[8][8];
			int ans=0;
			for(int i=0;i<8;i++) {
				String str=br.readLine();
				arr[i]=str.toCharArray();
			}
			for(int i=0;i<8;i++) {
				for(int k=0;k<=8-N;k++) {
					boolean flag=true;
					int temp=k;
					int end=temp+N-1;
					while(temp<=end) {
						if(arr[i][temp]!=arr[i][end]) {
							flag=false;
						}
						end--;
						temp++;
					}
					if(flag) {
						ans++;
					}
				}
			}
			for(int i=0;i<8;i++) {
				for(int k=0;k<=8-N;k++) {
					boolean flag=true;
					int temp=k;
					int end=temp+N-1;
					while(temp<=end) {
						if(arr[temp][i]!=arr[end][i]) {
							flag=false;
						}
						end--;
						temp++;
					}
					if(flag) {
						ans++;
					}
				}
			}
			sb.append("#").append(test_case).append(" ").append(ans).append("\n");
			bw.write(sb.toString());
		}
		bw.flush();
		bw.close();
	}
}
