package mymain;

import myutil.Save;

public class MyMain_Save {
    //���α׷� ���۽ÿ� main�Լ� ���۵Ǿ�� �ϹǷ�, static����
	public static void main(String[] args) {
		//static������ ��ü �������� �ʰ� ��� ����
		//Ŭ������.������
		//Ŭ��������
		Save.rate = 0.1;
		//Save.money = 10000; <-- warning!
		
		Save s1 = new Save("�ϱ浿",1000000);
		Save s2 = new Save("�̱浿",2000000);
		Save s3 = new Save("��浿",3000000);
		
		System.out.printf("----[���� : %.0f%%]----\n",Save.rate*100);
		s1.display();
		s2.display();
		s3.display();
		
		//static������ ��������(�� ��ü�� ��� �̿��� �� �ִ�.)
		//s1.rate = 0.15; <-- �ᵵ �ǰ� ������ �����ϳ� warning! 
		Save.rate = 0.15;
		System.out.printf("----[���� : %.0f%%]----\n",Save.rate*100);
		s1.display();
		s2.display();
		s3.display();
	}

}
