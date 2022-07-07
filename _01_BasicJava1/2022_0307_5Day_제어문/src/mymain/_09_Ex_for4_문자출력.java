package mymain;

public class _09_Ex_for4_문자출력 {

	public static void main(String[] args) {
		
		//A부터 Z까지 출력
		//A : 65 ~ Z : 90
		
		/* for(int i = 65; i <= 90; i++) */
		//방법1. 
		//A,B...문자 상수 --> ASCII코드 65,66...
		//int형은 4byte = charater형은 2byte. **반대의 경우, 에러 가능성
		for(int i = 'A'; i <= 'Z'; i++)
		{
			System.out.printf("%c",i);
		}
		System.out.println();
		
		//방법2. 'A'+0, 'A'+1, 'A'+2...
		for(int i = 0; i < 26; i++)
		{
			System.out.printf("%c",'A'+i); 
	        //출력메서드에서, %c에 정수형 넣은 것 가능, %d에 'A'를 넣을 순 없음
		}
		System.out.println();
		
		
		//AbCdEf...출력
		//A = 65, a = 97 //대문자 - 소문자 = 32
		//A(b)C(d)E(f)... 65 (66) 67 (68) 69 (70)... 홀 (짝) 홀 (짝)...
		for(int i = 'A'; i <= 'Z'; i++)
		{
			if(i % 2 == 1)
				System.out.printf("%c",i);
			else
				System.out.printf("%c",i+32);
		}
		System.out.println();
		
		//AbcDefGhiJ...
		//0123456789.. i가 3의 배수일 때 
		for(int i = 0; i < 26; i++)
		{
			if(i % 3 == 0)
				System.out.printf("%c",'A'+i);
			else
				System.out.printf("%c",'a'+i);
		}
		System.out.println();
		
		//ABC-DEF-GHI-....
		//012-345-678  
		char delim = '-';
		for(int i = 0; i < 26; i++)
		{
			if(i % 3 == 2)
				System.out.printf("%c%c",'A'+i,delim);
			else
				System.out.printf("%c",'A'+i);
		}
		System.out.println();

		//위와 동일한 코드
		/*
		for(int i = 0; i < 26; i++)
		{
			System.out.printf("%c",'A'+i);
			
			if(i % 3 == 2)
				System.out.print('-');
		}
		System.out.println(); 
		*/
	}

}
