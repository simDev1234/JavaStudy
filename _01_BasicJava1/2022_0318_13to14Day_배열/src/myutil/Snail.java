package myutil;

public class Snail {
	//Right -> Down -> Left -> Up
	//이 과정을 반복하되,
	//만약 움직이려는 방향에 값이 있을 경우, 현재 자리에서 이동하지 않고,
	 //값을 넣지 않고 방향을 전환한다.
	//Right : col++
	//Down : row++
	//Left : col__
	//Up : row--
	
	//이동 정보에 대한 상수 선언
	public static final int RIGHT = 1;
	public static final int DOWN = 2;
	public static final int LEFT = 3;
	public static final int UP = 4;
	
	//현재 이동 방향 정보를 저장할 변수
	int direction;
	
	int chasu;	
	int[][] snail_array;
	
	public void setChasu(int chasu) {
		this.chasu = chasu;
		
		System.out.println("---snail1---");
		
		//달팽이 만들기
		make_snail();
		
		//출력
		display();
		
		System.out.println("---snail2---");
		
		//달팽이 만들기
		make_snail2();
		
		//출력
		display();
	}
	
	private void make_snail() {
		//달팽이 배열 생성
		snail_array = new int[chasu][chasu];
		
		int row = 0;
		int col = -1;
		int su = 1;
		
		direction = RIGHT;
		
		//[0][0]부터 채워나가기
		for(int i = 0; i < chasu*chasu; i++) {
			if(direction == RIGHT) { //오른쪽 채우기
				col++;
				if(col == chasu || snail_array[row][col]!=0) {//이동하다 막히면
					row++;
					col--;
					direction = DOWN;
				}
			}else if(direction == DOWN) { //아래쪽 채우기
				row++;
				if(row == chasu || snail_array[row][col]!=0) {
					row--;
					col--;
					direction = LEFT;
				}
			}else if(direction == LEFT) { //왼쪽 채우기
				col--;
				if(col < 0 || snail_array[row][col]!=0) {
					row--;
					col++;
					direction = UP;
				}
			}else if(direction == UP) {//위쪽 채우기
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
		//달팽이 배열 생성
		snail_array = new int[chasu][chasu];
		
		int row = 0;
		int col = -1;
		int su = chasu*chasu;
		
		direction = RIGHT;
		
		//[0][0]부터 채워나가기
		for(int i = 0; i < chasu*chasu; i++) {
			if(direction == RIGHT) { //오른쪽 채우기
				col++;
				if(col == chasu || snail_array[row][col]!=0) {//이동하다 막히면
					row++;
					col--;
					direction = DOWN;
				}
			}else if(direction == DOWN) { //아래쪽 채우기
				row++;
				if(row == chasu || snail_array[row][col]!=0) {
					row--;
					col--;
					direction = LEFT;
				}
			}else if(direction == LEFT) { //왼쪽 채우기
				col--;
				if(col < 0 || snail_array[row][col]!=0) {
					row--;
					col++;
					direction = UP;
				}
			}else if(direction == UP) {//위쪽 채우기
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
