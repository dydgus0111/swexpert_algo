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
            int N=Integer.parseInt(token.nextToken());
            List<Bus> list=new ArrayList<Bus>();
            for(int i=0;i<N;i++) {
                token=new StringTokenizer(br.readLine());
                int min=Integer.parseInt(token.nextToken());
                int max=Integer.parseInt(token.nextToken());
                list.add(new Bus(min, max));
            }
            token=new StringTokenizer(br.readLine());
            int P=Integer.parseInt(token.nextToken());
            int[] arr=new int[P];
            for(int i=0;i<P;i++) {
                token=new StringTokenizer(br.readLine());
                int num=Integer.parseInt(token.nextToken());
                for(int j=0;j<list.size();j++) {
                    if(num>=list.get(j).min&&num<=list.get(j).max) {
                        arr[i]+=1;
                    }
                }
            }
            StringBuilder ans=new StringBuilder();
            for(int i=0;i<arr.length;i++) {
                ans.append(arr[i]+ " ");
            }
            sb.append("#").append(test_case).append(" ").append(ans).append("\n");
            bw.write(sb.toString());
        }
        bw.flush();
        bw.close();
    }
    static class Bus{
        int min;
        int max;
        public Bus(int min, int max) {
            this.min=min;
            this.max=max;
        }
    }
}