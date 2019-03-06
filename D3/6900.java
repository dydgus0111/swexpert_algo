import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		StringTokenizer token;
		int TC = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= TC; test_case++) {
			token=new StringTokenizer(br.readLine());
			int N=Integer.parseInt(token.nextToken());
			int M=Integer.parseInt(token.nextToken());
			List<Input> list=new ArrayList<Input>();
			for(int i=0;i<N;i++) {
				token=new StringTokenizer(br.readLine());
				list.add(new Input(token.nextToken(), Integer.parseInt(token.nextToken())));
			}
			int sum=0;
			for(int i=0;i<M;i++) {
				String str=br.readLine();
				for(int j=0;j<list.size();j++) {//비교값으로 입력받은 list에서 뽑아주기
					boolean flag=true;
					for(int k=0;k<8;k++) {
						if(list.get(j).str.charAt(k)=='*')
							continue;
						if(list.get(j).str.charAt(k)!=str.charAt(k)) {
							flag=false;
							break;
						}
					}
					if(flag)
						sum+=list.get(j).money;
				}
			}
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(test_case).append(" ").append(sum).append("\n");
			bw.write(sb.toString());
		}

		bw.flush();
		bw.close();
	}
	static class Input{
		String str;
		int money;
		public Input(String str, int money) {
			this.str=str;
			this.money=money;
		}
	}
}
