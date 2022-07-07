package mymain;

public class test {

	public static void main(String[] args) {
		String jumin_no = "930705-2050222";
		int sum = 0;
		int tmp = 0;
		int k = 2;
		int check_sum;
		
		for(int i = 0; i < jumin_no.length()-1; i++) {
			tmp = jumin_no.charAt(i) - '0';
			if(i == 6) continue;
			if(i == 9) k = 2;
			sum += (tmp * k++);
		}
		
		check_sum = (11-(sum % 11))%10;
		
		System.out.println(check_sum);
	}

}
