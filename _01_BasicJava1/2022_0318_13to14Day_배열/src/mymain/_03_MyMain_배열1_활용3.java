package mymain;

public class _03_MyMain_�迭1_Ȱ��3{

	public static void main(String[] args){
		String gan = "����Ӱ谩����������";
		String ji = "�������������ι��������";
		
		int birthYear = 1993;
		
		String ganji = String.format("%c%c",gan.charAt(birthYear%10),ji.charAt(birthYear%12));
		System.out.printf("�¾ ���� ���� : %s",ganji);
	}

}
