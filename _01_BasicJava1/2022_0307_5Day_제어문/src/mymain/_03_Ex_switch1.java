package mymain;

import java.util.Scanner;

public class _03_Ex_switch1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String fruit; //���ϸ�
		String res = ""; //result
		
		System.out.print("���ϸ� : ");
		fruit = scanner.next();
		
		
		//if(fruit.equals("����"))
		switch (fruit) 
		{
			case "����" : res="�޴�";     break;
			case "����" : res="�ÿ��ϴ�"; break;
			case "����" : res="���ִ�";   break;
			case "����" : res="�˾Ƶ�";   break;
			default:      res="������";
			//default�� ��� ����� ���̶� break �ʿ� ����
		}
		//������ break�� ��� �����ϸ� � �� �ĵ� "������"�� ����
		//why? ���� "����"�� ġ�� res="�޴�"�ϰ�, res="�ÿ��ϴ�"... res="������"���� ��ɼ���
		System.out.printf("[%s]��(��) [%s]\n",fruit,res);
		
		scanner.close();
	}

}
