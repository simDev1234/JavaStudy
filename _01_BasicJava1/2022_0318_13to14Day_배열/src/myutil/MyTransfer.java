package myutil;

public class MyTransfer {
	//90�� ȸ��
	public static int[][] right_rotate(int[][] src){
		int rows = src.length;
		int cols = src[0].length;
		//������ ������ ũ���� �迭 ����
		int[][] dest = new int[rows][cols];
		
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				dest[i][j] = src[(rows-1)-j][i];
			}
		}
		
		return dest;
	}
	
	//�¿츦 �ٲٱ�
	public static int[][] flip_left_right(int[][] src){
		int rows = src.length;
		int cols = src[0].length;
		//������ ������ ũ���� �迭 ����
		int[][] dest = new int[rows][cols];
		
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				dest[i][j] = src[i][(cols-1)-j];
			}
		}
		
		return dest;
	}
	
	//�� �Ʒ�
	public static int[][] flip_up_down(int[][] src){
		int rows = src.length;
		int cols = src[0].length;
		//������ ������ ũ���� �迭 ����
		int[][] dest = new int[rows][cols];
		
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				dest[i][j] = src[(rows-1)-i][j];
			}
		}
		
		return dest;
	}
	
	//�밢�� diagonal1
		public static int[][] flip_diagonal1(int[][] src){
			int rows = src.length;
			int cols = src[0].length;
			//������ ������ ũ���� �迭 ����
			int[][] dest = new int[rows][cols];
			
			for(int i = 0; i < rows; i++) {
				for(int j = 0; j < cols; j++) {
					dest[i][j] = src[(rows-1)-j][(cols-1)-i];
				}
			}
			
			return dest;
		}
	
	//�밢�� diagonal2
	public static int[][] flip_diagonal2(int[][] src){
		int rows = src.length;
		int cols = src[0].length;
		//������ ������ ũ���� �迭 ����
		int[][] dest = new int[rows][cols];
		
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				dest[i][j] = src[j][i];
			}
		}
		
		return dest;
	}
	
	//�밢�� ���� Ŭ�ν�
	public static int[][] flip_doubleCross(int[][] src){
		int rows = src.length;
		int cols = src[0].length;
		//������ ������ ũ���� �迭 ����
		int[][] dest = new int[rows][cols];
		
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				dest[i][j] = src[(cols-1)-i][(rows-1)-j];
			}
		}
		
		return dest;
	}
}
