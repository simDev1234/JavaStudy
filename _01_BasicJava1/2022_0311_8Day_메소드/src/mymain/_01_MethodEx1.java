package mymain;

public class _01_MethodEx1 {
	
	/* 
	   �޼ҵ� ȣ�� ��Ŀ� ���� �з�
	   1. Call by Name      : �̸��� ȣ�� (ex. title() )
	   2. Call by Value     : �̸�+���� ȣ�� (ex. plus(x, y) )
	   3. Call by Reference : �̸�+����(��������) ȣ�� 
	*/
	
	public static void title() { 
		//void : ���� ������ ��Ÿ���� ��¡�� �ڷ���(��ġ��)
		System.out.println("------�޼ҵ� ����-----");
		return; //���� ���� **void(����ִ�) - ������� return.
	}
	
	public static int plus(int x, int y) {
		return x + y; //return : �ڽ��� ȣ���� ������ ���ư���.
	}

	public static void main(String[] args) {
		int x = 3;
		int y = 4;
		title();
		System.out.println("x + y = "+plus(x ,y)); //_01_MethodEx1.plus(x,y)
	}
	//static�޼��� �ȿ����� static�޼��常 ȣ���� �� ����.
	
}
