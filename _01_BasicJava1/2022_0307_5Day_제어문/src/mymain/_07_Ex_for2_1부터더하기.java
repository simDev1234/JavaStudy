package mymain;

public class _07_Ex_for2_1부터더하기 {

	public static void main(String[] args) /* throws InterruptedException */ {
		
		int num = 20;
		int sum = 0;
		
		//1+2+3+...+num 구하기
		for(int i = 1; i <= num; i++) 
		{
			System.out.print(i);
			if(i<num) 
				System.out.print('+');
			else
				System.out.print('=');
			//실행시간 지연 - 1초 대기
			/* Thread.sleep(1000); */
			
			sum += i;
		}
		System.out.print(sum);
	}

}
