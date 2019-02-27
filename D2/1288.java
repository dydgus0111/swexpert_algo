import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
 
public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 
    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            StringBuilder sb=new StringBuilder();
            int num = Integer.parseInt(br.readLine());
            boolean[] check = new boolean[10];
            boolean flag = true;
            int cnt=1;
            int ncnt=0;
            int ans=0;
            while (ncnt!=10) {
                ncnt=0;
                int tnum=num;
                tnum*=cnt;
                ans=tnum;
                while (tnum > 0) {
                    if (check[tnum % 10] == false)
                        check[tnum % 10] = true;
                    tnum /= 10;
                }
                cnt++;
                for (int i = 0; i < check.length; i++) {
                    if (check[i] == true) {
                        ncnt++;
                    }
                }
            }
            sb.append("#").append(test_case).append(" ").append(ans).append("\n");
            bw.write(sb.toString());
        }
        bw.flush();
        bw.close();
    }
}