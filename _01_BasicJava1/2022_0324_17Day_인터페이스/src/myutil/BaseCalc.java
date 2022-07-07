package myutil;

public interface BaseCalc {
	//구성항목 : 상수, 추상메소드
	//단, 1.8버전 이상의 경우 디폴트메서드, 스태틱메서드 가능
	
	//상수
	public static final int ZERO = 0;
	/*    생략가능   */ double PI = 3.141592;
	
	//추상메소드
	public abstract int plus(int a, int b);
	/* 생략가능 */  int minus(int a, int b);
	
	//디폴트메소드 *선택적으로 재정의할 수 있다.
	       default int getMin() {return ZERO;};
}
