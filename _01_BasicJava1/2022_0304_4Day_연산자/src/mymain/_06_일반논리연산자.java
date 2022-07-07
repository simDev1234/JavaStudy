package mymain;

public class _06_�Ϲݳ������� {

	public static void main(String[] args) {
		//5. �Ϲݳ������� : &&(AND), ||(OR)
		//A && B : A,B ��� ���� �� ��
		//A || B : A �Ǵ� B �� �ϳ��� ���� �� ��
		System.out.println("----[&&]----");
		System.out.printf("true && true : %b\n", (true && true));
		System.out.printf("true && true : %b\n", (true && false));
		System.out.printf("true && true : %b\n", (false && true)); //Alert : Dead Code 
		System.out.printf("true && true : %b\n", (false && false));//Alert : Dead Code 
		
		System.out.println("----[||]----");
		System.out.printf("true || true : %b\n", (true || true));  //Alert : Dead Code  
		System.out.printf("true || true : %b\n", (true || false)); //Alert : Dead Code 
		System.out.printf("true || true : %b\n", (false || true));  
		System.out.printf("true || true : %b\n", (false || false));
		
		//�Ϲݳ�������(&&, ||)�� ������ ������ ��
		//Short Circuit Evaluation        --- java�� �ƴ϶� �ٸ� ������ �̷��� ������ ������ ��
		int x = 1;
		int y = 2;
		boolean bResult;
		
		bResult = (--x > 0) && (++y > 0);
		//      =   ( 0 > 0)    &&  (3 > 0)
		//      =    false  &&   true
		//      =    false
		// �������δ� x = 0, y = 3; bResult = false; �� ���;� �ϴµ�, 
		// �����δ� x = 0, y = 2, bResult = false; --> why? �Ϲݳ��������� &&�� ������ ������ �ؼ�, �տ��� false�� &&�� ����XX
		System.out.printf("x : %d, y : %d, bResult : %b\n", x, y, bResult);
		
		bResult = (++x > 0) || (++y > 0);
		//�������>>
		//      ++x = 0 + 1      
		//          1 > 0             
		//           true
		//                     y���� ���� ����(y=2)
		// ����� x = 1, y =2, true
		System.out.printf("x : %d, y : %d, bResult : %b\n", x, y, bResult);
	}

}
