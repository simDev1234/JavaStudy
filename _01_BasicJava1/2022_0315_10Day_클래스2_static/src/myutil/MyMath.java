package myutil;

//서비스 객체 : 변수가 없이 메소드만 제공
//인스턴스 메서드
public class MyMath {
	public int plus(int a, int b) {
		return a + b;
	}
	public int hap(int n) {
		int sum = 0;
		for(int i = 0; i<=n; i++) {
			sum += i;
		}
		return sum;
	}
}
