package mymain;

import java.util.ArrayList;
import java.util.List;

import myutil.MyArrayList;

public class _02_ListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> sido_list = new ArrayList<String>();
		sido_list.add("����");
		sido_list.add("����");
		sido_list.add("����");
		sido_list.add("����");
		sido_list.add("�ϳ�");
		sido_list.add("�ε�");
		sido_list.add("����");
		sido_list.add("�ϰ�");
		sido_list.add("����");
		
		System.out.println(sido_list);
		
		System.out.println("----[���� Loop]----");
		for(String sido : sido_list) {
			System.out.println(sido);
		}
		
		System.out.println("----[÷��]----");
		for(int i = 0; i < sido_list.size(); i++) {
			String s = sido_list.get(i);
			System.out.printf("%d:%s%n",i,s);
		}
		
		//---���� ���� ���׸�
		//Ŭ���� ������ Generic Type�� ��ü ������ �� ������
		MyArrayList<String> fruit_list = new MyArrayList<String>();
		fruit_list.add("���");
		fruit_list.add("����");
		fruit_list.add("����");
		fruit_list.add("����");
		fruit_list.add("����");
		
		MyArrayList<Integer> su_list = new MyArrayList<Integer>();
		
	}

}
