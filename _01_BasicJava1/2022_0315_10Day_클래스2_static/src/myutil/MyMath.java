package myutil;

//���� ��ü : ������ ���� �޼ҵ常 ����
//�ν��Ͻ� �޼���
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
