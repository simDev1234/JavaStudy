import java.io.IOException;

public class _Q05_�������5 {
	public static void main(String[] args) throws IOException {
		int ch;
		
		String[] nation = {"America","Bangladesh", "Canada", "Demmark","Ezypt", "France", 
				"Greece","Hungary","Iceland","Jamaica","Korea",
				"Lebanon","Malta","North Korea","Oman","Peru","Qatar","Romania","Singapore",
				"Thailand","Uganda","Vietnam","W�� �����ϴ� ����� �����ϴ�.","X�� �����ϴ� ����� �����ϴ�.","Yemen","Zambia"};
		String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		System.out.print("���� �� ���� �Է��ϼ���. >> ");
		ch = System.in.read();
		
		for(int i = 0; i < nation.length; i++) {
			//�ҹ��� -> �빮��
			if(ch >= 'a' && ch <= 'z') {
				ch = ch - 32;
			}
			
			if(ch == alpha.charAt(i)) {
				System.out.println(nation[i]);
			}
		}
	}
}
