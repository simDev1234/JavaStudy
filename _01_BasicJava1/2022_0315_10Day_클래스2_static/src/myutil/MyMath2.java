package myutil;

//���� ��ü : ������ ���� �޼ҵ常 ����
//static �޼���
public class MyMath2 {
	
	//�ܺο��� ��ü���� ����
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
