import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Solution{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static double map[][];
    static int N;
    static int arr[];
    static double ans;
    public static void main(String[] args) throws IOException {
        StringTokenizer token;
        int TC = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= TC; test_case++) {
            N=Integer.parseInt(br.readLine());
            map=new double[N][N];
            arr=new int[N];
            ans=Double.MIN_VALUE;
            for(int i=0;i<N;i++)
                arr[i]=i;
            for(int i=0;i<N;i++) {
                token=new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++) {
                    map[i][j]=Double.parseDouble(token.nextToken())/100;
                }
            }
            dfs(new int[N], new boolean[N], 0,1);
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(test_case).append(" ").append(String.format("%.6f", ans*100)).append("\n");
            bw.write(sb.toString());
        }
         
        bw.flush();
        bw.close();
    }
    static void dfs(int[] sel, boolean[] check,int cnt,double per) {
        if(cnt==N) {
            if(per>ans)
                ans=per;
            return;
        }
        if(per<=ans)
            return;
        for(int i=0;i<check.length;i++) {
            if(!check[i]) {
                check[i]=true;
                sel[i]=cnt;
                dfs(sel, check, cnt+1,per*map[i][sel[i]]);
                check[i]=false;
            }
        }
    }
}