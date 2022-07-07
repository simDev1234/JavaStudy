package mymain;

public class 명명법 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//예약어         : 이미 생성된 명령(자료형/제어문/기타)
		//사용자정의명칭 : 클래스명/메소드명/변수명/상수명... 
		
		System.out.println("--[사용자정의 명칭 부여시 고려(제약)사항]--");
		System.out.println("1.숫자로 시작하면 안된다");
		//int 1kor;(X)    int kor1;(0)
		System.out.println("2.중간에 공백띄우면 안된다");
		//int my money; (X)   int mymoney; (0)   
		//                    int myMoney; (0) <- camel표기법 
		//                    int my_money;(0) <- snake표기법  
		System.out.println("3.특수문자 사용못한다(단, $  _ 제외)");
		System.out.println("  (특수문자:키보드에서 영문자/숫자/한글을 제외한 모든문자)");
		//int email$;  		int _;
		System.out.println("4.예약어 사용 못한다");
		//int public;
		
		
		System.out.println("---[클래스명 명명법(권고사항)]---");
		System.out.println("1.대문자로 시작한다");
		System.out.println("2.2개이상의 단어가 조합되면 매단어 첫글자는 대문자로 작성");
		//    class MyProfile
		//    위의 1,2규칙대로 작성되는 표기법 : Pascal표기법
		System.out.println("3.Pascal + Snake표기");
		//    class My_Profile  
		
		
		System.out.println("---[메소드명/변수명 명명법(권고사항)]---");
		System.out.println("1.소문자로 시작한다");
		System.out.println("2.2개이상의 단어가 조합되면 매단어 첫글자는 대문자로 작성(camel)");
		// String  myFamilyName;		String  myGivenName;    <- camel
		System.out.println("3.2개이상의 단어가 조합되면 매단어 연결을 _ 한다(snake)");
		//String my_family_name;        String  my_given_name;  <- snake
		
		//변수 : 변하는 수(값)
		int age = 10;
		age = 30;
		//상수 : 변하지 않는 수(값)
		final String MY_NAME = "홍길동";
		
		//MY_NAME="박길동"; (X)
		
		
		System.out.println("---[상수 명명법(권고사항)]---");
		System.out.println("1.모두 대문자로 기록");
		System.out.println("2.2개이상의 단어가 조합되면 매단어 연결을 _ 한다(snake)");
		
		
		
		System.out.println(Math.PI);
		System.out.println(Byte.MAX_VALUE);
		
		System.out.println(Byte.MIN_VALUE);
		
		
		//실수값 정밀도 비교
		double  d = 1.23456789012345678901234567;
		float   f = 1.23456789012345678901234567F;
		
		System.out.printf("%.20f\n", d); //double
		System.out.printf("%.20f\n", f); //float
		
		
		//  2의 보수를 구하는 방법
		//  1.하위bit에서부터 첫번째 1일 나올때까지는 그대로 내린다
		//  2.그다음부터는 1보수를 취한다  512 + 256 + 128 + 4 : 900
		//  001110000100
		//  110001111011  <- 1보수
		//            +1
		//  110001111100 
		//  110001111100
		
		//2진수 출력
		System.out.printf("[%32s]\n", Integer.toBinaryString(900) );
		System.out.printf("[%32s]\n", Integer.toBinaryString(-900) );
		
		
	}

}
