package mymain.output;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class _02_FileOutputTest {
	
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
		
		os.close();
		
	}
	
}
