import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution6782_nomath{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		StringTokenizer token;
		long []pow =new long[1000001];
		for(long i=0;i<pow.length;i++) {
			pow[(int)i]=i*i;
		}
		int TC = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= TC; test_case++) {
			long num=Long.parseLong(br.readLine());
			int cnt=0;
			while(num!=2) {
				if(num!=2) {
					long temp=binarysearch(pow, num);
					cnt++;
					cnt+=((temp*temp)-num);
					num=temp;
				}
				else if(num==2)
					break;
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(test_case).append(" ").append(cnt).append("\n");
			bw.write(sb.toString());
		}

		bw.flush();
		bw.close();
	}
	static long binarysearch(long[] arr, long target) {
		 int first = 0;
         int last = arr.length-1;
         int mid = 0;
         while (first <= last) {
                 mid = (first + last) / 2;
                 if (target == arr[mid]) {
                         break;
                 }
                 else if(target<arr[mid])
                	 last=mid-1;
                 else
                	 first=mid+1;
         }
         long idx=(target==arr[mid])?mid:first;
         return idx;
	}

}