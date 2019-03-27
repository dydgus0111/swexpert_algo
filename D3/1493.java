import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
 
public class Solution{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        StringTokenizer token;
        int TC = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= TC; test_case++) {
            StringBuilder sb = new StringBuilder();
            token=new StringTokenizer(br.readLine());
            int p=Integer.parseInt(token.nextToken());
            int q=Integer.parseInt(token.nextToken());
            int row=0;
            int tmp=0;
            for(int i=1;i<=10000;i++) {
                tmp=((i)*(i+1))/2;
                if(p<tmp) {
                    row=i;
                    break;
                }
                else if(p==tmp) {
                    row=i;
                    break;
                }
            }
            int px=row;
            int py=1;
            while(tmp!=p) {
                tmp--;
                px--;
                py++;
            }
            for(int i=1;i<=10000;i++) {
                tmp=((i)*(i+1))/2;
                if(q<tmp) {
                    row=i;
                    break;
                }
                else if(q==tmp) {
                    row=i;
                    break;
                }
            }
            int qx=row;
            int qy=1;
            while(tmp!=q) {
                tmp--;
                qx--;
                qy++;
            }
            int x=px+qx;
            int y=py+qy;
            int cnt=0;
            while(y!=1) {
                x++;
                y--;
                cnt++;
            }
            int ans=(((x)*(x+1))/2)-cnt;
            sb.append("#").append(test_case).append(" ").append(ans).append("\n");
            bw.write(sb.toString());
        }
        bw.flush();
        bw.close();
    }
 
}