package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
 
public class Solution1284{
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out)); 
    public static void main(String[] args) throws Exception{
        int T=Integer.parseInt(br.readLine());
        for(int test_case=1;test_case<=T;test_case++) {
        	String str=br.readLine();
        	StringTokenizer token=new StringTokenizer(str);
        	StringBuilder sb=new StringBuilder();
        	int ans=0;
        	int p=Integer.parseInt(token.nextToken());
        	int q=Integer.parseInt(token.nextToken());
        	int r=Integer.parseInt(token.nextToken());
        	int s=Integer.parseInt(token.nextToken());
        	int w=Integer.parseInt(token.nextToken());
        	
        	int sum1=p*w;
        	int sum2=0;
        	if(w<=r)
        		sum2=q;
        	else
        		sum2=q+(w-r)*s;
        	if(sum1>sum2)
        		ans=sum2;
        	else
        		ans=sum1;
            sb.append("#").append(test_case).append(" ").append(ans).append("\n");
            bw.write(sb.toString());
        }
        bw.flush();
        bw.close();
    }
}