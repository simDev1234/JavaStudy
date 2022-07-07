package mymain;

import java.io.IOException;

public class _12_Ex_while3_키보드입력2 {

	public static void main(String[] args) throws IOException {
		//키보드 표준장치명 : System.in (byte씩 입력)
		  //사용자가 언제 끝낼 지 결정 - 개발자는 반복횟수 알 수 없음
		
		int ch;
		int total_count = 0; //총 입력 문자수
		int number_count = 0; //숫자문자 갯수
		int alpha_upper_count = 0; //대문자 갯수
		int alpha_lower_count = 0; //소문자 갯수
		int white_count = 0; //white문자 갯수 : (\r,\n,\t,'')
		int etc_count = 0; //나머지 문자 갯수
		
		System.out.println("값을 입력하세요(종료 : Ctrl + Z)"); 
		//운영체제의 CL(명령 라인)에서 Ctrl+z는 종료의 단축키
		
		while(true)
		{
			ch = System.in.read(); 
			
			if(ch == -1) break; //System.in.read()가 -1반환
			
			//총 입력 갯수 카운트(EOF 제외)
			total_count++;

			//수문자 갯수 카운트
			if(ch >= '0' && ch <= '9') 
				number_count++;
			
			//대문자 갯수 카운트
			else if(ch >= 'A' && ch <= 'Z') 
				alpha_upper_count++;
			
			//소문자 갯수 카운트
			else if(ch >= 'a' && ch <= 'z') 
				alpha_lower_count++;
			
			//白문자 갯수 카운트
			else if(ch == '\r' || ch == '\n' || ch == '\t'  || ch == ' ') 
				white_count++;
			
			//나머지 갯수 카운트
			else
				etc_count++;
			
			System.out.printf("%c",ch);
		}
		System.out.printf("전  체 갯수 : %2d\n",total_count);
		System.out.printf("숫  자 갯수 : %2d\n",number_count);
		System.out.printf("대문자 갯수 : %2d\n",alpha_upper_count);
		System.out.printf("소문자 갯수 : %2d\n",alpha_lower_count);
		System.out.printf("화이트 갯수 : %2d\n",white_count);
		System.out.printf("나머지 갯수 : %2d\n",etc_count);
		System.out.println("-----[END]-----");
		
		
	}

}
