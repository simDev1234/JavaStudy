package mymain;

public class _06_일반논리연산자 {

	public static void main(String[] args) {
		//5. 일반논리연산자 : &&(AND), ||(OR)
		//A && B : A,B 모두 참일 때 참
		//A || B : A 또는 B 중 하나만 참일 때 참
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
		
		//일반논리연산자(&&, ||)는 경제적 연산을 함
		//Short Circuit Evaluation        --- java뿐 아니라 다른 언어에서도 이렇게 경제적 연산을 함
		int x = 1;
		int y = 2;
		boolean bResult;
		
		bResult = (--x > 0) && (++y > 0);
		//      =   ( 0 > 0)    &&  (3 > 0)
		//      =    false  &&   true
		//      =    false
		// 논리적으로는 x = 0, y = 3; bResult = false; 가 나와야 하는데, 
		// 실제로는 x = 0, y = 2, bResult = false; --> why? 일반논리연산자인 &&은 경제적 연산을 해서, 앞에가 false면 &&뒤 수행XX
		System.out.printf("x : %d, y : %d, bResult : %b\n", x, y, bResult);
		
		bResult = (++x > 0) || (++y > 0);
		//실행순서>>
		//      ++x = 0 + 1      
		//          1 > 0             
		//           true
		//                     y쪽은 수행 안함(y=2)
		// 결과는 x = 1, y =2, true
		System.out.printf("x : %d, y : %d, bResult : %b\n", x, y, bResult);
	}

}
