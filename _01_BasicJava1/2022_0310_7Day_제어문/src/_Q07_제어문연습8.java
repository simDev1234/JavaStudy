import java.util.*;

public class _Q07_�������8 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n, sum = 0; //main�Լ� ���忡�� ��� ��������
		
		System.out.print("n(���) : ");
		n = scanner.nextInt();
		
		System.out.println("n      1���� n������ ��");
		System.out.println("-----------------------");
		
		for(int i = 1; i <=n; i++) {
			sum += i;
			System.out.printf("%-10d%d%n",i,sum);
		}
		
		/*
		for(int i = 1; i <= 10; i++) {
			int sum = 0; //��������
			for(int k = 1; k<=i; k++) {
				sum += k;
			}
			System.out.printf("%-10d%-10d\n",i,sum);
		}
		*/
		
		scanner.close();
	}

}
