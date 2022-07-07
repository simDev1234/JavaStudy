import java.io.IOException;

public class _Q05_제어문연습5 {
	public static void main(String[] args) throws IOException {
		int ch;
		
		String[] nation = {"America","Bangladesh", "Canada", "Demmark","Ezypt", "France", 
				"Greece","Hungary","Iceland","Jamaica","Korea",
				"Lebanon","Malta","North Korea","Oman","Peru","Qatar","Romania","Singapore",
				"Thailand","Uganda","Vietnam","W로 시작하는 나라는 없습니다.","X로 시작하는 나라는 없습니다.","Yemen","Zambia"};
		String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		System.out.print("문자 한 개를 입력하세요. >> ");
		ch = System.in.read();
		
		for(int i = 0; i < nation.length; i++) {
			//소문자 -> 대문자
			if(ch >= 'a' && ch <= 'z') {
				ch = ch - 32;
			}
			
			if(ch == alpha.charAt(i)) {
				System.out.println(nation[i]);
			}
		}
	}
}
