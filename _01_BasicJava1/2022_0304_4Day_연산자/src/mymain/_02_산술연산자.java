package mymain;

public class _02_��������� {

	public static void main(String[] args) {
		//2. ��������� : + , - , * , /(��) , %(������)
		int x = 10, y = 3, z;
		
		z = x + y;
		System.out.printf("%d + %d = %d\n", x, y, z);
		
		z = x - y;
		System.out.printf("%d - %d = %d\n", x, y, z);
		
		z = x * y;
		System.out.printf("%d * %d = %d\n", x, y, z);
		
		//�� - ����Ǵ� �ڷ����� ���� ��Ȯ�� ���� ���� ���� �ְ�, ���� ���� ���� ���� ����.
		      //int/int = int <-��
		      //double/int = double/double = 2.344246 <- ���� ��
		z = x / y;
		System.out.printf("%d / %d = %d\n", x, y, z);
		
		//������
		z = x % y;
		System.out.printf("%d %% %d = %d\n", x, y, z); //%�� ���ڷ� �νĽ�Ű����, %% -> '%'
		
		//cf) Format ���� ������ "�� ���ڷ� �νĽ�Ű����, �տ� \���̱�
		System.out.println("���� \"��\"�� �ʹ� ����");
		//cf) Format ���� ������ \�� ���ڷ� �νĽ�Ű����, �տ� \���̱�
		System.out.println("���� \\��\\�� �ʹ� ����");
		
		//�� ����) double, int ���� ���
		System.out.println(10.0/3); //���� ��(double����)
		System.out.println((int)10.0/3); //��(int����)
		System.out.println((int)10.0/3.0); //���� ��(double����)
		System.out.println((int)(10.0/3.0)); //���� ��(double����)
		
		//������ ����)
		System.out.println(10.0%3); //double�� ������ : 1.0�Ǽ��� ����
		 //������ < ���� => ����
		System.out.println(3%10); //int�� ������ 3 (���� 0)
		
		//Java������ int������ ���� ������ ����Ǹ� ����� int���� ����. 
		//byte + byte -> int
		//short + short -> int
		//byte + short -> int
		byte b1 = 1;
		byte b2 = 2;
		byte b3;
		
		// b3 = b1 + b2; <-- �����߻� ) byte + byte -> int **Java�� short�� byte��� �����ϸ� int�� �ٲ�
		b3 = (byte)(b1+b2);
		
		short s1 = 1;
		short s2 = 2;
		short s3;
		
		//s3 = s1 + s2; 
		s3 = (short)(s1 + s2);
		s3 = (short)(b1 + s1);
	}

}
