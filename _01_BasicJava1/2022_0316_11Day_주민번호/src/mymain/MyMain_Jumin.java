package mymain;

import java.util.Scanner;
import myutil.Jumin;

public class MyMain_Jumin {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Jumin jumin = new Jumin();
		
		String jumin_no;
		String yn = "Y";
		
		OUTER_LOOP : 
		while(true) {
			System.out.print("�ֹι�ȣ�� �Է��ϼ���(��) 000000-0000000) :");
			jumin_no = scanner.next(); //�������� �Է� ��, nextLine();
			
			//�ֹι�ȣ ���� ��ü���� �ֹι�ȣ ����(setter���� ����)
			jumin.setJumin_no(jumin_no);
			
			//�ΰ����� ��û(����⵵, ����, ��, ����, ������ȣ, ����, ����, ��ȿ��üũ)
			boolean valid = jumin.isValid(); //��ȿ��
			if(valid == true) {
				System.out.printf("����⵵ : %d\n",jumin.getYear());
				System.out.printf("���� : %s\n",jumin.getGender());
				System.out.printf("���� : %s\n",jumin.getAge());
				System.out.printf("�� : %s\n",jumin.getTti());
				System.out.printf("���� : %s\n",jumin.getGender());
				System.out.printf("������ȣ : %s\n",jumin.getLocal());
				System.out.printf("���� : %s\n",jumin.getSeason());
				System.out.printf("���� : %s\n",jumin.getGanji());
			}else {
				System.out.println("�������� �ʴ� �ֹι�ȣ�Դϴ�.");
			}
			
			//����ۿ���	
			for(;;) {			
				System.out.print("�ٽ� �Ͻðڽ��ϱ�?(y/n) : ");
				yn = scanner.next();
				
				if(yn.equalsIgnoreCase("Y")) 
					break;
				else if(yn.equalsIgnoreCase("N"))
					break OUTER_LOOP;
				else {
					System.out.println("���� ������ �𸣰ھ��. Y �Ǵ� N�� �����ּ���.");
					continue;
				}
			}
		}
		
		scanner.close();
	}

}
