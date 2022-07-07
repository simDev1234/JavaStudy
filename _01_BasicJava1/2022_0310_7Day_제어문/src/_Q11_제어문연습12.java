import java.util.Scanner;

public class _Q11_제어문연습12 {

	public static void main(String[] args) {
		double r = 1.0;
		int n = 0;
		double result = 1.0;
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("실수를 입력하세요 : ");
		r = scanner.nextDouble();
		System.out.print("정수를 입력하세요 : ");
		n = scanner.nextInt();
		
		for(int i = 0; i < n; i++) {
			result = result * r;
		}
		System.out.printf("%.1f",result);
		
		scanner.close();
	}

}
