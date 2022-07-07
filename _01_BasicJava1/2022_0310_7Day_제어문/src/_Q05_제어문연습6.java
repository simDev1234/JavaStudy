
public class _Q05_제어문연습6 {

	public static void main(String[] args) {

		double down_price = 0;
		
		System.out.println("정상가격	세일가격");
		System.out.println("-----------------------");
		
		for(int i = 10000; i <= 20000; i+=1000) {
			down_price = 0.7*i;
			System.out.printf("%d	    %10.1f\n",i,down_price);
		}
	}

}
