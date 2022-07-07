package mymain;

public class _09_삼항연산자 {
	public static void main(String[] args) {
		//6. 삼항연산자 
		//형식 ) (조건) ? 값1(참) : 값2(거짓)
		
		//두 수 중에 큰 수 구하기
		int a = 3;
		int b = 2;
		int c;
		
		c = (a > b) ? a : b; 
		System.out.printf("%d와 %d 중에 큰 수는 %d\n",a,b,c);
		//위 식을 if문으로 구현
		if(a > b) {
			c = a;
		}else {
			c = b;
		}
		    //위의 경우, 제어문 보다는 삼항 연산자가 더 처리속도가 빠름..
		
		//절대값 구하기
		int n = -10;
		int m = (n < 0)? -n : n;
		System.out.printf("|%d| = %d\n",n,m);
	}

}
