import java.util.Scanner;

public class _Q08_�������9 {

	public static void main(String[] args){
		
		Scanner scanner = new Scanner(System.in);
		
		int n;
		double result = 1; //n�� Ŀ�� ���� ���� �� �ִ� ũ�� ������
//		int i = 1;
		
		System.out.printf("n : ");
		n = scanner.nextInt();
		
		/*
		while(i <= n) {
			result = result * i;
			i++;
		}
		System.out.printf("%d ! = %d",n,result);
		*/
		
		//5! = 5 * 4 * 3 * 2 * 1;
		for(int j = n; j >= 1; j--) {
			result = result * j;
		}
		System.out.printf("%d ! = %.1f",n,result);
		
		scanner.close();
		
	}

}
