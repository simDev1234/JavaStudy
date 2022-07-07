package mymain;

import java.util.Scanner;

public class _02_Ex_if3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int kor; //나의 국어점수
		//String grade="ABCDF"; //등급
		char result = 'F'; //결과(나의 등급)
		System.out.print("국어 : ");
		kor = scanner.nextInt();
		
		//등급 계산
		//A : 90-100
		//B : 80-89
		//C : 70-79
		//D : 60-69
		//F : 60미만
		
		//효율적 코드 
		//방법 1)
		/*
		if(kor>=90 && kor <= 100) 
			result = grade.charAt(0);
		else if(kor>=80 && kor <90) 
			result = grade.charAt(1);
		else if(kor>=70 && kor <80) 
			result = grade.charAt(2);
		else if(kor>=60 && kor <70) 
			result = grade.charAt(3);	
		*/
		//방법 2)
		//유효범위를 먼저 체크(0~100)
		if(kor>=0 && kor<=100) 
		{
			if(kor>=90) result = 'A';
			else if(kor>=80) result = 'B';
			else if(kor>=70) result = 'C';
			else if(kor>=60) result = 'D';
			//else grade = 'F';
		}
		else
		{
			System.out.printf("입력된 점수 [%d]는 유효하지 않습니다.",kor);
		}
		
		System.out.printf("국어점수 : %d(점) --> 등급 : %c\n",kor,result);
		
		scanner.close();
	}

}
