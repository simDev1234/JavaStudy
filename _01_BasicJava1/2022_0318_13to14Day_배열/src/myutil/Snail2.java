package myutil;

public class Snail2 {
	//    col		 row		   row		col
	//[��(0~5)->�Ʒ�(1~5)] -> [��(4~0)]->[��(3~1)] 
	//[��(1~3)->�Ʒ�(2~3)] -> [��(2~1)]->[��(2~2)]
	//[��(2]
	
	int chasu;	
	int[][] snail_array;
	
	public void setChasu(int chasu) {
		this.chasu = chasu;
		
		//������ �����
		make_snail();
		
		//���
		display();
	}
	
	private void make_snail() {
		//������ �迭 ����
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
