package myutil;
//�ڹ��� ��� ��ü�� Object�κ��� ��ӹ޴´�.
public class BaseCalc /*extends Object*/{
	public int plus(int a, int b) {
		return a + b;
	}
	public int minus(int a, int b) {
		return a - b;
	}
	public int multiply(int a, int b) {
		return a * b;
	}
	public int divide(int a, int b) {
		return (b == 0)? 0 : a/b;
	}
}
