package myutil;

public class MyMath {
	//�� �� �� �ִ밪 ���ϱ�
	public int max(int a, int b) {
		return (a >= b)? a : b;
	}
	
	//�� ��� �� ū ��
	public int max(int a, int b, int c) { // �ߺ� �޼��� (Method Overload)
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
	
	//�������� ��� �� ū ��
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
	
	//���n : 1~n������ ��
	public int toMaxSum(int n) {
		if(n < 0) return -1;
		int result = 0;
		for(int i = 1; i <= n; i++) {
			result += i;
		}
		return result;
	}
	
	//��� n,m : n������ �� �� m�� ����� ��
	public int toMaxSum(int n, int m) {
		//�Ű����� ��ȿ�� üũ
		if(n < 0) return -1; 
		//��
		int result = 0;
		for(int i = 1; i <= n; i++) {
			if(i % m == 0)
				result += i;
		}
		return result;
	}
	
	//��� n, ���� m : n�� m���� ���ϱ� (��ȯŸ�� : double)
	public double pow(int n, int m) {
		//�Ű����� ��ȿ�� üũ
		if(n < 0 || m < 0) return -1; 
		if(m == 0) return 1;
		//��
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
		//�Ű����� ��ȿ�� üũ
		return (b == 0) ? 0 : a / b;
	}
}
