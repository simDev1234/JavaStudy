package mymain;

import java.util.Scanner;

public class _14_Ex_dowhile1_구구단3_continue {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int dan;
		String yn = "y"; 
		
		do
		{
			//사용자 입력
			System.out.print("단(2~9단) : ");
			dan = scanner.nextInt();
			
			//유효성부터 확인(입력값이 2-9단이 아닌 경우)
			if(!(dan >= 2 && dan <=9)){
				System.out.println("2~9단 중 하나를 입력하세요.");
				continue; //반복문 내에서만 사용 가능한 control문
				          //조건에 만족하는 명령을 종료하고 다음 제어식으로 이동해라.
			}
			
			//구구단 출력
			for(int i = 1; i <=9; i++){
				System.out.printf("%d x %d = %d\n",dan,i,dan*i);
			}
			//지속여부 확인
			System.out.print("다시 하시겠습니까? (y/n)");
			yn = scanner.next();
		}while(yn.equals("y") || yn.equals("Y"));/*조건 if(yn.equals("n")) break; */
		
		scanner.close();
		System.out.println("-----[END]-----");
	}

}
