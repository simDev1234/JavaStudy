import java.io.IOException;

public class _Q02_제어문연습3 {
	public static void main(String[] args) throws IOException {
		
		System.out.print("문자 한 개를 입력하세요. >> ");
		int ch = System.in.read();
		
		if((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')) {
			System.out.println("문자이다.");
		}else if(ch >= '0' && ch <= '9') {
			System.out.println("숫자이다.");
		}else {
			System.out.println("특수기호이다.");
		}
	}
}
