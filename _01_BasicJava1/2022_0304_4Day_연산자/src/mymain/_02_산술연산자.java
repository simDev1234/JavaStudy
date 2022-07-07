package mymain;

public class _02_산술연산자 {

	public static void main(String[] args) {
		//2. 산술연산자 : + , - , * , /(몫) , %(나머지)
		int x = 10, y = 3, z;
		
		z = x + y;
		System.out.printf("%d + %d = %d\n", x, y, z);
		
		z = x - y;
		System.out.printf("%d - %d = %d\n", x, y, z);
		
		z = x * y;
		System.out.printf("%d * %d = %d\n", x, y, z);
		
		//몫 - 연산되는 자료형에 따라서 정확히 몫을 구할 수도 있고, 나눈 값을 구할 수도 있음.
		      //int/int = int <-몫
		      //double/int = double/double = 2.344246 <- 나눈 값
		z = x / y;
		System.out.printf("%d / %d = %d\n", x, y, z);
		
		//나머지
		z = x % y;
		System.out.printf("%d %% %d = %d\n", x, y, z); //%를 문자로 인식시키려면, %% -> '%'
		
		//cf) Format 서식 내에서 "를 문자로 인식시키려면, 앞에 \붙이기
		System.out.println("나는 \"봄\"이 너무 좋다");
		//cf) Format 서식 내에서 \를 문자로 인식시키려면, 앞에 \붙이기
		System.out.println("나는 \\봄\\이 너무 좋다");
		
		//몫 예시) double, int 나눌 경우
		System.out.println(10.0/3); //나눈 값(double형태)
		System.out.println((int)10.0/3); //몫(int형태)
		System.out.println((int)10.0/3.0); //나눈 값(double형태)
		System.out.println((int)(10.0/3.0)); //나눈 값(double형태)
		
		//나머지 예시)
		System.out.println(10.0%3); //double의 나머지 : 1.0실수로 나옴
		 //피젯수 < 젯수 => 젯수
		System.out.println(3%10); //int의 나머지 3 (몫은 0)
		
		//Java에서는 int형보다 작은 형끼리 연산되면 결과는 int형이 나옴. 
		//byte + byte -> int
		//short + short -> int
		//byte + short -> int
		byte b1 = 1;
		byte b2 = 2;
		byte b3;
		
		// b3 = b1 + b2; <-- 에러발생 ) byte + byte -> int **Java가 short나 byte모두 연산하면 int로 바꿈
		b3 = (byte)(b1+b2);
		
		short s1 = 1;
		short s2 = 2;
		short s3;
		
		//s3 = s1 + s2; 
		s3 = (short)(s1 + s2);
		s3 = (short)(b1 + s1);
	}

}
