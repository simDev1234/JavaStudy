package mymain;

import java.util.Arrays;

public class _10_Question_Mabanjin {
	public static void main(String[] args) {
		/*
		[마방진 원리]

		대각선으로 이동하라(plus -1 on row +1 on col)

		만약 바둑판의 행과 열을 모두 벗어날 경우(row<0,col>Max) 자기자신의 아래로 가라
		그렇지 않고 바둑판의 행을 벗어날경우(row<0) row의 가장 아래로 가라
		그렇지 않고 열을 벗어날 경우(col>Max), col의 가장 왼쪽으로 가라 
		그렇지 않고 (대각선 이동은 가능하나) 그 자리에 다른 값이 있을 경우 자기 자신의 아래로 가라 
		
		해당 위치에 다음 숫자를 넣어라
		
		*/
		int[][] testArr = new int[5][5];
		Mabanjin.makeStartPoint(testArr);
		for(int i = 0; i < testArr.length; i++) {
			System.out.println(Arrays.toString(testArr[i]));
		}
		System.out.println();
		Mabanjin.mabanjin(testArr);
		for(int i = 0; i < testArr.length; i++) {
			System.out.println(Arrays.toString(testArr[i]));
		}
	}
	
}

class Mabanjin{
	public static void makeStartPoint(int[][] arr) {
		//배열 값 초기화, 시작 포인트 1로 잡기
		for(int i = 0; i < arr.length; i++) {
			Arrays.fill(arr[i], 0);
		}
		arr[0][arr[0].length/2] = 1;
	}
	public static int[][] mabanjin(int[][] arr) {
		final int ROW_MAX = arr.length;
		final int COL_MAX = arr[0].length;
		
		//배열 안에 넣을 리터럴(1부터 ~ n)
		int n = 1;
		
		//이동 포인트
		int r = 0;
		int c = arr[0].length/2;
		
		for(int i = 0; i < ROW_MAX*COL_MAX-1; i++) {
			r -= 1;
			c += 1;
			if(r < 0 && c > COL_MAX-1) {
				r = r + 2;
				c = c - 1;
			}else if(r < 0) {
				r = r+ROW_MAX;
			}else if(c > COL_MAX-1) {
				c = COL_MAX-c;
			}else if(arr[r][c] > 0) {
				r = r + 2;
				c = c - 1;
			}
			
			arr[r][c] = ++n;
			
		}
		
		return arr;
	}
	
}