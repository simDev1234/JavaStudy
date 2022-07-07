package myutil;

import java.util.Arrays;

public class MyArrays2 {
	
	//1~n까지 순서대로 채우는 기능의 메소드
	public static void set_array2(int[][] mm) {
		int k = 1;
		for(int i = 0; i < mm.length; i++) {
			for(int j = 0; j < mm[i].length; j++) {
				mm[i][j] = k++;
			}
		}
	}
	
	//모든 값을 value로 채우기
	public static void fill_array2(int[][] mm, int value) {
		//Arrays.fill(mm, value);
		for(int i = 0; i < mm.length; i++) {
			for(int j = 0; j < mm[i].length; j++) {
				mm[i][j] = value;
			}
		}
	}
	
	//주어진 행(줄)만 value로 채우기
	public static void fill_array2(int[][] mm, int rowIndex, int value) {
		//Arrays.fill(mm[rowIndex], value);
		for(int i = 0; i < mm[rowIndex].length; i++) {
			mm[rowIndex][i] = value;
		}
	}
	
	//주어진 범위의 행 전체 value로 채우기
	public static void fill_array2(int[][] mm, int beginIndex, int endIndex, int value) {
		for(int i = beginIndex; i < endIndex; i++) {
			//Arrays.fill(mm[i], value);
			for(int j = 0; j < mm[i].length; j++) {
				mm[i][j] = value;
			}
		}
	}
	
	public static void display_array2(int[][] mm) {
		/*
		int rows = mm.length; //행갯수
		int cols = mm[0].length; //열갯수
		*/
		for(int i = 0; i < mm.length; i++) {
			for(int j = 0; j < mm[i].length; j++) {
				System.out.printf("%4d",mm[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void display_block(int[][] mm) {
		for(int i = 0; i < mm.length; i++) {
			for(int j = 0; j < mm[i].length; j++) {
				if(mm[i][j]==1) {
					System.out.print("□");
				}else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
	}
}
