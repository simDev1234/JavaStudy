package mymain;

public class _01_MethodEx1 {
	
	/* 
	   메소드 호출 방식에 따른 분류
	   1. Call by Name      : 이름만 호출 (ex. title() )
	   2. Call by Value     : 이름+인자 호출 (ex. plus(x, y) )
	   3. Call by Reference : 이름+인자(참조변수) 호출 
	*/
	
	public static void title() { 
		//void : 값이 없음을 나타내는 상징적 자료형(무치형)
		System.out.println("------메소드 연습-----");
		return; //생략 가능 **void(비어있다) - 빈손으로 return.
	}
	
	public static int plus(int x, int y) {
		return x + y; //return : 자신을 호출한 곳으로 돌아가라.
	}

	public static void main(String[] args) {
		int x = 3;
		int y = 4;
		title();
		System.out.println("x + y = "+plus(x ,y)); //_01_MethodEx1.plus(x,y)
	}
	//static메서드 안에서는 static메서드만 호출할 수 있음.
	
}
