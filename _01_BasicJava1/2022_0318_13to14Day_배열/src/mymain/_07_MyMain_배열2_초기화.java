package mymain;

import java.util.Arrays;

import myutil.MyArrays2;

public class _07_MyMain_배열2_초기화 {

	public static void main(String[] args) {
		//배열의 초기화는 갯수(행/열)부분 생략
		int[][] mm = new int[][] {
			{ 1, 2, 3, 4},
			{ 5, 6, 7, 8},
			{ 9,10,11,12}
		};
		System.out.println(Arrays.toString(mm));
		System.out.println(Arrays.toString(mm[0]));
		MyArrays2.display_array2(mm);
		
		int[][] block_t = {
				{1,1,1},
				{0,1,0},
				{0,1,0}
		};
		
		int[][] block_l = {
				{1,0,0},
				{1,0,0},
				{1,1,1}
		};
		
		System.out.println("-----[T-Block]-----");
		MyArrays2.display_block(block_t);
		System.out.println("-----[L-Block]-----");
		MyArrays2.display_block(block_l);
	}

}
