package myutil;

//서비스 객체 : 변수가 없이 메소드만 제공
//static 메서드
public class MyMath2 {
	
	//외부에서 객체생성 금지
	private MyMath2() {}
	
	public static int plus(int a, int b) {
		return a + b;
	}
	public static int hap(int n) {
		int sum = 0;
		for(int i = 0; i<=n; i++) {
			sum += i;
		}
		return sum;
	}
}
