import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
 
public class Solution{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] dx= {-1,1,0,0,-1,-1,1,1};//상,하,좌,우, 왼위, 오위, 왼아래, 오아래
    static int[] dy= {0,0,-1,1,-1,1,-1,1};
    static char[][] map;
    static int N;
    static int [][] check;
    static int ans;
    public static void main(String[] args) throws IOException {
        StringTokenizer token;
        int TC = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= TC; test_case++) {
            N=Integer.parseInt(br.readLine());
            map=new char[N][N];
            check=new int[N][N];
            for(int i=0;i<N;i++) {
                String str=br.readLine();
                for(int j=0;j<N;j++) {
                    map[i][j]=str.charAt(j);
                }
            }
            ans=0;
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++){
                    if(map[i][j]=='.'&&check[i][j]==0&&isMine(i, j)==0) {
                        bfs(i, j);
                        ans++;
                    }
                }
            }
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++){
                    if(check[i][j]==0&&map[i][j]=='.')
                        ans++;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(test_case).append(" ").append(ans).append("\n");
            bw.write(sb.toString());
        }
 
        bw.flush();
        bw.close();
    }
    static void bfs(int x, int y) {
        Queue<Pair> queue=new LinkedList<>();
        queue.add(new Pair(x, y));
        check[x][y]=-1;
        while(!queue.isEmpty()) {
            Pair next=queue.poll();
            if(isMine(next.x, next.y)==0) {
                for(int i=0;i<8;i++) {
                    int nx=next.x+dx[i];
                    int ny=next.y+dy[i];
                    if(isRange(nx, ny)&&check[nx][ny]==0) {
                        if(map[nx][ny]=='*') continue;
                        if(map[nx][ny]=='.') {
                            queue.add(new Pair(nx, ny));
                            check[nx][ny]=-1;
                        }
                    }
                }
            }
        }
    }
    static class Pair{
        int x;
        int y;
        public Pair(int x, int y) {
            this.x=x;
            this.y=y;
        }
    }
    static boolean isRange(int x, int y) {
        if(x>=0&&x<N&&y>=0&&y<N)
            return true;
        else
            return false;
    }
    static int isMine(int x, int y) {
        int cnt=0;
        for(int i=0;i<8;i++) {
            int nx=x+dx[i];
            int ny=y+dy[i];
            if(isRange(nx, ny)) {
                if(map[nx][ny]=='*') {
                    cnt++;
                    check[nx][ny]=-2;
                }
            }
        }
        return cnt;
    }
}
