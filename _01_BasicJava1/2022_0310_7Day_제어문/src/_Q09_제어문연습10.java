
public class _Q09_제어문연습10 {

	public static void main(String[] args) {
		
		int result = 1;
		
		for(int i = 2; i <= 10; i+=2) {
			result = result * i; 
		}
		System.out.printf("1부터 10까지의 짝수의 곱 : %d",result);
	}

}
