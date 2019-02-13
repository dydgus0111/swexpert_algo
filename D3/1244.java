package d3;

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
			int []check=new int[10];
			for(int i=0;i<input.length();i++) {
				int temp=input.charAt(i)-'0';
				list.add(temp);
				check[temp]+=1;
			}
						
			boolean flag=false;
			for(int i=0;i<check.length;i++) {	//같은 숫자가 2개 이상인 숫자가 있는지 확인
				if(check[i]>=2) { 
					flag=true;
				}
			}
			if(flag&&num>=list.size()/2) {	//같은 숫자가 2개 이상이라면 Max값을 만들고 그 값을 출력해주면 됨.
				Collections.sort(list);
				for(int i=list.size()-1;i>=0;i--) {
					sb1.append(list.get(i));
				}
			}
			else{
				int cnt=0;
				while(cnt!=num) {
					//최대값 찾기
					int max=0;
					int maxidx=0;
					for(int i=cnt;i<list.size();i++) {
						if(list.get(i)>=max) {
							max=list.get(i);
							maxidx=i;
						}
					}
					//최대값보다 작은 값이 최대값이 있는 인덱스 보다 작은 인덱스에 들어있다면 두 수의 위치 변경
					for(int i=cnt;i<list.size();i++) {
						if(maxidx>i&&max>list.get(i)) {
							Collections.swap(list, maxidx, i);
							break;
						}
					}
					cnt++;
					if(cnt==list.size()-1)
						break;
				}
				num-=cnt;
				if(num%2!=0&&num>0) {
					Collections.swap(list, list.size()-1, list.size()-2);
				}
				for(int i=0;i<list.size();i++) {
					sb1.append(list.get(i));
				}
			}
			sb.append("#").append(test_case).append(" ").append(sb1.toString()).append("\n");
			bw.write(sb.toString());
		}
		bw.flush();
		bw.close();
	}
}