package mymain;

public class _10_Ex_while1 {

	public static void main(String[] args) {
		
		//"안녕" 세번 반복 출력
		//while문 : for문에서 초기식과 증감식이 생략된 형태
		int i = 0;
		
		while(i < 3)
		{
			System.out.println("안녕");
			i++;
		}
		
		System.out.println(i);
		
		/*
		int i = 0;
		//for문에서 초기식, 증감식 생략가능
		for(; i < 3;) 
		{
			System.out.println("안녕");
			i++; // <--이게 없으면 무한루프
		}
		*/
		
		//for   문 : 반복횟수를 알 때
		//while 문 : 반복횟수를 모를 때(화일처리/키보드입력)
		 /* 
		  --> 사용자가 file을 선택하여 읽을 것
		  --> 개발자는 file에  
		      몇개의 글자수가 있을지 모른다. 
		  --> 이럴 경우, while문으로 file의 끝까지 읽어라 명령*/
	}

}
