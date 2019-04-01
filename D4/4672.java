import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution4672{
	//문자열 정렬 후 펠린드롬 개수 체크
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder str;
	static int ans;
	public static void main(String[] args) throws IOException {
		int TC = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= TC; test_case++) {
			ans=0;
			str=new StringBuilder(br.readLine());
			char input[]=new char[str.length()];
			for(int i=0;i<str.length();i++) {
				input[i]=str.charAt(i);
			}
			Arrays.sort(input);
			StringBuilder sortstr=new StringBuilder();
			for(int i=0;i<input.length;i++) {
				sortstr.append(input[i]);
			}
			
			int cnt=1;
			while(cnt<=sortstr.length()) {
				for(int i=0;i<sortstr.length();i++) {
					if(i+cnt<=sortstr.length()) {
						if(checkPelin(sortstr.substring(i, i+cnt))) {
							ans++;
						}
					}
				}
				cnt++;
			}
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(test_case).append(" ").append(ans).append("\n");
			bw.write(sb.toString());
		}

		bw.flush();
		bw.close();
	}
	static boolean checkPelin(String str) {
		boolean flag=true;
		if(str.length()==1) {
			return true;
		}
		else {
			int startidx=0;
			int endidx=str.length()-1;
			while(startidx<=endidx) {
				if(str.charAt(startidx)!=str.charAt(endidx)) {
					flag=false;
					break;
				}
				else {
					startidx++;
					endidx--;
				}
			}
		}
		if(flag) {
			return true;
		}
		else {
			return false;
		}
	}
}
