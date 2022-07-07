package mymain;

import java.util.Scanner;
import myutil.Lotto;

public class _05_MyMain_Lotto {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Lotto lotto = new Lotto();
		
		//User input : �ζ� ��ȣ �Է�
		int[] user_no = new int[6];
		String yn = "Y";
		
		//��÷ ����
		lotto.makeWinNo();
		
		while(true) {
			System.out.print("���� 6���� �Է��ϼ���(1~45���� ����) : ");
			
			user_no[0] = scanner.nextInt();
			user_no[1] = scanner.nextInt();
			user_no[2] = scanner.nextInt();
			user_no[3] = scanner.nextInt();
			user_no[4] = scanner.nextInt();
			user_no[5] = scanner.nextInt();
			
			
			//�ζ� ��ü���� �Է� ��ȣ�� ����
			lotto.setUser_no(user_no);
			
			
			//�ζ� ��ü���� ��÷���� Ȯ�� �� ��� ���
			lotto.display();
			
			//��?
			System.out.print("�� �ҷ�? (y/n) : ");
			yn = scanner.next();
			
			if(yn.equalsIgnoreCase("y")==false) break;
		}
		
		
		scanner.close();
	}

}
