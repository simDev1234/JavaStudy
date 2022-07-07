package myutil;

public class MyMath {
	//두 수 중 최대값 구하기
	public int max(int a, int b) {
		return (a >= b)? a : b;
	}
	
	//세 양수 중 큰 수
	public int max(int a, int b, int c) { // 중복 메서드 (Method Overload)
		if(a < 0 || b < 0 || c < 0) {
			return -1;
		}
		int max = 0;
		int[] arr = {a, b, c};
		for(int i = 0; i < 3; i++) {
			if(max <= arr[i]) {
				max = arr[i];
			}
		}
		return max;
		/*
		int max = a >= b ? a : b;
		max = max >= c? max : c;
		return max; */
	}
	
	//여러개의 양수 중 큰 수
	public int max(int...args) {
		int max = 0;
		int[] arr = new int[args.length];
		for(int i = 0; i < args.length; i++) {
			arr[i] = args[i];
		}
		for(int i = 0; i < arr.length; i++) {
			if(max <= arr[i]) {
				max = arr[i];
			}
		}
		return max;
	}
	
	//양수n : 1~n까지의 합
	public int toMaxSum(int n) {
		if(n < 0) return -1;
		int result = 0;
		for(int i = 1; i <= n; i++) {
			result += i;
		}
		return result;
	}
	
	//양수 n,m : n까지의 수 중 m의 배수의 합
	public int toMaxSum(int n, int m) {
		//매개변수 유효성 체크
		if(n < 0) return -1; 
		//식
		int result = 0;
		for(int i = 1; i <= n; i++) {
			if(i % m == 0)
				result += i;
		}
		return result;
	}
	
	//양수 n, 정수 m : n의 m승을 구하기 (반환타입 : double)
	public double pow(int n, int m) {
		//매개변수 유효성 체크
		if(n < 0 || m < 0) return -1; 
		if(m == 0) return 1;
		//식
		double result = 1; 
		for(int i = 0; i < m; i++) {
			result = n * result;
		}
		return result;
	}
	
	public int plus(int a, int b) {
		return a + b;
	}
	public static double plus(double a, double b) { //overloading
		return a + b;
	}
	
	public int minus(int a, int b) {
		return a - b;
	}
	
	public int muliply(int a, int b) {
		return a * b;
	}
	
	public int divide(int a, int b) {
		//매개변수 유효성 체크
		return (b == 0) ? 0 : a / b;
	}
}
