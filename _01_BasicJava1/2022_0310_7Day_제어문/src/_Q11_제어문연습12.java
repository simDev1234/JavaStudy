import java.util.Scanner;

public class _Q11_�������12 {

	public static void main(String[] args) {
		double r = 1.0;
		int n = 0;
		double result = 1.0;
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("�Ǽ��� �Է��ϼ��� : ");
		r = scanner.nextDouble();
		System.out.print("������ �Է��ϼ��� : ");
		n = scanner.nextInt();
		
		for(int i = 0; i < n; i++) {
			result = result * r;
		}
		System.out.printf("%.1f",result);
		
		scanner.close();
	}

}
