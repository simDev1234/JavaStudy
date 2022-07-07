package myutil;

public class AdvanceCalc extends BaseCalc{
	public int hap(int n) {
		int sum = 0;
		for(int i = 1; i <= n; i++) {
			//sum += i;
			//조상의 기능을 사용
			sum = super.plus(sum, i);
		}
		return sum;
	}//end hap()
	
	public int pow(int n, int m) {
		int res = 1;
		for(int i = 0; i < m; i++) {
			//res = res * n;
			res = super.multiply(res,n);
		}
		return res; 
	}//end pow()
}
