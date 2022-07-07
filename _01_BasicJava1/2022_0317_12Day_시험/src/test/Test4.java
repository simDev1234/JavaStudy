package test;

public class Test4 {
	public static void main(String[] args) {
		String jumin_no = "801212-1234560";
		
		int tmp = 0; //i번째 숫자 임시 저장
		int sum = 0; //곱한 값 축척
		int k = 2;
		for(int i = 0; i < jumin_no.length()-1; i++) {
			if(i==6) continue;
			if(i==9) k = 2;
			tmp = jumin_no.charAt(i)-'0';
			sum += tmp*k++;
		}
		int check_sum = (11-(sum % 11))%10;
		boolean result = (jumin_no.charAt(13)-'0')==check_sum;
		
		if(result) {
			System.out.println("유효한 주민번호");
		}else {
			System.out.println("유효하지 않은 주민번호");
		}
	}
}
