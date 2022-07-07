package mymain;

import java.util.Scanner;

public class _05_Ex_switch3_문제 {

	public static void main(String[] args) {
		//1.국어점수 입력받는다.
		//2. switch문을 이용해서 등급을 산출하세요.(ABCDF)--수식활용(10배)
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("국어 점수 : ");
		int score = scanner.nextInt();
		char grade = 'F';
		
		//유효성 확인
		if(score>=0 && score<=100) {
			//등급내기
			switch(score/10) 
			{
				case 10 : 
				case  9 : grade = 'A'; break;
				case  8 : grade = 'B'; break;
				case  7 : grade = 'C'; break;
				case  6 : grade = 'D'; break;
				default : grade = 'F';
			}
			
			System.out.printf("[%d]점일 때, 등급은 [%c]입니다.",score,grade);
			
		}else {
			System.out.println("유효하지 않은 값입니다.(0~100사이)");
		}
		
		scanner.close();
	}

}
