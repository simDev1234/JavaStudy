package mymain;

public class _03_MyMain_�迭1_Ȱ��2{

	public static void main(String[] args){
		String[] gan_arr = {"��","��","��","��","��","��","��","��"};
		String[] ji_arr = {"��","��","��","��","��","��","��","��","��","��","��","��"};
		
		int birthYear = 1993;
		
		System.out.printf("%s%s",gan_arr[birthYear%10],ji_arr[birthYear%12]);

	}

}
