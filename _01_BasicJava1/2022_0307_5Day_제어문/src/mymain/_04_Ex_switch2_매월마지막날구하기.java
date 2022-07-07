package mymain;

import java.util.Scanner;

public class _04_Ex_switch2_매월마지막날구하기 {
	public static void main(String[] args) {
		//매월 마지막 날짜를 구하는 프로그램
		
		// 1   2   3   4   5   6   7   8   9   10   11   12
		// 31  28  31  30  31  30  31  31  30  31   30   31
		
		Scanner scanner = new Scanner(System.in);
		
		int month;
		int last_day = 31;
		
		System.out.print("월 : ");
		month = scanner.nextInt();
		
		//switch : 다차원 선택
		//유효성 검사
		if(month>=1 && month<=12) {
			//마지막날 구하기
			switch(month) 
			{
				case 2: last_day=28; break;
				case 4: 
				case 6: 
				case 9: 
				case 11:last_day=30; break;
				default:last_day=31;
			}
		}else {
			System.out.println("월은 1~12사이 값을 입력하세요.");
		}
		
		System.out.printf("[%d월]의 마지막날은 [%d일]입니다.",month,last_day);
		
		scanner.close();
	}

}
