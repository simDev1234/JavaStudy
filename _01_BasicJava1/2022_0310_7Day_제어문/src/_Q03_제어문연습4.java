import java.util.Scanner;

public class _Q03_�������4 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("�� ������, �ϳ��� ��Ģ������(+,-,*,/,%)�� �Է��ϼ��� >> ");
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		String opt = scanner.next();
		int result = 0;
		
		if(opt.equals("+")) {
			result = a + b;
		}else if(opt.equals("-")) {
			result = a - b;
		}else if(opt.equals("*")) {
			result = a * b;
		}else if(opt.equals("/")) {
			result = a / b;
		}else if(opt.equals("%")) {
			result = a % b;
		}
		
		System.out.printf("%d %s %d = %d",a,opt,b,result);
		
		scanner.close();
	}

}
