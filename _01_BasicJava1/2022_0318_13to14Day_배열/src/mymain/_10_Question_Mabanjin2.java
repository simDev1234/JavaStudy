package mymain;

import java.util.Scanner;
import myutil.Mabanjin2;

public class _10_Question_Mabanjin2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int chasu;
		String yn = "y";
		Mabanjin2 mabanjin = new Mabanjin2();
		
		while(true) {
			System.out.print("���� : ");
			chasu = scanner.nextInt();
			
			if(chasu%2==0) {
				System.out.println("Ȧ���� �Է��ϼ���.");
				continue;
			}
			
			//������ ��ü - ���� ����(setter)
			mabanjin.setChasu(chasu);
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