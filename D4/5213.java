import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
 
public class Solution{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static long arr[]=new long[1000001];
    public static void main(String[] args) throws IOException {
        StringTokenizer token;
        int TC = Integer.parseInt(br.readLine());
        for (int i = 1; i <= 1000000; i += 2) {
            for (int j = 1; j <= 1000000/i ; j++) {
                arr[i*j] += i;
            }
        }
        for (int i = 1; i <= 1000000; i++) {
            arr[i] += arr[i - 1];
        }
        for (int test_case = 1; test_case <= TC; test_case++) {
            StringBuilder sb = new StringBuilder();
            token=new StringTokenizer(br.readLine());
            int L=Integer.parseInt(token.nextToken());
            int R=Integer.parseInt(token.nextToken());
            long ans=0;
            ans=arr[R]-arr[L-1];
            sb.append("#").append(test_case).append(" ").append(ans).append("\n");
            bw.write(sb.toString());
        }
        bw.flush();
        bw.close();
    }
}
