import java.util.Scanner;

public class _Q01_�������2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int a, b, c;
		int min;
		
		System.out.print("�� ���� ������ �Է��ϼ���. >> ");
		a = scanner.nextInt();
		b = scanner.nextInt();
		c = scanner.nextInt();
		
		min = (a > b)? a : b;
		min = (min > c)? c : min;
		
		System.out.printf("�� ���� ���� �߿��� ���� ���� �� : %d",min);
		
		scanner.close();
	}

}
