package mymain;

import java.util.Scanner;

public class _14_Ex_dowhile1_������3_continue {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int dan;
		String yn = "y"; 
		
		do
		{
			//����� �Է�
			System.out.print("��(2~9��) : ");
			dan = scanner.nextInt();
			
			//��ȿ������ Ȯ��(�Է°��� 2-9���� �ƴ� ���)
			if(!(dan >= 2 && dan <=9)){
				System.out.println("2~9�� �� �ϳ��� �Է��ϼ���.");
				continue; //�ݺ��� �������� ��� ������ control��
				          //���ǿ� �����ϴ� ����� �����ϰ� ���� ��������� �̵��ض�.
			}
			
			//������ ���
			for(int i = 1; i <=9; i++){
				System.out.printf("%d x %d = %d\n",dan,i,dan*i);
			}
			//���ӿ��� Ȯ��
			System.out.print("�ٽ� �Ͻðڽ��ϱ�? (y/n)");
			yn = scanner.next();
		}while(yn.equals("y") || yn.equals("Y"));/*���� if(yn.equals("n")) break; */
		
		scanner.close();
		System.out.println("-----[END]-----");
	}

}
