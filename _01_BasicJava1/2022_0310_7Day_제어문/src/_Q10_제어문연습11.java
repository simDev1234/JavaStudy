
public class _Q10_제어문연습11 {

	public static void main(String[] args) {
		double pi = 0;
		int sign = 1;
		
		for(int i = 0; i < 2000000000; i++) {
			pi += sign*(4.0/(i*2+1));
			sign = -sign;
		}
		
		System.out.printf("%.16f",pi);
	}

}
