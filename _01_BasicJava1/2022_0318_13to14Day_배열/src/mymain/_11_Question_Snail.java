package mymain;

import java.util.Scanner;
import myutil.Snail;

public class _11_Question_Snail {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int chasu;
		String yn = "y";
		Snail snail = new Snail();
		
		while(true) {
			System.out.print("���� : ");
			chasu = scanner.nextInt();
						
			//������ ��ü - ���� ����(setter)
			snail.setChasu(chasu);
			//������ ���
			
			//��?
			System.out.print("��?(y/n) : ");
			yn = scanner.next();
			if(!yn.equalsIgnoreCase("y")) break;
		}//end while
		
		System.out.println("----END----");
		scanner.close();
	}//end main
	
}