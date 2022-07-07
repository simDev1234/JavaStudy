package mymain;

import java.util.Scanner;

public class _13_Ex_dowhile1_구구단 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int dan;
		
		String yn = "y"; //지속여부
		
		//do while은 아래와 같이 
		//특정 명령을 행한 뒤(do), 
		//(사용자의 의사에 따라) 지속할 지 확인(confirm) 후 반복할 때 사용.
		//*do - while도 마찬가지로 반복횟수 모를 때 사용하기 용이
		do
		{
			System.out.print("단 : ");
			dan = scanner.nextInt();
			
			//구구단 출력
			for(int i = 1; i <=9; i++)
			{
				System.out.printf("%d x %d = %d\n",dan,i,dan*i);
			}
			
			//지속여부 확인
			System.out.print("또? (y/n)");
			yn = scanner.next();
			
			
		}while(yn.equals("y") || yn.equals("Y"));/*조건 if(yn.equals("n")) break; */
		
		scanner.close();
		System.out.println("-----[END]-----");
	}

}
