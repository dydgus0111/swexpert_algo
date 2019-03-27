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
            boolean []d=new boolean[10001];
            token=new StringTokenizer(br.readLine());
            int N=Integer.parseInt(token.nextToken());
            int []num=new int[N];
            token=new StringTokenizer(br.readLine());
            int sum=0;
            for(int i=0;i<N;i++) {
                num[i]=Integer.parseInt(token.nextToken());
                sum+=num[i];
            }
            d[0]=true;
            for(int i=0;i<N;i++) {
                for(int j=sum;j>=0;j--) {
                    if(d[j]) {
                        d[j+num[i]]=true;
                    }
                }
            }
            int ans=0;
            for(int i=0;i<10001;i++) {
                if(d[i])
                    ans++;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(test_case).append(" ").append(ans).append("\n");
            bw.write(sb.toString());
        }
 
        bw.flush();
        bw.close();
    }
 
}