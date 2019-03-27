import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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
            int[] arr=new int[N];
            token=new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++) {
                arr[i]=Integer.parseInt(token.nextToken());
            }
            int[] lis=new int[N];
            for(int i=0;i<arr.length;i++) {
                lis[i]=1;
                for(int j=0;j<i;j++) {
                    if(arr[j]<arr[i]&&1+lis[j]>lis[i])
                        lis[i]=lis[j]+1;
                }
            }
            int ans=Integer.MIN_VALUE;
            for(int i=0;i<lis.length;i++) {
                if(lis[i]>ans)
                    ans=lis[i];
            }
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(test_case).append(" ").append(ans).append("\n");
            bw.write(sb.toString());
        }
 
        bw.flush();
        bw.close();
    }
 
}