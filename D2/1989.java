package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
 
public class Solution1989{
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out)); 
    public static void main(String[] args) throws Exception{
        int T=Integer.parseInt(br.readLine());
        for(int test_case=1;test_case<=T;test_case++) {
            String str=br.readLine().trim();
            StringBuilder sb=new StringBuilder();
            StringBuilder sb1=new StringBuilder();
            int ans=0;
            for(int i=str.length()-1;i>=0;i--) {
                sb1.append(str.charAt(i));
            }
            if(str.equals(sb1.toString()))
                ans=1;
            sb.append("#").append(test_case).append(" ").append(ans).append("\n");
            bw.write(sb.toString());
        }
        bw.flush();
        bw.close();
    }
}