
public class _Q13_제어문연습14 {

	public static void main(String[] args) {
		double n = 1.0;
		int i = 1;
		double result = 0;
		
		while(i < 10) {
			if(i == 1) {
				System.out.printf("%.1f",n);
				result += n;
			}else {
				System.out.printf(" + %.1f/%d",n,i);
				result += n/i;
			}
			i += 2;
		}
		System.out.print(" = "+result);
		
		//삼항연산자 사용할 경우, 위처럼 if문 쓰지 않고 delim 구분가능
	}

}
