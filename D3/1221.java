import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution1221{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		StringTokenizer token;
		int TC=Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= TC; test_case++) {
			token=new StringTokenizer(br.readLine());
			token.nextToken();
			int N=Integer.parseInt(token.nextToken());
//			String arr[]=new String[N];
			int arr[]=new int[N];
			token=new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				String str=token.nextToken();
				if(str.equals("ZRO"))
					arr[i]=0;
				else if(str.equals("ONE"))
					arr[i]=1;
				else if(str.equals("TWO"))
					arr[i]=2;
				else if(str.equals("THR"))
					arr[i]=3;
				else if(str.equals("FOR"))
					arr[i]=4;
				else if(str.equals("FIV"))
					arr[i]=5;
				else if(str.equals("SIX"))
					arr[i]=6;
				else if(str.equals("SVN"))
					arr[i]=7;
				else if(str.equals("EGT"))
					arr[i]=8;
				else
					arr[i]=9;
				
			}
			Arrays.sort(arr);
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(test_case).append(" ").append("\n");
			System.out.println(sb.toString());
			for(int i=0;i<arr.length;i++) {
				if(arr[i]==0)
					System.out.print("ZRO ");
				else if(arr[i]==1)
					System.out.print("ONE ");
				else if(arr[i]==2)
					System.out.print("TWO ");
				else if(arr[i]==3)
					System.out.print("THR ");
				else if(arr[i]==4)
					System.out.print("FOR ");
				else if(arr[i]==5)
					System.out.print("FIV ");
				else if(arr[i]==6)
					System.out.print("SIX ");
				else if(arr[i]==7)
					System.out.print("SVN ");
				else if(arr[i]==8)
					System.out.print("EGT ");
				else if(arr[i]==9)
					System.out.print("NIN ");
			}
		}

		bw.flush();
		bw.close();
	}

}