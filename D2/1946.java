import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
 
public class Solution1946{
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out)); 
    public static void main(String[] args) throws Exception{
        int T=Integer.parseInt(br.readLine());
        for(int test_case=1;test_case<=T;test_case++) {
        	String str=br.readLine();
        	StringTokenizer token=new StringTokenizer(str);
        	int num=Integer.parseInt(token.nextToken());
        	StringBuilder sb=new StringBuilder();
        	int idx=0;
        	bw.write("#"+test_case+"\n");
        	for(int i=0;i<num;i++) {
        		str=br.readLine();
        		token=new StringTokenizer(str);
        		String input=token.nextToken();
        		int count=Integer.parseInt(token.nextToken());
        		for(int j=0;j<count;j++) {
        			sb.append(input);
        			idx++;
        			if(idx==10) {
        				sb.append("\n");
        				bw.write(sb.toString());
        				idx=0;
        				sb.delete(0, sb.length());
        			}
        		}
        		
        	}
            bw.write(sb.toString()+"\n");
        }
        bw.flush();
        bw.close();
    }
}
