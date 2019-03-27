import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;
 
public class Solution{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int[][] map;
    static int[]dx= {-1,1,0,0};
    static int[] dy= {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        StringTokenizer token;
        int TC = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= TC; test_case++) {
            token=new StringTokenizer(br.readLine());
            N=Integer.parseInt(token.nextToken());
            map=new int[N][N];
            maxidx=Integer.MAX_VALUE;
            max=Integer.MIN_VALUE;
            for(int i=0;i<N;i++) {
                token=new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++) {
                    map[i][j]=Integer.parseInt(token.nextToken());
                }
            }
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    dfs(new boolean[N][N], i,j,1,i,j);
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(test_case).append(" ").append(maxidx).append(" ").append(max).append("\n");
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
    static boolean isRange(int x, int y) {
        return x>=0&&x<N&&y>=0&&y<N;
    }
    static int max=Integer.MIN_VALUE;
    static int maxidx;
    static void dfs(boolean[][] check, int x, int y,int cnt,int cx,int cy) {
        check[x][y]=true;
        Point next=new Point(x, y);
        for(int i=0;i<4;i++) {
            int nx=next.x+dx[i];
            int ny=next.y+dy[i];
            if(isRange(nx, ny)) {
                if(!check[nx][ny]&&map[next.x][next.y]+1==map[nx][ny]) {
                    check[nx][ny]=true;
                    cnt++;
                    if(cnt>max) {
                        max=cnt;
                        maxidx=map[cx][cy];
                    }
                    else if(cnt==max) {
                        if(maxidx>map[cx][cy]) {
                            maxidx=map[cx][cy];
                        }
                    }
                    dfs(check, nx, ny, cnt,cx,cy);
                }
            }
        }
    }
}