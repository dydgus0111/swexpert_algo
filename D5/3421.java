import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;
 
public class Solution{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] arr;
    static List<Pair> list;
    static HashSet<String> hs;
    static int N;
    public static void main(String[] args) throws IOException {
        StringTokenizer token;
        int TC = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= TC; test_case++) {
            token=new StringTokenizer(br.readLine());
            N=Integer.parseInt(token.nextToken());
            int M=Integer.parseInt(token.nextToken());
            arr=new int[N+1];
            numlist=new ArrayList<>();
            list=new ArrayList<>();
            hs=new HashSet<>();
            ans=0;
            for(int i=1;i<=N;i++) {
                arr[i]=i;
            }
            for(int i=0;i<M;i++) {
                token=new StringTokenizer(br.readLine());
                int a=Integer.parseInt(token.nextToken());
                int b=Integer.parseInt(token.nextToken());
                if(b<a) {
                    int tmp=a;
                    a=b;
                    b=tmp;
                }
                StringBuilder sb=new StringBuilder();
                sb.append(a).append(" ").append(b);
                if(hs.contains(sb.toString()))
                    continue;
                else {
                    hs.add(sb.toString());
                    list.add(new Pair(a, b));
                }
            }
            powerSet(new boolean[N], 0);
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(test_case).append(" ").append(ans).append("\n");
            bw.write(sb.toString());
        }
        bw.flush();
        bw.close();
    }
    static int[] a;
    static List<int[]> numlist;   //나올 수 있는 powerset을 모두 가지고 있는 리스트
    static int ans;
    static void powerSet(boolean[] sel, int n) {
        for(int i=0;i<list.size();i++) {
            int cnt=0;
            for(int j=0;j<sel.length;j++) {
                if(sel[j]==true) {
                    if(arr[j+1]==list.get(i).a) {
                        cnt++;
                    }
                    if(arr[j+1]==list.get(i).b) {
                        cnt++;
                    }
                }
            }
            if(cnt==2)
                return;
        }
        if(n==sel.length) {
            ans++;
            return;
        }
        sel[n]=true;
        powerSet(sel, n+1);
        sel[n]=false;
        powerSet(sel, n+1);
    }
    static class Pair{
        int a;
        int b;
        public Pair(int a, int b) {
            this.a=a;
            this.b=b;
        }
    }
}