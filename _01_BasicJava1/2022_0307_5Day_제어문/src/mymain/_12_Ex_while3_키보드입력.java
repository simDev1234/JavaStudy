package mymain;

import java.io.IOException;

public class _12_Ex_while3_키보드입력 {

	public static void main(String[] args) throws IOException {
		//키보드 표준장치명 : System.in (byte씩 입력)
		  //사용자가 언제 끝낼 지 결정 - 개발자는 반복횟수 알 수 없음
		
		int ch;
		int count = 0; //총 입력 문자수
		
		System.out.println("값을 입력하세요(종료 : Ctrl + Z)");
		
		while(true)
		{
			ch = System.in.read(); //키보드 버퍼로부터 1byte씩 읽음(키보드버퍼는 OS에서 처리하는 1byte이고, 자바로 가져올 때는 2byte. 자바의 자료형일 때 char이 2byte)
								   //가져올땐 int형
			if(ch == -1) break; //Ctrl+Z일때, read메소드가 -1를 반환
			
			count++;
			
			System.out.printf("%c",ch);
		}
		System.out.printf("입력한 문자수 : %d\n",count);
		System.out.println("-----[END]-----");
		
		//white문자 : 눈으로 확인할 수 없는 문자(\r,\n,\t,'')
	}

}
