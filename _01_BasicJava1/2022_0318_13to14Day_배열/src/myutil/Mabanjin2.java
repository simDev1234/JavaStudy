package myutil;

public class Mabanjin2 {
	//홀수일 때만
	int chasu;
	int[][] ma_array;

	public void setChasu(int chasu) {
		this.chasu = chasu;
		
		//마방진 생성하기
		make_mabanjin();
		//출력하기
		display();
	}
	
	private void make_mabanjin() {
		ma_array = new int[chasu][chasu];
		
		//처음 첨자의 위치
		int row = 0;
		int col = chasu/2;
		int su = 1;
		
		//첫번째 칸 채우기
		ma_array[row][col] = su++;
		
		//1개를 제외한 나머지 칸 
		for(int i = 0; i < chasu*chasu-1; i++) {
			//1.대각으로 이동시킨다.
			row--;
			col++;
			//2.4가지 경우의 수 체크
			if(row < 0 && col == chasu) {//2-1. 위/우측으로 모두 나간경우, 자기 자신의 바로 밑
				row+=2;
				col-=1;
			}
			else if(row < 0){//2-2. 위로 나간 경우, 맨 아래로 이동
				row = chasu-1;
			}
			else if(col == chasu){//2-3. 우측으로 나간 경우, 가장 좌측으로 이동
				col = 0;
			}
			else if(ma_array[row][col]!=0){//2-4. 이미 값이 채워진 경우
				row+=2;
				col-=1;
			}
			
			//3.칸 채우기
			ma_array[row][col] = su++;
		}
	}

	public void display() {
		//각 열의 합 저장할 변수
		int[] col_sum = new int[ma_array[0].length];
		for(int i = 0; i < chasu; i++) {
			int row_sum = 0;
			System.out.print("[");
			for(int j = 0; j < chasu; j++) {
				System.out.printf("%4d",ma_array[i][j]);
				row_sum += ma_array[i][j];
				col_sum[j]+=ma_array[i][j];
			}
			System.out.print("]");
			//행 합계 출력
			System.out.printf("(%d)",row_sum);
			System.out.println();
		}//end for()
		for(int i = 0; i < col_sum.length; i++)
			System.out.printf("(%4d)",col_sum[i]);
		System.out.println();
	}//end display()
}
