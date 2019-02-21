package d4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Solution1251{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		//1.N(combination)2 의 경우의수를 모두 구한뒤, 각 경우의수의 E*L^2 값을 가중치로 저장.
		//2.가중치를 이용하여 최소신장트리값 계산
		StringTokenizer token;
		int TC = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= TC; test_case++) {
			int N=Integer.parseInt(br.readLine());
			int []x=new int[N];
			int []y=new int[N];
			int []arr=new int[N];
			parents=new int[N];
			for(int i=0;i<N;i++) {
				parents[i]=i;
			}
			rank=new int[N];
			double ans=0;
			list=new ArrayList<Pair>();
			for(int i=0;i<N;i++) {
				arr[i]=i;
			}
			int []sel=new int[2];
			token=new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				x[i]=Integer.parseInt(token.nextToken());
			}
			token=new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				y[i]=Integer.parseInt(token.nextToken());
			}
			E=Double.parseDouble(br.readLine());
			//조합
			combi(arr, sel, 0, 0);
			for(int i=0;i<list.size();i++) {
				list.get(i).weight=calcL(x[list.get(i).x], x[list.get(i).y], y[list.get(i).x],y[list.get(i).y]);
				
			}
			//kruskal을 위해 weight를 기준으로 오름차순 정렬
			Collections.sort(list,new Comparator<Pair>() {

				@Override
				public int compare(Pair o1, Pair o2) {
					if(o1.weight>o2.weight)
						return 1;
					else if(o1.weight==o2.weight)
						return 1;
					else
						return -1;
				}
				
			});
			//kruskal을 이용해서 최소신장트리 계산
			int select=0;
			for(int i=0;i<list.size();i++) {
	        	if(findSet(list.get(i).x)==findSet(list.get(i).y))
	        		continue;
	        	if(list.get(i).x!=list.get(i).y) {
	        		union(list.get(i).x,list.get(i).y);
	        		ans+=list.get(i).weight;
	        		select++;
	        	}
	        	if(select==N-1)
	        		break;
	        }

			StringBuilder sb = new StringBuilder();
			sb.append("#").append(test_case).append(" ").append(Math.round(ans)).append("\n");
			bw.write(sb.toString());
		}

		bw.flush();
		bw.close();
	}
	static List<Pair> list;
	static double E;
	static class Pair{
		int x;
		int y;
		double weight;
		public Pair(int x, int y, double weight) {
			this.x=x;
			this.y=y;
			this.weight=weight;
		}
		public String toString() {
			return x+":"+y+":"+weight;
		}
	}
	static double calcL(int x1,int x2, int y1, int y2) {
		double L=Math.sqrt(Math.pow(Math.abs(x1-x2), 2)+Math.pow(Math.abs(y1-y2), 2));
		return E*Math.pow(L, 2);
	}
	static void combi(int[] arr,int[] sel, int n, int r) {
		if(sel.length==r) {
			int start=sel[0];
			int end=sel[1];
			list.add(new Pair(start, end, 0));//N개의 섬을 2개씩 연결하는 모든 경우의수를 리스트에 저장
			return;
		}
		if(arr.length==n)
			return;
		sel[r]=arr[n];
		combi(arr, sel, n+1, r+1);
		combi(arr, sel, n+1, r);
	}
	static int[] parents;
    static int[] rank;
    static void makeSet(int x) {
        parents[x] = x;
    }
    static int findSet(int x) {
        if( parents[x] == x )
            return x;
         
        parents[x] = findSet(parents[x]);
        return parents[x];
    }
    static void union(int x, int y) {
        int px = findSet(x);
        int py = findSet(y);
         
        if( rank[px] > rank[py] ) {
            parents[py] = px;
        }
        else {
            parents[px] = py;
            if( rank[px] == rank[py] )
                rank[py]++;
        }
    }

}
