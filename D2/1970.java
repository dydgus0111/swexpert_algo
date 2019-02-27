import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
 
public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int [][]pas=new int[10][11];
     
    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine().trim());
         
        for (int test_case = 1; test_case <= T; test_case++) {
            int []arr=new int[8];//50000,10000,50000,1000,500,100,50,10
            String str=br.readLine();
            StringTokenizer token=new StringTokenizer(str);
            int num=Integer.parseInt(token.nextToken());
            StringBuilder sb=new StringBuilder();
            StringBuilder ans=new StringBuilder();
            if(num>=50000) {
                arr[0]=num/50000;
                num%=50000;
            }if(num>=10000) {
                arr[1]=num/10000;
                num%=10000;
            }if(num>=5000) {
                arr[2]=num/5000;
                num%=5000;
            }if(num>=1000) {
                arr[3]=num/1000;
                num%=1000;
            }if(num>=500) {
                arr[4]=num/500;
                num%=500;
            }if(num>=100) {
                arr[5]=num/100;
                num%=100;
            }if(num>=50) {
                arr[6]=num/50;
                num%=50;
            }if(num>=10) {
                arr[7]=num/10;
                num%=10;
            }
            for(int i=0;i<arr.length;i++) {
                ans.append(arr[i]).append(" ");
            }
            sb.append("#").append(test_case).append("\n").append(ans).append("\n");
            bw.write(sb.toString());
        }
        bw.flush();
        bw.close();
    }
}