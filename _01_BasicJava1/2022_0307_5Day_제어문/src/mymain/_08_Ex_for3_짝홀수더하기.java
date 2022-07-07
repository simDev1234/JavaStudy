package mymain;

public class _08_Ex_for3_짝홀수더하기 {

	public static void main(String[] args) {
		
		int sum = 0;
		int num = 10;
		
		for(int i = 1; i <= num; i++) 
		{
			sum += i;
		}
		System.out.println("양의 정수의 합 : "+sum);
		
		sum = 0;
		
		//1~num 중 짝수를 더하기 - 방법1_if문으로 제한_1 (2) 3 (4) 5 (6)...
		for(int i = 1; i <= num; i++) 
		{
			if(i % 2 == 0) {
				sum += i;
			}
		}
		System.out.println("2의 배수의 합 : "+sum);
		
		sum = 0;
		
		//1~num 중 짝수를 더하기 - 방법2_for문 내 증감식활용
		for(int i = 0; i <= num; i+=2) 
		{
			sum += i;
		}
		System.out.println("2의 배수의 합 : "+sum);
		
		sum = 0;
		
		//1~num 중 홀수의 합 
		for(int i = 1; i <=num; i+=2)
		{
			sum += i;
		}
		System.out.println("홀수의 합 : "+sum);
	}

}
