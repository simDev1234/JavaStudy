package mymain;

import java.util.Scanner;

public class _03_����ó��Ȱ�� {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int dan;
		
		while(true) {
			//��Ŭ���� try-catch ����Ű : alt+shift+z
			try {
				System.out.printf("��:");
				dan = scanner.nextInt();
				
				if(dan < 2 || dan > 9) { //���� ����� ��
					//System.out.println("2~9 ������ ���ڸ� �Է��ϼ���.");
					//continue;
					throw new Exception();
				}
				for(int i = 1; i <= 9; i++) {
					System.out.printf("%d x %d = %d\n",dan,i,dan*i);
				}
			}catch (Exception e) { //���ڰ� �ƴ� �� �Է����� ��
				//e.printStackTrace();
				System.out.println("2~9������ ���ڸ� �Է����ּ���.");
				scanner.nextLine();
			}
		}
	}
}
