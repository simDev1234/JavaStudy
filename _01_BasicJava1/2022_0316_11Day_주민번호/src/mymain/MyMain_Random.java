package mymain;

import java.util.Random;

public class MyMain_Random {

	public static void main(String[] args) {
		//����(������ ��)�߻�
		Random random = new Random();
		
		int su = random.nextInt(3); // 0 base <= 3���� ����� �� (0 1 2)
		
		su = random.nextInt(10); // 0~9, 10���� 0 <= x < 1
		//(int)(Math.random()*10) �� ����
		
		//1~45 ������ �����߻�
		su = random.nextInt(45) + 1;
		System.out.println(su);
		
		//10~30 ������ ����
		su = random.nextInt(21)*10;
	}

}
