package mymain;

public class _Q1_별찍기 {

	public static void main(String[] args) {
		
		int row = 5;
		int col = 5;
		
		//예제1_정사각형 모양
		for(int i = 0; i < col; i++) {
			for(int j = 0; j < row; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println();
		
		//예제2_반피라미드 모양
		/*
		*
		**
		***
		****
		*****
		*/
		for(int i = 0; i < col; i++) {
			for(int j = 0; j < row; j++) {
				if(i >= j) System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println();
		
		//예제3_역 반피라미드 모양
		/*
		*****
		****
		***
		**
		*
		 */
		for(int i = 0; i < col; i++) {
			for(int j = 0; j < row; j++) {
				if(i <= j) System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println();
		
		
		//예제4_바람개비 모양
		for(int i = 0; i < col; i++) {
			for(int j = 0; j < row; j++) {
				if((i == j) || j == (row-1)-i) 
					System.out.print("X");
				else
					System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
	}

}
