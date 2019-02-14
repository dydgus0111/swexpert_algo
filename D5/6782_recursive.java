import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution6782_nomath {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		long[] pow = new long[1000001];
		for (long i = 0; i < pow.length; i++) {
			pow[(int) i] = i * i;
		}
		int TC = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= TC; test_case++) {
			long num = Long.parseLong(br.readLine());
			int cnt = 0;
			while (num != 2) {
				if (num != 2) {
					long temp = binarysearch(pow, num, 0, pow.length - 1);
					cnt++;
					cnt += ((temp * temp) - num);
					num = temp;
				} else if (num == 2)
					break;
			}

			StringBuilder sb = new StringBuilder();
			sb.append("#").append(test_case).append(" ").append(cnt).append("\n");
			bw.write(sb.toString());
		}

		bw.flush();
		bw.close();
	}

	static long binarysearch(long[] arr, long target, int first, int last) {
		int mid = 0;
		mid = (first + last) / 2;
		if (arr[mid-1]<target&&arr[mid]>=target)
			return mid;
		else if (target < arr[mid])
			return binarysearch(arr, target, first, mid - 1);
		else
			return binarysearch(arr, target, mid + 1, last);
	}
	

}