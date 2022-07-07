package mymain;

import myutil.MyMath;

public class _02_MethodEx2 {

	public static void main(String[] args) {
		//메소드 사용자
		//참조변수 => 객체(인스턴스)
		MyMath mm = new MyMath();
		int x = 3;
		int y = 4;
		double a = 3.0;
		double b = 4.0;
		
		System.out.println("sum : "+mm.plus(x, y));
		System.out.println("sum : "+MyMath.plus(a, b));
		System.out.println("toMaxSum : "+mm.toMaxSum(x));
		System.out.println("toMaxSum : "+mm.toMaxSum(0));
		System.out.println("Max : "+mm.max(9,1,7));
		System.out.println("Max : "+mm.max(-3,1,7));
		System.out.println("Max : "+mm.max(43,1,7,4,5,6,8,10));
		System.out.println("toMaxSum : "+mm.toMaxSum(5, 2));
		System.out.printf("Power : %.0f",mm.pow(3,2));
		
		
	
		//가비지 컬렉터가 인스턴스 해제
	}

}


