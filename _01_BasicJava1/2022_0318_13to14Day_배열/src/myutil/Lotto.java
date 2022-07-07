package myutil;

import java.util.Arrays;
import java.util.Random;

public class Lotto {
	int[] user_no; //����� ��ȣ
	int[] win_no;  //��÷ ��ȣ
	int count = 0; //���� ����(���ʽ� ����)
	int bonus = 0;
	int rank;
	
	public void setUser_no(int[] user_no) {
		this.user_no = user_no;
		Arrays.sort(user_no);
		make_rank();
	}

	public void makeWinNo() {
		Random random = new Random();
		win_no = new int[7];
		
		int su = 0;
		OUTER : 
		for(int i = 0; i < win_no.length; i++) {
			su = random.nextInt(45)+1;
			
			//�ߺ��� üũ
			for(int j = 0; j < i; j++) {
				if(win_no[j]==su) {
					i--;
					continue OUTER;
				}
			}
			
			win_no[i] = su;
		}
		
		//������ ��ȣ�� ������ �� 6�ڸ� ������������ ��������
		Arrays.sort(win_no, 0, 6);
	}
	
	//��÷��� ���
	public void display() {
		System.out.println("----------[��÷ ���]----------");
		
		//[Win_no]
		System.out.print("��÷ ��ȣ : ");
		for(int i = 0; i < win_no.length-1; i++) {
			System.out.printf("%3d", win_no[i]);
		}
		//���ʽ���ȣ 
		System.out.printf(" (%d)\n",win_no[6]);
		
		//[User_no]
		System.out.print("���� ��ȣ : ");
		for(int i = 0; i < user_no.length; i++) {
			System.out.printf("%3d", user_no[i]);
		}
		System.out.println();
		
		//[��� ���]
		//1�� : 6�� ��ġ, 2�� : 5�� ��ġ + ���ʽ�, 3�� : 5�� ��ġ, 4�� : 4�� ��ġ, 5�� : 3��
		System.out.print("��÷���� : ");
		if(count >= 6 && bonus != 1) {
			rank = 1;
		}else if(count >= 5 && bonus ==1) {
			rank = 2;
		}else if(count >= 5 && bonus != 1){
			rank = 3;
		}else  if(count >= 4) {
			rank = 4;
		}else if(count >= 3) {
			rank = 5;
		}else {
			System.out.print("��!");
		}
		if(rank<=5)
			System.out.printf("%d��",rank);
	}
	
	private void make_rank() {
		//count,bonus�ʱ�ȭ
		if(count > 0 || bonus > 0) {
			this.count = 0;
			this.bonus = 0;
		}
		//1�� : 6�� ��ġ, 2�� : 5�� ��ġ + ���ʽ�, 3�� : 5�� ��ġ, 4�� : 4�� ��ġ, 5�� : 3��
		for(int i = 0; i < user_no.length; i++) {
			for(int j = 0; j < win_no.length; j++) {
				if(j < win_no.length-1) {
					if(user_no[i]==win_no[j])
					count++;
				}else {
					if(user_no[i]==win_no[j])
					bonus++;
				}
			}
		}
	}
}
