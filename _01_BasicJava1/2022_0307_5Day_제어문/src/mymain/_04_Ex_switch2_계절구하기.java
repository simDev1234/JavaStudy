package mymain;

import java.util.Scanner;

public class _04_Ex_switch2_계절구하기 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int month;
		String season = "";
		
		System.out.print("월 : ");
		month = scanner.nextInt();
		
		//유효성 검사
		if(month >= 1 && month <= 12) {
			//계절 구하기__방법1
			switch(month) 
			{
				case 3: case 4:  case 5: season="봄";     break;
				case 6: case 7:  case 8: season="여름";   break;
				case 9: case 10: case 11: season= "가을"; break;
				default : season="겨울";
			}
		}else {
			System.out.println("월은 1~12사이 값을 입력하세요.");
		}
		
		System.out.printf("[%d월]의 계절은 [%s]입니다.",month,season);
		
		scanner.close();
	}

}
