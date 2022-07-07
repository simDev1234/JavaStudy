package myutil;

public class MyTransfer {
	//90도 회전
	public static int[][] right_rotate(int[][] src){
		int rows = src.length;
		int cols = src[0].length;
		//원본과 동일한 크기의 배열 생성
		int[][] dest = new int[rows][cols];
		
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				dest[i][j] = src[(rows-1)-j][i];
			}
		}
		
		return dest;
	}
	
	//좌우를 바꾸기
	public static int[][] flip_left_right(int[][] src){
		int rows = src.length;
		int cols = src[0].length;
		//원본과 동일한 크기의 배열 생성
		int[][] dest = new int[rows][cols];
		
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				dest[i][j] = src[i][(cols-1)-j];
			}
		}
		
		return dest;
	}
	
	//위 아래
	public static int[][] flip_up_down(int[][] src){
		int rows = src.length;
		int cols = src[0].length;
		//원본과 동일한 크기의 배열 생성
		int[][] dest = new int[rows][cols];
		
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				dest[i][j] = src[(rows-1)-i][j];
			}
		}
		
		return dest;
	}
	
	//대각선 diagonal1
		public static int[][] flip_diagonal1(int[][] src){
			int rows = src.length;
			int cols = src[0].length;
			//원본과 동일한 크기의 배열 생성
			int[][] dest = new int[rows][cols];
			
			for(int i = 0; i < rows; i++) {
				for(int j = 0; j < cols; j++) {
					dest[i][j] = src[(rows-1)-j][(cols-1)-i];
				}
			}
			
			return dest;
		}
	
	//대각선 diagonal2
	public static int[][] flip_diagonal2(int[][] src){
		int rows = src.length;
		int cols = src[0].length;
		//원본과 동일한 크기의 배열 생성
		int[][] dest = new int[rows][cols];
		
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				dest[i][j] = src[j][i];
			}
		}
		
		return dest;
	}
	
	//대각선 더블 클로스
	public static int[][] flip_doubleCross(int[][] src){
		int rows = src.length;
		int cols = src[0].length;
		//원본과 동일한 크기의 배열 생성
		int[][] dest = new int[rows][cols];
		
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				dest[i][j] = src[(cols-1)-i][(rows-1)-j];
			}
		}
		
		return dest;
	}
}
