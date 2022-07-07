package myutil;

public class Mabanjin2 {
	//Ȧ���� ����
	int chasu;
	int[][] ma_array;

	public void setChasu(int chasu) {
		this.chasu = chasu;
		
		//������ �����ϱ�
		make_mabanjin();
		//����ϱ�
		display();
	}
	
	private void make_mabanjin() {
		ma_array = new int[chasu][chasu];
		
		//ó�� ÷���� ��ġ
		int row = 0;
		int col = chasu/2;
		int su = 1;
		
		//ù��° ĭ ä���
		ma_array[row][col] = su++;
		
		//1���� ������ ������ ĭ 
		for(int i = 0; i < chasu*chasu-1; i++) {
			//1.�밢���� �̵���Ų��.
			row--;
			col++;
			//2.4���� ����� �� üũ
			if(row < 0 && col == chasu) {//2-1. ��/�������� ��� �������, �ڱ� �ڽ��� �ٷ� ��
				row+=2;
				col-=1;
			}
			else if(row < 0){//2-2. ���� ���� ���, �� �Ʒ��� �̵�
				row = chasu-1;
			}
			else if(col == chasu){//2-3. �������� ���� ���, ���� �������� �̵�
				col = 0;
			}
			else if(ma_array[row][col]!=0){//2-4. �̹� ���� ä���� ���
				row+=2;
				col-=1;
			}
			
			//3.ĭ ä���
			ma_array[row][col] = su++;
		}
	}

	public void display() {
		//�� ���� �� ������ ����
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
			//�� �հ� ���
			System.out.printf("(%d)",row_sum);
			System.out.println();
		}//end for()
		for(int i = 0; i < col_sum.length; i++)
			System.out.printf("(%4d)",col_sum[i]);
		System.out.println();
	}//end display()
}
