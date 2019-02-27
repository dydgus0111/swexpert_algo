package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
 
public class Solution1984{
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out)); 
    public static void main(String[] args) throws Exception{
        int T=Integer.parseInt(br.readLine().trim());
        for(int test_case=1;test_case<=T;test_case++) {
        	String str=br.readLine().trim();
        	StringTokenizer token=new StringTokenizer(str);
        	StringBuilder sb=new StringBuilder();
        	List<Integer> list=new ArrayList<Integer>();
        	while(token.hasMoreTokens()) {
        		list.add(Integer.parseInt(token.nextToken()));
        	}
        	Collections.sort(list);
        	int sum=0;
        	for(int i=1;i<list.size()-1;i++) {
        		sum+=list.get(i);
        	}
        	double ave=(double)sum/8;
        	
        	double ans=Math.round(ave);
            sb.append("#").append(test_case).append(" ").append((int)ans).append("\n");
            bw.write(sb.toString());
        }
        bw.flush();
        bw.close();
    }
}