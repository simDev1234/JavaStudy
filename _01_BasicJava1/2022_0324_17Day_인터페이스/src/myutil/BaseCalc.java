package myutil;

public interface BaseCalc {
	//�����׸� : ���, �߻�޼ҵ�
	//��, 1.8���� �̻��� ��� ����Ʈ�޼���, ����ƽ�޼��� ����
	
	//���
	public static final int ZERO = 0;
	/*    ��������   */ double PI = 3.141592;
	
	//�߻�޼ҵ�
	public abstract int plus(int a, int b);
	/* �������� */  int minus(int a, int b);
	
	//����Ʈ�޼ҵ� *���������� �������� �� �ִ�.
	       default int getMin() {return ZERO;};
}
