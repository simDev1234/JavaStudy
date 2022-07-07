package mymain.output;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class _02_FileOutputTest2 {
	
	public static void main(String[] args) throws Exception{
		
		OutputStream os = new FileOutputStream("a.txt");
		
		os.write('A'); //파일은 write만 해도 들어감
		
		String msg = "안녕";
		//String -> byte[]로 추출
		byte[] msg_bytes = msg.getBytes();
		os.write(msg_bytes);
		
		int n = 123;
		String s = String.valueOf(n);
		os.write(s.getBytes());
		
		boolean bOk = true;
		os.write(String.valueOf(bOk).getBytes());
		
		//PrintStream필터
		PrintStream out = new PrintStream(os);
		out.println();
		out.println("일단 정신 붙잡고 정석 공부하자. 할 수 있다.");
		
		int age = 20;
		String name = "홍길동";
		
		out.printf("이름 : %s%n", name);
		out.printf("나이 : %d(살)%n", age);
		
		os.close();
		
	}
	
}
