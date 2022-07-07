package mymain.output;

import java.io.OutputStream;

public class _01_MonitorTest {

	public static void main(String[] args) throws Exception {
		
		OutputStream os = System.out;
		
		os.write(65); //문자출력 to 출력버퍼
		
		String msg = "안녕";
		//String -> byte[]로 추출
		byte[] msg_bytes = msg.getBytes();
		os.write(msg_bytes);
		
		int n = 123;
		String s = String.valueOf(n);
		os.write(s.getBytes());
		
		boolean bOk = true;
		os.write(String.valueOf(bOk).getBytes());
		
		os.flush(); //flush : 출력버퍼를 비우면서 --> 콘솔로 보내라
		
	}

}
