package mymain;

public class _03_MyMain_배열1_활용2{

	public static void main(String[] args){
		String[] gan_arr = {"경","신","임","계","갑","을","병","정"};
		String[] ji_arr = {"신","유","술","해","자","축","인","묘","진","사","오","미"};
		
		int birthYear = 1993;
		
		System.out.printf("%s%s",gan_arr[birthYear%10],ji_arr[birthYear%12]);

	}

}
