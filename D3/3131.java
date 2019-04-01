package test;

public class Solution3131{
	public static void main(String[] args){
		boolean check[]=new boolean[1000001];
		for(int i=2;i*i<=1000000;i++) {
			for(int j=i*i;j<=1000000;j+=i) {
				check[j]=true;
			}
		}
		for(int i=2;i<=1000000;i++) {
			if(!check[i])
			System.out.print(i+" ");
		}
	}
}
