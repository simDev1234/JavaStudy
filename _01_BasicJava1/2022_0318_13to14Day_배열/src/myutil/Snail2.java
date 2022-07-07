package myutil;

public class Snail2 {
	//    col		 row		   row		col
	//[우(0~5)->아래(1~5)] -> [좌(4~0)]->[위(3~1)] 
	//[우(1~3)->아래(2~3)] -> [좌(2~1)]->[위(2~2)]
	//[우(2]
	
	int chasu;	
	int[][] snail_array;
	
	public void setChasu(int chasu) {
		this.chasu = chasu;
		
		//달팽이 만들기
		make_snail();
		
		//출력
		display();
	}
	
	private void make_snail() {
		//달팽이 배열 생성
		snail_array = new int[chasu][chasu];
		
		int row = 0;
		int col = -1;
		int su = 1;
		
		for(int k = 0; k < chasu; k++) {
			
		}
	}//end snail()

	public void display() {
		for(int i = 0; i < chasu; i++) {
			System.out.print("[");
			for(int j = 0; j < chasu; j++) {
				System.out.printf("%4d",snail_array[i][j]);
			}
			System.out.print("]");
			System.out.println();
		}//end for()
	}
}//end Snail
