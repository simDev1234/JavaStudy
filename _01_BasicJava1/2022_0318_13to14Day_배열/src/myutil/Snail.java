package myutil;

public class Snail {
	//Right -> Down -> Left -> Up
	//�� ������ �ݺ��ϵ�,
	//���� �����̷��� ���⿡ ���� ���� ���, ���� �ڸ����� �̵����� �ʰ�,
	 //���� ���� �ʰ� ������ ��ȯ�Ѵ�.
	//Right : col++
	//Down : row++
	//Left : col__
	//Up : row--
	
	//�̵� ������ ���� ��� ����
	public static final int RIGHT = 1;
	public static final int DOWN = 2;
	public static final int LEFT = 3;
	public static final int UP = 4;
	
	//���� �̵� ���� ������ ������ ����
	int direction;
	
	int chasu;	
	int[][] snail_array;
	
	public void setChasu(int chasu) {
		this.chasu = chasu;
		
		System.out.println("---snail1---");
		
		//������ �����
		make_snail();
		
		//���
		display();
		
		System.out.println("---snail2---");
		
		//������ �����
		make_snail2();
		
		//���
		display();
	}
	
	private void make_snail() {
		//������ �迭 ����
		snail_array = new int[chasu][chasu];
		
		int row = 0;
		int col = -1;
		int su = 1;
		
		direction = RIGHT;
		
		//[0][0]���� ä��������
		for(int i = 0; i < chasu*chasu; i++) {
			if(direction == RIGHT) { //������ ä���
				col++;
				if(col == chasu || snail_array[row][col]!=0) {//�̵��ϴ� ������
					row++;
					col--;
					direction = DOWN;
				}
			}else if(direction == DOWN) { //�Ʒ��� ä���
				row++;
				if(row == chasu || snail_array[row][col]!=0) {
					row--;
					col--;
					direction = LEFT;
				}
			}else if(direction == LEFT) { //���� ä���
				col--;
				if(col < 0 || snail_array[row][col]!=0) {
					row--;
					col++;
					direction = UP;
				}
			}else if(direction == UP) {//���� ä���
				row--;
				if(snail_array[row][col]!=0) {
					row++;
					col++;
					direction = RIGHT;
				}
			}
			
			snail_array[row][col] = su++;
		}//end for()
	}//end snail()
	
	private void make_snail2() {
		//������ �迭 ����
		snail_array = new int[chasu][chasu];
		
		int row = 0;
		int col = -1;
		int su = chasu*chasu;
		
		direction = RIGHT;
		
		//[0][0]���� ä��������
		for(int i = 0; i < chasu*chasu; i++) {
			if(direction == RIGHT) { //������ ä���
				col++;
				if(col == chasu || snail_array[row][col]!=0) {//�̵��ϴ� ������
					row++;
					col--;
					direction = DOWN;
				}
			}else if(direction == DOWN) { //�Ʒ��� ä���
				row++;
				if(row == chasu || snail_array[row][col]!=0) {
					row--;
					col--;
					direction = LEFT;
				}
			}else if(direction == LEFT) { //���� ä���
				col--;
				if(col < 0 || snail_array[row][col]!=0) {
					row--;
					col++;
					direction = UP;
				}
			}else if(direction == UP) {//���� ä���
				row--;
				if(snail_array[row][col]!=0) {
					row++;
					col++;
					direction = RIGHT;
				}
			}
			
			snail_array[row][col] = su--;
		}//end for()
	}

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
