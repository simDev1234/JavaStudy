import java.util.*;

public class _Q07_제어문연습8 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n, sum = 0; //main함수 입장에서 요건 전역변수
		
		System.out.print("n(양수) : ");
		n = scanner.nextInt();
		
		System.out.println("n      1부터 n까지의 합");
		System.out.println("-----------------------");
		
		for(int i = 1; i <=n; i++) {
			sum += i;
			System.out.printf("%-10d%d%n",i,sum);
		}
		
		/*
		for(int i = 1; i <= 10; i++) {
			int sum = 0; //지역변수
			for(int k = 1; k<=i; k++) {
				sum += k;
			}
			System.out.printf("%-10d%-10d\n",i,sum);
		}
		*/
		
		scanner.close();
	}

}
