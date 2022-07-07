package mymain;

import myutil.MyArrays;

public class _02_MyMain_배열1_초기화 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n;
		n = 10; //치환(대입)
		int m = 10; //초기화 
		
		//배열 초기화 : 초기화시에는 반드시 갯수 생략
		int[] ar = new int[] {1, 2, 3, 4}; //원칙
		int[] ar2 = {1, 2, 3, 4}; // new int[] 부분 생략 가능
		
		MyArrays.display_array(ar);
	}

}
