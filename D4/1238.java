import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Solution{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int start;
    static int [] check;
    static List<Point> list;
    public static void main(String[] args) throws IOException {
        StringTokenizer token;
//      int TC = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= 10; test_case++) {
            token=new StringTokenizer(br.readLine());
            N=Integer.parseInt(token.nextToken());
            start=Integer.parseInt(token.nextToken());
            list=new ArrayList<>();
            check=new int[101];
            token=new StringTokenizer(br.readLine());
            for(int i=0;i<N/2;i++) {
                int x=Integer.parseInt(token.nextToken());
                int y=Integer.parseInt(token.nextToken());
//              map[x][y]=1;
                //x->y
                list.add(new Point(x, y));
            }
            bfs(start, 1);
            int ans=0;
            int max=Integer.MIN_VALUE;
            int maxidx=0;
            for(int i=0;i<check.length;i++) {
                if(check[i]!=0) {
                    if(max<=check[i]) {
                        max=check[i];
                        if(maxidx<i)
                            maxidx=i;
                    }
                }
            }
            ans=maxidx;
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(test_case).append(" ").append(ans).append("\n");
            bw.write(sb.toString());
        }
 
        bw.flush();
        bw.close();
    }
    static class Point{
        int x;
        int y;
        public Point(int x, int y) {
            this.x=x;
            this.y=y;
        }
    }
    static void bfs(int x, int cnt) {
        Queue<Integer> queue=new LinkedList<>();
        queue.add(x);
        check[x]=cnt;
        while(!queue.isEmpty()) {
            int next=queue.poll();
            for(int i=0;i<list.size();i++) {
                if(list.get(i).x==next) {
                    if(check[list.get(i).y]==0) {
                        check[list.get(i).y]=check[next]+1;
                        queue.add(list.get(i).y);
                    }
                }
            }
        }
    }
}