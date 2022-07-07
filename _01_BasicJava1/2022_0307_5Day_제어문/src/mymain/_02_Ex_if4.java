package mymain;

import java.util.Scanner;

public class _02_Ex_if4 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int kor; //나의 국어점수
		String grade = "F"; //결과(나의 등급)
		System.out.print("국어 : ");
		kor = scanner.nextInt();
		
		//등급 세분
		
		if(kor>=0 && kor<=100) 
		{
			if(kor>=96) grade = "A+";
			else if(kor>=93) grade = "A";
			else if(kor>=90) grade = "A0";
			else if(kor>=86) grade = "B+";
			else if(kor>=83) grade = "B";
			else if(kor>=80) grade = "B0";
			else if(kor>=76) grade = "C+";
			else if(kor>=73) grade = "C";
			else if(kor>=70) grade = "C0";
			else if(kor>=66) grade = "D+";
			else if(kor>=63) grade = "D";
			else if(kor>=60) grade = "D0";
			else if(kor>=56) grade = "F+";
			else if(kor>=53) grade = "F";
			else if(kor>=50) grade = "F0";
		}
		else
		{
			System.out.printf("입력된 점수 [%d]는 유효하지 않습니다.",kor);
		}
		
		System.out.printf("국어점수 : %d(점) --> 등급 : %s\n",kor,grade);
		
		scanner.close();
	}

}
