import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution{
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testcase=Integer.parseInt(br.readLine().trim());
		for(int t=1;t<=testcase;t++) {
			int num=Integer.parseInt(br.readLine().trim());
			StringBuilder sb=new StringBuilder();
			int cnt11=0;
			int cnt7=0;
			int cnt5=0;
			int cnt3=0;
			int cnt2=0;
			while(num%11==0) {
				num/=11;
				cnt11++;
			}
			while(num%7==0) {
				num/=7;
				cnt7++;
			}
			while(num%5==0) {
				num/=5;
				cnt5++;
			}
			while(num%3==0) {
				num/=3;
				cnt3++;
			}
			while(num%2==0) {
				num/=2;
				cnt2++;
			}
			sb.append("#").append(t).append(" ").append(cnt2).append(" ").append(cnt3).append(" ").append(cnt5).append(" ").append(cnt7).append(" ").append(cnt11);
			System.out.println(sb.toString());
		}
	}
}
