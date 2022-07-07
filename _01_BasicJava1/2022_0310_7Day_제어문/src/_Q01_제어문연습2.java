import java.util.Scanner;

public class _Q01_제어문연습2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int a, b, c;
		int min;
		
		System.out.print("세 개의 정수를 입력하세요. >> ");
		a = scanner.nextInt();
		b = scanner.nextInt();
		c = scanner.nextInt();
		
		min = (a > b)? a : b;
		min = (min > c)? c : min;
		
		System.out.printf("세 개의 정수 중에서 가장 작은 값 : %d",min);
		
		scanner.close();
	}

}
