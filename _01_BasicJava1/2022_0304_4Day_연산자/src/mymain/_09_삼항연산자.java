package mymain;

public class _09_���׿����� {
	public static void main(String[] args) {
		//6. ���׿����� 
		//���� ) (����) ? ��1(��) : ��2(����)
		
		//�� �� �߿� ū �� ���ϱ�
		int a = 3;
		int b = 2;
		int c;
		
		c = (a > b) ? a : b; 
		System.out.printf("%d�� %d �߿� ū ���� %d\n",a,b,c);
		//�� ���� if������ ����
		if(a > b) {
			c = a;
		}else {
			c = b;
		}
		    //���� ���, ��� ���ٴ� ���� �����ڰ� �� ó���ӵ��� ����..
		
		//���밪 ���ϱ�
		int n = -10;
		int m = (n < 0)? -n : n;
		System.out.printf("|%d| = %d\n",n,m);
	}

}
