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
    static long[] tk;
    static long M;
    static long ans;
    public static void main(String[] args) throws IOException {
        StringTokenizer token;
        int TC = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= TC; test_case++) {
            token=new StringTokenizer(br.readLine());
            long N=Long.parseLong(token.nextToken());
            M=Long.parseLong(token.nextToken());
            tk=new long[(int)N];
            for(int i=0;i<N;i++) {
                tk[i]=Long.parseLong(br.readLine());
            }
            Arrays.sort(tk);
            long end=tk[tk.length-1]*M;
            bSearch(0, end);
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(test_case).append(" ").append(ans).append("\n");
            bw.write(sb.toString());
        }
        bw.flush();
        bw.close();
    }
    static void bSearch(long start, long end) {
        long mid=(start+end)/2;
        boolean flag=true;  //처리 가능하면 true, 아니면 false
        long cnt=0;
        for(int i=0;i<tk.length;i++) {
            cnt+=mid/tk[i];
            if(cnt>=M) {
                flag=true;
                break;
            }
        }
        if(cnt<M) {
            flag=false;
        }
        if(Math.abs(start-end)==1||Math.abs(start-end)==0) {
            ans=end;
            return;
        }
        else {
            if(flag) {
                end=mid;
                bSearch(start, end);
            }
            else {
                start=mid;
                bSearch(start, end);
            }
        }
    }
}