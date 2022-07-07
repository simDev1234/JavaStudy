package mymain;

import java.util.Random;

public class MyMain_Random {

	public static void main(String[] args) {
		//난수(무작위 수)발생
		Random random = new Random();
		
		int su = random.nextInt(3); // 0 base <= 3가지 경우의 수 (0 1 2)
		
		su = random.nextInt(10); // 0~9, 10가지 0 <= x < 1
		//(int)(Math.random()*10) 과 동일
		
		//1~45 숫자의 난수발생
		su = random.nextInt(45) + 1;
		System.out.println(su);
		
		//10~30 가지의 난수
		su = random.nextInt(21)*10;
	}

}
