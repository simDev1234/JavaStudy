import java.io.IOException;

public class _Q02_�������3 {
	public static void main(String[] args) throws IOException {
		
		System.out.print("���� �� ���� �Է��ϼ���. >> ");
		int ch = System.in.read();
		
		if((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')) {
			System.out.println("�����̴�.");
		}else if(ch >= '0' && ch <= '9') {
			System.out.println("�����̴�.");
		}else {
			System.out.println("Ư����ȣ�̴�.");
		}
	}
}
