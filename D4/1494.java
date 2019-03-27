import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;
 
public class Solution{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static Pair[] arr;
    public static void main(String[] args) throws IOException {
        StringTokenizer token;
        int TC = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= TC; test_case++) {
            token=new StringTokenizer(br.readLine());
            N=Integer.parseInt(token.nextToken());
            arr=new Pair[N];
            min=Long.MAX_VALUE;
            for(int i=0;i<N;i++) {
                token=new StringTokenizer(br.readLine());
                int x=Integer.parseInt(token.nextToken());
                int y=Integer.parseInt(token.nextToken());
                arr[i]=new Pair(x, y);
            }
            recur(new boolean[21], 0, 0);
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(test_case).append(" ").append(min).append("\n");
            bw.write(sb.toString());
        }
        bw.flush();
        bw.close();
    }
    static class Pair{
        int x;
        int y;
        public Pair(int x, int y) {
            this.x=x;
            this.y=y;
        }
    }
    static long min;
    static void calc(boolean[] check) {
        long x=0;
        long y=0;
        List<Pair> sel=new ArrayList<>();
        List<Pair> nsel=new ArrayList<>();
        for(int i=0;i<N;i++) {
            if(check[i]==true) {
                sel.add(arr[i]);
            }else
                nsel.add(arr[i]);
        }
        for(int i=0;i<sel.size();i++) {
            x+=sel.get(i).x-nsel.get(i).x;
            y+=sel.get(i).y-nsel.get(i).y;
        }
        long v=x*x+y*y;
        if(min>v)
            min=v;
    }
    static void recur(boolean[] check, int n, int r) {
        if(n==N/2) {
            calc(check);
            return;
        }
        for(int i=r;i<N;i++) {
            if(check[i]==false) {
                check[i]=true;
                recur(check, n+1, i+1);
                check[i]=false;
            }
        }
    }
}