package mymain;

import java.io.FileReader;
//import java.io.IOException;

public class _11_Ex_while2_화일읽기 {

	public static void main(String[] args) throws Exception {
		
		FileReader fr = new FileReader("a.txt"); //file 열기
		
		int ch;
		int cnt = 0; //문자갯수
		while(true)
		{
			//cnt++; <-- 여기에 둘 경우, 반복횟수
			/*
			 실제로 읽은 텍스트 : A, \r, \, B, (EOF) 총 5개 읽음
			 
			 A\r\n
			 B(EOF)
			 */
			ch = fr.read(); //문자 1개 int로 읽어오기
			
			//EOF(End of File) - txt파일에서 끝을 표시할 때 -1로 표시
			if(ch == -1) break; //break : 반복문, switch 탈출문
			
			cnt++; //EOF제외 총 문자수 -- 4개
			
			System.out.printf("%c",ch);
			//Thread.sleep(100);	
		}
		System.out.println("\r\ncnt : "+cnt);
		
		fr.close(); //file 닫기 (다음 프로그램서도 file에 접근가능하게)
		
		//디버깅할 때, 이클립스에서 Run>Debug 
		//F5:step into - 메소드 안으로 진입
		//F6:step over - Toggle Breakpoint에서 하나씩 실행하기
	}

}
