import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution1244{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static void swap(int[] arr, int a, int b) {
		int temp=arr[a];
		arr[a]=arr[b];
		arr[b]=temp;
	}
	static int []ans;
	static void shuffle(int[] arr, int cnt,int N,int []max) {
		if(cnt==N) {
			for(int i=0;i<max.length;i++) {
				if(max[i]==arr[i]) {
					continue;
				}else if(max[i]<arr[i]) {
					for(int j=0;j<max.length;j++) {
						max[j]=arr[j];
					}
					break;
				}else if(max[i]>arr[i])
					break;
			}
			for(int i=0;i<max.length;i++) {
				ans[i]=max[i];
			}
			return;
		}
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				swap(arr,i,j);
				shuffle(arr, cnt+1, N,max);
				swap(arr,i,j);
			}
		}
	}
	public static void main(String[] args) throws IOException {
		StringTokenizer token;
		int TC = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= TC; test_case++) {
			String str=br.readLine();
			token=new StringTokenizer(str);
			String input=token.nextToken();
			int num=Integer.parseInt(token.nextToken());
			int []arr=new int[input.length()];
			for(int i=0;i<input.length();i++) {
				arr[i]=input.charAt(i)-'0';
			}
			int []max=new int[input.length()];
			ans=new int[input.length()];
			shuffle(arr, 0, num, max);
			StringBuilder sb = new StringBuilder();
			StringBuilder sb1=new StringBuilder();
			for(int i=0;i<ans.length;i++) {
				sb1.append(ans[i]);
			}
			sb.append("#").append(test_case).append(" ").append(sb1.toString()).append("\n");
			bw.write(sb.toString());
		}

		bw.flush();
		bw.close();
	}

}
