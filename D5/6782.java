import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
  
public class Solution6782{
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int tc=Integer.parseInt(bf.readLine());
        for(int t=1;t<=tc;t++) {
            StringBuilder sb=new StringBuilder();
             
            long ans=0;
            long num=Long.parseLong(bf.readLine());
            while(num!=2){
                double cnt=0;
                if(Math.sqrt(num)%1!=0) {
                    cnt=Math.sqrt(num)+1;
                    ans+=((long)cnt*(long)cnt)-num+1;
                    num=(long)cnt;
                }else {
                    num=(long)Math.sqrt(num);
                    ans++;
                }
            }
            sb.append("#").append(t).append(" ").append(ans).append("\n");
            bw.write(sb.toString());
        }
        bw.flush();
        bw.close();
    }
}
