package mymain;

import java.util.Scanner;

public class _13_Ex_dowhile1_������ {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int dan;
		
		String yn = "y"; //���ӿ���
		
		//do while�� �Ʒ��� ���� 
		//Ư�� ����� ���� ��(do), 
		//(������� �ǻ翡 ����) ������ �� Ȯ��(confirm) �� �ݺ��� �� ���.
		//*do - while�� ���������� �ݺ�Ƚ�� �� �� ����ϱ� ����
		do
		{
			System.out.print("�� : ");
			dan = scanner.nextInt();
			
			//������ ���
			for(int i = 1; i <=9; i++)
			{
				System.out.printf("%d x %d = %d\n",dan,i,dan*i);
			}
			
			//���ӿ��� Ȯ��
			System.out.print("��? (y/n)");
			yn = scanner.next();
			
			
		}while(yn.equals("y") || yn.equals("Y"));/*���� if(yn.equals("n")) break; */
		
		scanner.close();
		System.out.println("-----[END]-----");
	}

}
