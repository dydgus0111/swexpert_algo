import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
	public static void main(String[] args) throws IOException {
		StringTokenizer token;
		int TC = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= TC; test_case++) {
			StringBuilder sb = new StringBuilder();
			StringBuilder sb1=new StringBuilder();
			String str=br.readLine();
			token=new StringTokenizer(str);
			String input=token.nextToken();
			int num=Integer.parseInt(token.nextToken());
			List<Integer> list=new ArrayList<>();
			int []arr=new int[input.length()];
			int []check=new int[10];
			for(int i=0;i<input.length();i++) {
				int temp=input.charAt(i)-'0';
				list.add(temp);
				arr[i]=temp;
				check[temp]+=1;
			}
						
			boolean flag=false;
			for(int i=0;i<check.length;i++) {	//같은 숫자가 2개 이상인 숫자가 있는지 확인
				if(check[i]>=2) { 
					flag=true;
				}
			}
			if(flag&&num>=arr.length/2) {	//같은 숫자가 2개 이상이라면 Max값을 만들고 그 값을 출력해주면 됨.
				Collections.sort(list);
				for(int i=list.size()-1;i>=0;i--) {
					sb1.append(list.get(i));
				}
			}
			else{
					int maxv=findmax(arr);
					for(int i=0;i<arr.length;i++) {
						if(maxv>arr[i]) {
							int temp=arr[i];
							
						}
					}
				if(num%2!=0) {
					int temp=arr[arr.length-1];
					arr[arr.length-1]=arr[arr.length-2];
					arr[arr.length-2]=temp;
				}
				for(int i=0;i<arr.length;i++) {
					sb1.append(arr[i]);
				}
			}
			sb.append("#").append(test_case).append(" ").append(sb1.toString()).append("\n");
			bw.write(sb.toString());
		}
		bw.flush();
		bw.close();
	}
	static int findmax(int[] arr) {
		int max=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>max) {
				max=arr[i];
			}
		}
		return max;
	}
}