package mymain;

public class _08_Ex_for3_¦Ȧ�����ϱ� {

	public static void main(String[] args) {
		
		int sum = 0;
		int num = 10;
		
		for(int i = 1; i <= num; i++) 
		{
			sum += i;
		}
		System.out.println("���� ������ �� : "+sum);
		
		sum = 0;
		
		//1~num �� ¦���� ���ϱ� - ���1_if������ ����_1 (2) 3 (4) 5 (6)...
		for(int i = 1; i <= num; i++) 
		{
			if(i % 2 == 0) {
				sum += i;
			}
		}
		System.out.println("2�� ����� �� : "+sum);
		
		sum = 0;
		
		//1~num �� ¦���� ���ϱ� - ���2_for�� �� ������Ȱ��
		for(int i = 0; i <= num; i+=2) 
		{
			sum += i;
		}
		System.out.println("2�� ����� �� : "+sum);
		
		sum = 0;
		
		//1~num �� Ȧ���� �� 
		for(int i = 1; i <=num; i+=2)
		{
			sum += i;
		}
		System.out.println("Ȧ���� �� : "+sum);
	}

}
