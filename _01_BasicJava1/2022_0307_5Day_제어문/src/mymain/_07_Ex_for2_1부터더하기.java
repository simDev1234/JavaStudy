package mymain;

public class _07_Ex_for2_1���ʹ��ϱ� {

	public static void main(String[] args) /* throws InterruptedException */ {
		
		int num = 20;
		int sum = 0;
		
		//1+2+3+...+num ���ϱ�
		for(int i = 1; i <= num; i++) 
		{
			System.out.print(i);
			if(i<num) 
				System.out.print('+');
			else
				System.out.print('=');
			//����ð� ���� - 1�� ���
			/* Thread.sleep(1000); */
			
			sum += i;
		}
		System.out.print(sum);
	}

}
