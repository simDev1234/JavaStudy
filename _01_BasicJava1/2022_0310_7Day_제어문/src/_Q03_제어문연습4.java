import java.util.Scanner;

public class _Q03_제어문연습4 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("두 정수와, 하나의 사칙연산자(+,-,*,/,%)를 입력하세요 >> ");
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
