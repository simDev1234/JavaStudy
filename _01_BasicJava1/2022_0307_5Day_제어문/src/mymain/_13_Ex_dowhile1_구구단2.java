package mymain;

import java.util.Scanner;

public class _13_Ex_dowhile1_������2 {

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
			System.out.print("��(2~9��) : ");
			dan = scanner.nextInt();
			
			//2��~9�ܸ� ���
			if(dan >= 2 && dan <=9){
				//������ ���
				for(int i = 1; i <=9; i++){
					System.out.printf("%d x %d = %d\n",dan,i,dan*i);
				}
				//���ӿ��� Ȯ��
				System.out.print("�ٽ� �Ͻðڽ��ϱ�? (y/n)");
				yn = scanner.next();
			}else{
				System.out.println("2~9�� �� �ϳ��� �Է��ϼ���.");
			}	
		}while(yn.equals("y") || yn.equals("Y"));/*���� if(yn.equals("n")) break; */
		
		scanner.close();
		System.out.println("-----[END]-----");
	}

}
