package mymain;

import java.util.Arrays;

import myutil.MyArrays2;

public class _08_MyMain_배열2_고정길이_가변길이배열 {

	public static void main(String[] args) {
		//고정길이배열 : 길이가 동일한 배열 (사각형모양)
		int[][] mm = new int[3][4];
		
		//가변길이배열 : 길이가 서로 틀린 배열
		int[][] nn = new int[3][];
		nn[0] = new int[2];
		nn[1] = new int[3];
		nn[2] = new int[4];
		MyArrays2.set_array2(nn);
		MyArrays2.display_array2(nn);
		
		int[][] qq = {
				{1,2},
				{3,4,5},
				{6,7,8,9}
		};
		
		//가변길이 초기화
		
		int[][] rr = new int[3][];
		rr[0] = new int[] {1, 2};
		//rr[1] = {3, 4, 5}  (x) -- 대입(치환)개념(초기화개념이 아님)
		rr[1] = new int[] {3, 4, 5};
	}

}
