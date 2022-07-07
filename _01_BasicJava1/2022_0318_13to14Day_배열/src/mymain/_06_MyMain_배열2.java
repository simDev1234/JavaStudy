package mymain;

import myutil.MyArrays2;

public class _06_MyMain_배열2 {

	public static void main(String[] args) {
		int[][] mm = new int[3][4];
		/*
		mm[0][0] = 1;
		mm[0][1] = 2;
		mm[0][2] = 3;
		mm[0][3] = 4;
		mm[1][0] = 5;
		mm[1][1] = 6;
		mm[1][2] = 7;
		mm[1][3] = 8;
		mm[2][0] = 9;
		mm[2][1] = 10;
		mm[2][2] = 11;
		mm[2][3] = 12;
		*/
		
		//셋팅
		MyArrays2.set_array2(mm);
		
		//출력
		MyArrays2.display_array2(mm);
		
		MyArrays2.fill_array2(mm, 0);
		MyArrays2.display_array2(mm);
		
		MyArrays2.fill_array2(mm, 2, 3);
		MyArrays2.display_array2(mm);
		
		MyArrays2.fill_array2(mm, 0, 1, 2);
		MyArrays2.display_array2(mm);
	}

}
