package mymain;

import java.util.*;

public class _07_일반논리연산자응용 {

	public static void main(String[] args) {
		// [범위산정할 때 && 사용]
		// 유아기 : 0~6
		// 아동기 : 7~13
		// 청소년 : 14~19
		// 청년 : 20~40
		// 장년 : 41~70
		// 노년 : 71~
		
		Scanner scanner = new Scanner(System.in);
		
		int age; 
		System.out.printf("나이 : ");
		age = scanner.nextInt();
		
		if(age >= 0 && age <=6) System.out.printf("[%d살]은 [유아기]에 해당합니다.\n",age);
		
		if(age >= 7 && age <= 13) System.out.printf("[%d살]은 [아동기]에 해당합니다.\n",age);
		
		if(age >= 14 && age <= 19) System.out.printf("[%d살]은 [청소년]에 해당합니다.\n",age);
		
		if(age >= 20 && age <= 40) System.out.printf("[%d살]은 [청년]에 해당합니다.\n",age);
		
		if(age >= 41 && age <= 70) System.out.printf("[%d살]은 [장년]에 해당합니다.\n",age);
		
		if(age > 70) System.out.printf("[%d살]은 [노년]에 해당합니다.\n",age);
		
		scanner.close();
	}

}
